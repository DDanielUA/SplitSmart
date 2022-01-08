package com.SplitSmart.Repository.Data;

import com.SplitSmart.Model.Connector;
import com.SplitSmart.Model.Person;
import com.SplitSmart.Model.Receipt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.ArrayList;

//Split Smart Markup Language
//Ensures that the save file is managed based on a specific syntax and set of rules.
public class SSML {

    private static SSML instance = null;

    private static final String FILENAME = "SplitSmartSave";    //Name of the save file
    private static final String EXTENSION = ".txt";             //Extension of the save file
    private static final String DIVIDERCHAR = "/";              //Character that divides the individual values
    private static final String ENDOFSINGLEVALUESCHAR = ":";    //Character that indicates the end of the single values
    private static final String ENDOFCOLLECTIONVALUES = ";";    //Character that indicates the end of the collection values

    private SSML(){
    }

    //Public acces point of the Singleton instance.
    public static SSML GetInstance(){
        if (instance == null) {
            instance = new SSML();
        }
        return instance;
    }

    //This function will create an @EXTENSION file based on the
    //set of rules and syntax that is introduced within the 'FormatLine(<<>>)' function.
    //Note for myself: Raw ArrayList is ugly and unsafe, should use a generic approach somehow.
    public void WriteSetsToFile(ArrayList<ArrayList> sets){
        if (sets == null || sets.size() == 0){
            return;
        }
        try {
            //File handler
            FileWriter fw = new FileWriter(FILENAME + EXTENSION);

            for (ArrayList set : sets) {
                fw.write(set.get(0).getClass().getSimpleName() + ENDOFSINGLEVALUESCHAR + "\n");
                for (Object element : set) {
                    fw.write(FormatLine(element)  + "\n");
                }
            }
            fw.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    //This function will read in an @EXTENSION file that should follow
    //the syntax introduced in the 'FormatLine(<<>>)' function.
    //Note for myself: Raw ArrayList is ugly and unsafe, should use a generic approach somehow.
    public ArrayList<ArrayList> ReadFileToSet(){
        try{
            //File handlers
            FileReader fr = new FileReader(FILENAME + EXTENSION);
            BufferedReader br = new BufferedReader(fr);

            //Basic initialization
            String line;
            String classType = "";
            ArrayList<ArrayList> sets = new ArrayList<>();
            int setsOffset = 0;

            while ((line = br.readLine()) != null) {
                if (line.startsWith(DIVIDERCHAR)){
                    sets.get(setsOffset).add(DeformatLine(line, classType));
                }
                else{
                    line = line.replaceFirst(ENDOFSINGLEVALUESCHAR, "");
                    switch (line){
                        case "Person" -> {
                            classType = "Person";
                            sets.add(new ArrayList<Person>());
                        }
                        case "Receipt" -> {
                            classType = "Receipt";
                            sets.add(new ArrayList<Receipt>());
                            setsOffset++;
                        }
                        case "Connector" -> {
                            classType = "Connector";
                            sets.add(new ArrayList<Connector>());
                            setsOffset++;
                        }
                    }
                }
            }
            sets = ConnectEntities(sets);
            fr.close();
            br.close();
            return sets;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    //This function will disassemble a class (type E) and create a single string
    //that is a formatted version of the values of its fields.
    private <E> String FormatLine(E element){
        String line = DIVIDERCHAR;

        if (element instanceof Person person){
            line += person.getPersonId() + DIVIDERCHAR;
            line += person.getName() + DIVIDERCHAR;
            line += person.getEmail() + DIVIDERCHAR;
            line += person.getPhone() + ENDOFSINGLEVALUESCHAR;
            for (Connector c : person.Connections) {
                line += c.getConnId() + DIVIDERCHAR;
            }
            line += ENDOFCOLLECTIONVALUES;
            return line;
        }
        else if (element instanceof Receipt receipt){
            line += receipt.getRecId() + DIVIDERCHAR;
            line += receipt.getRecName() + DIVIDERCHAR;
            line += receipt.getDescription() + DIVIDERCHAR;
            line += receipt.getDate() + DIVIDERCHAR;
            line += receipt.getTotalCost() + DIVIDERCHAR;
            line += receipt.getIsEqualSplit() + DIVIDERCHAR;
            line += receipt.getPayingPersonId() + ENDOFSINGLEVALUESCHAR;
            for (Person p : receipt.People){
                line += p.getPersonId() + DIVIDERCHAR;
            }
            line += ENDOFCOLLECTIONVALUES;
            return line;
        }
        else if (element instanceof Connector connector){
            line += connector.getConnId() + DIVIDERCHAR;
            line += connector.getReceiptId() + DIVIDERCHAR;
            line += connector.getPersonId() + DIVIDERCHAR;
            line += connector.getSubTotal() + DIVIDERCHAR;
            line += connector.getIsPayed() + ENDOFSINGLEVALUESCHAR;
            return line;
        }
        else {
            return "";
        }
    }

    //This function will assemble a class (type Object) based on the read values.
    private Object DeformatLine(String line, String classType){
        switch (classType){
            case "Person" -> {
                Person person = new Person();
                String[] allValues = line.split(ENDOFSINGLEVALUESCHAR);
                //Handling the simple values
                String[] simpleValues = allValues[0].split(DIVIDERCHAR);
                simpleValues[simpleValues.length - 1] = simpleValues[simpleValues.length - 1].replaceFirst(ENDOFSINGLEVALUESCHAR, "");
                person.setPersonId(Integer.parseInt(simpleValues[1]));
                person.setName(simpleValues[2]);
                person.setEmail(simpleValues[3]);
                person.setPhone(simpleValues[4]);
                //Handling collection values is outsourced. (this.ConnectEntities())
                return person;
            }
            case "Receipt" -> {
                Receipt receipt = new Receipt();
                String[] allValues = line.split(ENDOFSINGLEVALUESCHAR);
                //Handling simple values
                String[] simpleValues = allValues[0].split(DIVIDERCHAR);
                simpleValues[simpleValues.length - 1] = simpleValues[simpleValues.length - 1].replaceFirst(ENDOFSINGLEVALUESCHAR, "");
                receipt.setRecId(Integer.parseInt(simpleValues[1]));
                receipt.setRecName(simpleValues[2]);
                receipt.setDescription(simpleValues[3]);
                receipt.setDate(LocalDate.parse(simpleValues[4]));
                receipt.setTotalCost(Float.parseFloat(simpleValues[5]));
                receipt.setIsEqualSplit(Boolean.parseBoolean(simpleValues[6]));
                receipt.setPayingPersonId(Integer.parseInt(simpleValues[7]));
                //Handling collection values is outsourced to the caller. (ctx.LoadSets())
                return receipt;
            }
            case "Connector" -> {
                Connector connector = new Connector();
                String[] allValues = line.split(DIVIDERCHAR);
                allValues[allValues.length - 1] = allValues[allValues.length - 1].replaceFirst(ENDOFSINGLEVALUESCHAR, "");

                connector.setConnId(Integer.parseInt(allValues[1]));
                connector.setReceiptId(Integer.parseInt(allValues[2]));
                connector.setPersonId(Integer.parseInt(allValues[3]));
                connector.setSubTotal(Float.parseFloat(allValues[4]));
                connector.setIsPayed(Boolean.parseBoolean(allValues[5]));
                return connector;
            }
        }
        return null;
    }

    //This class implements the postprocess of the navigational properties of the Person and Receipt classes.
    private ArrayList<ArrayList> ConnectEntities(ArrayList<ArrayList> sets){
        for (Connector c : (ArrayList<Connector>)sets.get(2)){
            int lookForPerson = c.getPersonId();
            Person foundPerson = null;
            for (Person p : (ArrayList<Person>)sets.get(0)) {
                if (p.getPersonId() == lookForPerson){
                    p.Connections.add(c);
                    foundPerson = p;
                }
            }
            int lookForReceipt = c.getReceiptId();
            for (Receipt r: (ArrayList<Receipt>)sets.get(1)) {
                if (r.getRecId() == lookForReceipt){
                    if (r.getPayingPersonId() != foundPerson.getPersonId()) {
                        r.People.add(foundPerson);
                    }
                }
            }
        }

        return sets;
    }
}
