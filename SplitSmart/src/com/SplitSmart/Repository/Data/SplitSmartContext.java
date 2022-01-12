package com.SplitSmart.Repository.Data;

import com.SplitSmart.Model.Connector;
import com.SplitSmart.Model.Person;
import com.SplitSmart.Model.Receipt;

import java.time.LocalDate;
import java.util.ArrayList;

public class SplitSmartContext {

    private static SplitSmartContext instance = null;

    private SplitSmartContext(){
        SeedContainers();
        //LoadSets();
        SaveSets();
    }

    public static SplitSmartContext GetInstance(){
        if (instance == null) {
            instance = new SplitSmartContext();
        }
        return instance;
    }

    public int NextPersonId;
    public ArrayList<Person> PersonSet = new ArrayList<Person>();

    public int NextReceiptId;
    public ArrayList<Receipt> ReceiptSet = new ArrayList<Receipt>();

    public int NextConnectorId;
    public ArrayList<Connector> ConnectorSet = new ArrayList<Connector>();

    public void SaveSets(){
        ArrayList<ArrayList> sets = new ArrayList<ArrayList>();
        sets.add(this.PersonSet);
        sets.add(this.ReceiptSet);
        sets.add(this.ConnectorSet);

        SSML ssml = SSML.GetInstance();
        ssml.WriteSetsToFile(sets);
    }

    private void LoadSets(){
        SSML ssml = SSML.GetInstance();
        ArrayList<ArrayList> sets = ssml.ReadFileToSets();

        this.PersonSet = sets.get(0);
        this.NextPersonId = sets.get(0).size() + 1;
        this.ReceiptSet = sets.get(1);
        this.NextReceiptId = sets.get(1).size() + 1;
        this.ConnectorSet = sets.get(2);
        this.NextConnectorId = sets.get(2).size() + 1;
    }

    private void SeedContainers(){
        // Person seed
        Person john = new Person(
                1,
                "John",
                "205485552",
                "john@gmail.com"
        );
        PersonSet.add(john);

        Person bill = new Person(
                2,
                "Bill",
                "305677781",
                "bill@gmail.com"
        );
        PersonSet.add(bill);

        Person jane = new Person(
                3,
                "Jane",
                "704346269",
                "jane@gmail.com"
        );
        PersonSet.add(jane);
        this.NextPersonId = 4;

        //Receipt seed
        Receipt groceries = new Receipt(
                1,
                "Groceries",
                "Just some common stuff, nothing fancy.",
                LocalDate.now().minusDays(14),
                30.0f,
                true,
                1
        );
        groceries.People.add(john);
        groceries.People.add(bill);
        groceries.People.add(jane);
        ReceiptSet.add(groceries);

        Receipt restaurant = new Receipt(
                2,
                "Restaurant with da crew",
                "Having som dinner after a long trip.",
                LocalDate.now().minusDays(27),
                30.0f,
                false,
                3
        );
        restaurant.People.add(bill);
        restaurant.People.add(jane);
        ReceiptSet.add(restaurant);
        this.NextReceiptId = 3;

        //---Connector seed
        //-----Groceries connector
        Connector conn1 = new Connector(1, 1, 1, (30.0f/3), true);
        john.Connections.add(conn1);
        ConnectorSet.add(conn1);

        Connector conn2 = new Connector(2, 1, 2, (30.0f/3), false);
        bill.Connections.add(conn2);
        ConnectorSet.add(conn2);

        Connector conn3 = new Connector(3, 1, 3, (30.0f/3), false);
        jane.Connections.add(conn3);
        ConnectorSet.add(conn3);

        //-----Restaurant connector
        Connector conn4 = new Connector(4, 2, 2, 20.0f, false);
        bill.Connections.add(conn4);
        ConnectorSet.add(conn4);

        Connector conn5 = new Connector(5, 2, 3, 10.0f, true);
        jane.Connections.add(conn5);
        ConnectorSet.add(conn5);
        this.NextConnectorId = 6;
    }
}
