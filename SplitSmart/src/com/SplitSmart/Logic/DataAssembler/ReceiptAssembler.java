package com.SplitSmart.Logic.DataAssembler;

import com.SplitSmart.Application.MainScene.Model.NewReceiptResult;
import com.SplitSmart.Model.Connector;
import com.SplitSmart.Model.Person;
import com.SplitSmart.Repository.Data.SplitSmartContext;

import java.lang.reflect.Array;
import java.util.*;

public class ReceiptAssembler extends Assembler {
    private NewReceiptResult result;
    private List<String> resultNames;
    private List<String> resultShares;

    public ReceiptAssembler(SplitSmartContext ctx, Person user){
        super(ctx, user);
    }

    public void CreateReceiptOf(NewReceiptResult result){
        this.result = result;

        FormatResult();
        ArrayList<Map.Entry<Person, Float>> participantsSummary = OrganizeResult();
        HandleRepositories(participantsSummary);
    }

    private void FormatResult(){
        ArrayList<String> names = new ArrayList<>(Arrays.asList(this.result.getParticipants().split(",")));
        boolean containsUser = false;
        for (int i = 0; i < names.size(); i++){
            names.set(i, names.get(i).trim());
            if (Objects.equals(names.get(i), this.user.getName())){
                containsUser = true;
            }
        }
        if (!containsUser) names.add(this.user.getName());

        this.resultNames = names;

        List<String> shares = Arrays.asList(this.result.getParticipantsShares().split(","));
        for (int i = 0; i < shares.size(); i++){
            shares.set(i, shares.get(i).trim());
        }
        this.resultShares = shares;
    }

    private ArrayList<Map.Entry<Person, Float>> OrganizeResult(){
        ArrayList<Map.Entry<Person, Float>> participantsSummary = new ArrayList<>();
        ArrayList<String> foundNames = new ArrayList<>();
        for (Person p : this.perRepo.GetAll()){
            for (int i = 0; i < this.resultNames.size(); i++){
                if (p.getName().equals(this.resultNames.get(i))){
                    SummaryFactory(participantsSummary, p, i);
                    foundNames.add(this.resultNames.get(i));
                }
            }
        }

        if (foundNames.size() != this.resultNames.size()){
            int index = 0;
            for (String name : this.resultNames){
                boolean alreadyFound = false;
                for (String foundName : foundNames){
                    if (name.equals(foundName)){
                        alreadyFound = true;
                        break;
                    }
                }
                if (!alreadyFound){
                    Person unknownPerson = new Person();
                    unknownPerson.setPersonId(-1);
                    unknownPerson.setName("!Unknown!");

                    SummaryFactory(participantsSummary, unknownPerson, index);
                }
                index++;
            }
        }

        return participantsSummary;
    }

    private void SummaryFactory(ArrayList<Map.Entry<Person, Float>> participantsSummary, Person p, int i) {
        Map.Entry<Person, Float> entry;
        if (this.result.getReceipt().getIsEqualSplit()){
            entry = new AbstractMap.SimpleEntry<>(p, (this.result.getReceipt().getTotalCost() / this.resultNames.size()));
        }
        else {
            entry = new AbstractMap.SimpleEntry<>(p, Float.parseFloat(this.resultShares.get(i)));
        }
        participantsSummary.add(entry);
    }

    private void HandleRepositories(ArrayList<Map.Entry<Person, Float>> participantsSummary){
        this.result.getReceipt().setRecId(ctx.NextReceiptId);
        ctx.NextReceiptId++;

        for (Map.Entry<Person, Float> entry : participantsSummary){
            //Create connector
            Connector conn = new Connector(
                    ctx.NextConnectorId,
                    result.getReceipt().getRecId(),
                    entry.getKey().getPersonId(),
                    entry.getValue(),
                    entry.getKey().getPersonId() == this.user.getPersonId()
            );
            this.connRepo.Insert(conn);
            ctx.NextConnectorId++;

            this.result.getReceipt().People.add(entry.getKey());
        }

        this.recRepo.Insert(this.result.getReceipt());
    }
}
