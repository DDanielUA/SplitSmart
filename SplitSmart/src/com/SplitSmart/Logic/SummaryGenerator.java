package com.SplitSmart.Logic;

import com.SplitSmart.Model.Connector;
import com.SplitSmart.Model.Person;
import com.SplitSmart.Model.Receipt;
import com.SplitSmart.Repository.ConnectorRepository;
import com.SplitSmart.Repository.Data.SplitSmartContext;
import com.SplitSmart.Repository.PersonRepository;
import com.SplitSmart.Repository.ReceiptRepository;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;

public class SummaryGenerator {
    private final PersonRepository perRepo;
    private final ReceiptRepository recRepo;
    private final ConnectorRepository conRepo;

    private Person user;

    public SummaryGenerator(SplitSmartContext ctx){
        this.perRepo = new PersonRepository(ctx);
        this.recRepo = new ReceiptRepository(ctx);
        this.conRepo = new ConnectorRepository(ctx);
    }

    public ArrayList<Map.Entry<Person, Float>> GetSummaryFor(Person user){
        this.user = user;

        ArrayList<Receipt> concerningReceipts = collectReceipts();
        ArrayList<Map.Entry<Person, Float>> relations = collectRelations(concerningReceipts);

        return summarizeRelations(relations);
    }

    /*
    We collect integers of those receipts that has anything to do with
    the given user. Afterwards we look up the corresponding receipts
    and return an arraylist of those.
     */
    private ArrayList<Receipt> collectReceipts(){
        ArrayList<Integer> concerningReceiptIds = new ArrayList<>();
        for (Connector c : this.conRepo.GetAll()){
            if (c.getPersonId() == this.user.getPersonId()){
                concerningReceiptIds.add(c.getReceiptId());
            }
        }

        ArrayList<Receipt> concerningReceipts = new ArrayList<>();
        for (Receipt r : recRepo.GetAll()){
            for (Integer id : concerningReceiptIds){
                if (r.getRecId() == id){
                    concerningReceipts.add(r);
                }
            }
        }

        return concerningReceipts;
    }

    /*
    We collect 'id-amount' pairs for each person that is somehow related to
    any of the receipts. Afterwards we look up the found ids and return a
    'Person-value' collection accordingly.
     */
    private ArrayList<Map.Entry<Person, Float>> collectRelations(ArrayList<Receipt> receipts){
        ArrayList<Map.Entry<Integer, Float>> idRelations = new ArrayList<>();
        for (Receipt r : receipts){
            for (Connector c : conRepo.GetAll()){
                // If it is a connector that concerns us based on the concerning receipts.
                if (r.getRecId() == c.getReceiptId()){
                    // If people owe to the user
                    if (r.getPayingPersonId() == this.user.getPersonId() && !c.getIsPayed()){
                        Map.Entry<Integer, Float> entry;
                        entry = new AbstractMap.SimpleEntry<>(c.getPersonId(), c.getSubTotal());
                        idRelations.add(entry);
                    }
                    // If the user owes to someone
                    else{
                        if (c.getPersonId() == this.user.getPersonId() && !c.getIsPayed()){
                            Map.Entry<Integer, Float> entry;
                            entry = new AbstractMap.SimpleEntry<>(r.getPayingPersonId(), -c.getSubTotal());
                            idRelations.add(entry);
                        }
                    }
                }
            }
        }

        ArrayList<Map.Entry<Person, Float>> personRelations = new ArrayList<>();
        for (Map.Entry<Integer, Float> oldEntry : idRelations){
            for (Person p : perRepo.GetAll()){
                if (oldEntry.getKey() == p.getPersonId()){
                    Map.Entry<Person, Float> newEntry = new AbstractMap.SimpleEntry<>(p, oldEntry.getValue());
                    personRelations.add(newEntry);
                    break;
                }
            }
        }

        return personRelations;
    }

    /*
    We compare each relation against every other and look for occurrence of
    the same person. In these cases we summarize the values and store the
    summarized result with the corresponding person. The "used up" entries
    are deleted from the collection. We return the now surely distinct collection.
     */
    private ArrayList<Map.Entry<Person, Float>> summarizeRelations(ArrayList<Map.Entry<Person, Float>> relations){

        ArrayList<Person> concerningPeople = new ArrayList<>();
        for (Map.Entry<Person, Float> entry : relations){
            boolean alreadySaved = false;
            for (Person p : concerningPeople){
                if (p.equals(entry.getKey())) {
                    alreadySaved = true;
                    break;
                }
            }
            if (!alreadySaved){
                concerningPeople.add(entry.getKey());
            }
        }

        ArrayList<Map.Entry<Person, Float>> summary = new ArrayList<>();
        for (Person p : concerningPeople){
            Map.Entry<Person, Float> sumEntry = new AbstractMap.SimpleEntry<>(p, 0.0f);
            for (Map.Entry<Person, Float> entry : relations){
                if (p.equals(entry.getKey())){
                    sumEntry.setValue(entry.getValue() + sumEntry.getValue());
                }
            }
            summary.add(sumEntry);
        }

        return summary;
    }
}
