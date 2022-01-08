package com.SplitSmart.Logic;

import com.SplitSmart.Application.MainScene.BillView;
import com.SplitSmart.Application.MainScene.MainView;
import com.SplitSmart.Application.MainScene.NewView;
import com.SplitSmart.Logic.ActionObserver.ActionAgency;
import com.SplitSmart.Logic.ActionObserver.ActionChannel;
import com.SplitSmart.Logic.ActionObserver.UserAction;
import com.SplitSmart.Logic.ActionObserver.ServiceAction;
import com.SplitSmart.Model.Connector;
import com.SplitSmart.Model.Person;
import com.SplitSmart.Model.Receipt;
import com.SplitSmart.Repository.ConnectorRepository;
import com.SplitSmart.Repository.Data.SplitSmartContext;
import com.SplitSmart.Repository.PersonRepository;
import com.SplitSmart.Repository.ReceiptRepository;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainService extends ActionChannel<UserAction> {
    private final SplitSmartContext ctx = SplitSmartContext.GetInstance();

    private final ActionAgency<ServiceAction> serviceObserver;
    private final ActionAgency<UserAction> observer;

    //Runtime specific user data
    private final Person user;
    private final ArrayList<Receipt> allReceipts;
    private Receipt selectedReceipt;
    private Connector selectedConnector;    // Matches user !AND! receipt

    public MainService(ActionAgency<ServiceAction> sObserver, Person user){
        this.serviceObserver = sObserver;
        this.observer = new ActionAgency<>();
        observer.subscribe(this);

        this.user = user;
        this.allReceipts = new ReceiptRepository(ctx).GetAll();
    }

    @Override
    public void Notify(UserAction happenedEvent) {
        super.Notify(happenedEvent);
        switch (happenedEvent){
            case Default -> provideView("Main");
            case AddReceipt -> provideView("AddReceipt");
            case PayDebt -> payDebt();
            case ShowSummary -> provideView("ShowSummary");
            case LogOut -> serviceObserver.update(ServiceAction.LoggedOut);
        }
    }

    @Override
    public void Notify(UserAction happenedEvent, Object param) {
        super.Notify(happenedEvent);
        switch (happenedEvent){
            case DeleteUser -> {
                if ((boolean)param){
                    deleteUser();
                }
                else {
                    provideView("Main");
                }
            }
            case ShowReceipt -> provideView("ShowReceipt", param);
        }
    }

    public void InitiateService(){
        this.observer.update(UserAction.Default);
    }

    private void provideView(String neededView, Object... param){
        switch (neededView){
            case "Main" -> {
                MainView mainView = new MainView(this.observer, user, allReceipts);
                mainView.displayView();
            }
            case "AddReceipt" -> {
                NewView newView = new NewView(this.observer, user, allReceipts);
                newView.displayView();
            }
            case "ShowReceipt" -> {
                this.selectedReceipt = (Receipt)param[0];
                ArrayList<Person> participants = ReceiptParticipants();
                BillView billView = new BillView(this.observer, user, participants, (Receipt)param[0]);
                billView.displayView();
            }
            case "ShowSummary" -> {
                constructSummary();
            }
            case "LogOut" -> {
                this.serviceObserver.update(ServiceAction.LoggedOut);
            }
        }
    }

    private ArrayList<Map.Entry<Person, Float>> constructSummary(){
        ConnectorRepository conRepo = new ConnectorRepository(ctx);
        ReceiptRepository recRepo = new ReceiptRepository(ctx);
        PersonRepository perRepo = new PersonRepository(ctx);

        ArrayList<Integer> concerningReceipts = new ArrayList<>();
        for (Connector c : conRepo.GetAll()){
            if (c.getPersonId() == this.user.getPersonId()){
                concerningReceipts.add(c.getReceiptId());
            }
        }

        ArrayList<Receipt> ownReceipts = new ArrayList<>();
        ArrayList<Receipt> debtReceipts = new ArrayList<>();
        for (Receipt r : recRepo.GetAll()){
            for (Integer id : concerningReceipts){
                // If it's a concerning receipt
                if (r.getRecId() == id){
                    // If it's the user's receipt.
                    if (r.getPayingPersonId() == this.user.getPersonId()){
                        ownReceipts.add(r);
                    }
                    else {
                        debtReceipts.add(r);
                    }
                }
            }
        }

        ArrayList<Map.Entry<Person, Float>> summary = new ArrayList<>();
        if (debtReceipts.size() > 0){
            for (Receipt r : debtReceipts){
                // Search how much do we own.
                for (Connector c : conRepo.GetAll()){
                    // If it's the user's corresponding connector.
                    if (c.getReceiptId() == r.getRecId() && c.getPersonId() == this.user.getPersonId()){
                        // If it's not paid yet
                        if (!c.getIsPayed()){
                            // Search for the owner of this receipt
                            for (Person p : perRepo.GetAll()){
                                if (r.getPayingPersonId() == p.getPersonId()){
                                    Map.Entry<Person, Float> entry = new AbstractMap.SimpleEntry<>(p, -c.getSubTotal());
                                    summary.add(entry);
                                }
                            }
                        }
                    }
                }
            }
        }

        if (ownReceipts.size() > 0){
            for (Receipt r : ownReceipts){
                for (Connector c : conRepo.GetAll()){
                    for (Person p : r.People){
                        // If its the connector of someone who owns the user
                        if (c.getReceiptId() == r.getRecId() && c.getPersonId() == r.getRecId()){
                            Map.Entry<Person, Float> entry = new AbstractMap.SimpleEntry<>(p, c.getSubTotal());
                            summary.add(entry);
                            break;
                        }
                    }
                }
            }
        }

        ArrayList<Map.Entry<Person, Float>> finalSummary = new ArrayList<>();
        for (Map.Entry<Person, Float> sumEntry : summary){
            boolean foundPerson = false;
            for (Map.Entry<Person, Float> finEntry : finalSummary){
                if (finEntry.getKey() == sumEntry.getKey()){
                    finEntry.setValue(finEntry.getValue() + sumEntry.getValue());
                    foundPerson = true;
                }
            }
            if (!foundPerson){
                Map.Entry<Person, Float> entry = new AbstractMap.SimpleEntry<>(sumEntry.getKey(), sumEntry.getValue());
                finalSummary.add(entry);
            }
        }

        return finalSummary;
    }

    private ArrayList<Person> ReceiptParticipants() {
        ConnectorRepository conRepo = new ConnectorRepository(ctx);
        PersonRepository perRepo = new PersonRepository(ctx);

        ArrayList<Person> participants = new ArrayList<>();
        int expectedParticipants = 0;
        for (Connector c : conRepo.GetAll()){
            if (c.getReceiptId() == this.selectedReceipt.getRecId()){
                expectedParticipants++;
                for (Person p : perRepo.GetAll()){
                    if (p.getPersonId() == c.getPersonId()){
                        // We don't want the current user here
                        // but we want the corresponding connector.
                        if (p.getPersonId() != this.user.getPersonId()) {
                            participants.add(p);
                        }
                        else{
                            this.selectedConnector = c;
                        }
                    }
                }
            }
            // If more than one (the logged in user) person is missing
            if (expectedParticipants > participants.size() + 1){
                int shortage = expectedParticipants - (participants.size() + 1);
                do {
                    Person tmpPerson = new Person();
                    tmpPerson.setName("DeletedUser");
                    participants.add(tmpPerson);
                    shortage--;
                } while (shortage != 0);
            }
        }
        return participants;
    }

    private void payDebt() {
        this.selectedConnector.setIsPayed(true);
        provideView("Main");
    }

    private void deleteUser() {
        PersonRepository perRepo = new PersonRepository(ctx);
        perRepo.Remove(user);
        serviceObserver.update(ServiceAction.LoggedOut);
    }
}
