package com.SplitSmart.Logic;

import com.SplitSmart.Application.MainScene.BillView;
import com.SplitSmart.Application.MainScene.MainView;
import com.SplitSmart.Application.MainScene.Model.NewReceiptResult;
import com.SplitSmart.Application.MainScene.NewView;
import com.SplitSmart.Application.MainScene.SumView;
import com.SplitSmart.Logic.ActionObserver.ActionAgent;
import com.SplitSmart.Logic.ActionObserver.ActionListener;
import com.SplitSmart.Logic.ActionObserver.UserAction;
import com.SplitSmart.Logic.ActionObserver.ServiceAction;
import com.SplitSmart.Logic.DataAssembler.ReceiptAssembler;
import com.SplitSmart.Logic.DataAssembler.SummaryAssembler;
import com.SplitSmart.Model.Connector;
import com.SplitSmart.Model.Person;
import com.SplitSmart.Model.Receipt;
import com.SplitSmart.Repository.ConnectorRepository;
import com.SplitSmart.Repository.Data.SplitSmartContext;
import com.SplitSmart.Repository.PersonRepository;
import com.SplitSmart.Repository.ReceiptRepository;

import java.util.*;

public class MainService extends ActionListener<UserAction> {
    private final SplitSmartContext ctx = SplitSmartContext.GetInstance();
    private final PersonRepository perRepo = new PersonRepository(ctx);
    private final ReceiptRepository recRepo = new ReceiptRepository(ctx);
    private final ConnectorRepository connRepo = new ConnectorRepository(ctx);

    private final ActionAgent<ServiceAction> serviceObserver;
    private final ActionAgent<UserAction> observer;

    //Runtime specific data
    private final Person user;

    public MainService(ActionAgent<ServiceAction> sObserver, Person user){
        this.serviceObserver = sObserver;
        this.observer = new ActionAgent<>();
        observer.subscribe(this);

        this.user = user;
    }

    public void InitiateService(){
        this.observer.update(UserAction.Default);
    }

    @Override
    public void Notify(UserAction eventHappened) {
        super.Notify(eventHappened);
        switch (eventHappened){
            case Default -> provideMainView();
            case NewReceipt -> provideNewView();
            case ShowSummary -> provideSummaryView();
            case LogOut -> serviceObserver.update(ServiceAction.LoggedOut);
        }
    }

    @Override
    public void Notify(UserAction eventHappened, Object param) {
        super.Notify(eventHappened);
        switch (eventHappened){
            case DeleteUser -> deleteUser((boolean)param);
            case ShowReceipt -> provideReceiptView((Receipt)param);
            case AddReceipt -> addReceipt((NewReceiptResult)param);
            case PayDebt -> payDebt((Receipt)param);
        }
    }

    private void provideMainView(){
        ArrayList<Receipt> allReceipts = collectReceipts();
        MainView mainView = new MainView(this.observer, user, allReceipts);
        mainView.displayView();
    }

    private void provideNewView(){
        NewView newView = new NewView(this.observer, user);
        newView.displayView();
    }

    private void provideReceiptView(Receipt receipt){
        ArrayList<Person> participants = receiptParticipants(receipt);
        boolean isPayed = checkIfPayed(receipt);
        BillView billView = new BillView(this.observer, user, participants, receipt, isPayed);
        billView.displayView();
    }

    private void provideSummaryView(){
        SummaryAssembler sumAssembler = new SummaryAssembler(this.ctx, this.user);
        ArrayList<Map.Entry<Person, Float>> summary = sumAssembler.GetSummary();
        SumView sumView = new SumView(this.observer, user, summary);
        sumView.displayView();
    }

    private ArrayList<Receipt> collectReceipts(){
        ArrayList<Receipt> allReceipts = new ArrayList<>();

        for (Connector c : this.connRepo.GetAll()){
            if (c.getPersonId() == this.user.getPersonId()){
                for (Receipt r : this.recRepo.GetAll()){
                    if (r.getRecId() == c.getReceiptId()){
                        allReceipts.add(r);
                    }
                }
            }
        }

        return allReceipts;
    }

    private void addReceipt(NewReceiptResult result){
        ReceiptAssembler recAssembler = new ReceiptAssembler(this.ctx, this.user);
        recAssembler.CreateReceiptOf(result);

        provideMainView();
    }

    private boolean checkIfPayed(Receipt receipt) {
        for (Connector c : this.connRepo.GetAll()){
            if (c.getReceiptId() == receipt.getRecId() &&
                c.getPersonId() == this.user.getPersonId()){
                return c.getIsPayed();
            }
        }
        return false;
    }

    private ArrayList<Person> receiptParticipants(Receipt receipt) {

        ArrayList<Person> participants = new ArrayList<>();
        int expectedParticipants = 0;
        for (Connector c : this.connRepo.GetAll()){
            if (c.getReceiptId() == receipt.getRecId()){
                expectedParticipants++;
                for (Person p : this.perRepo.GetAll()){
                    if (p.getPersonId() == c.getPersonId()){
                        // We don't want the current user here
                        // ,but we want the corresponding connector.
                        if (p.getPersonId() != this.user.getPersonId()) {
                            participants.add(p);
                        }
                    }
                }
            }
            // If more than one (because of the logged-in user) person is missing
            if (expectedParticipants > participants.size() + 1){
                int shortage = expectedParticipants - (participants.size() + 1);
                do {
                    Person unknownPerson = new Person();
                    unknownPerson.markAsUnknown();
                    participants.add(unknownPerson);
                    shortage--;
                } while (shortage != 0);
            }
        }
        return participants;
    }

    private void payDebt(Receipt receipt) {
        for (Connector c : this.connRepo.GetAll()){
            if (c.getReceiptId() == receipt.getRecId() && c.getPersonId() == this.user.getPersonId()){
                c.setIsPayed(true);
                Connector newConnector = c;
                this.connRepo.Remove(c);
                this.connRepo.Insert(newConnector);
                break;
            }
        }
        provideMainView();
    }

    private void deleteUser(boolean isDelete) {
        if (isDelete){
            this.perRepo.Remove(user);
            serviceObserver.update(ServiceAction.LoggedOut);
        }
        else {
            provideMainView();
        }
    }
}
