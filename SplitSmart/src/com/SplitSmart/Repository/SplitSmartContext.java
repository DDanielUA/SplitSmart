package com.SplitSmart.Repository;

import com.SplitSmart.Model.Connector;
import com.SplitSmart.Model.Person;
import com.SplitSmart.Model.Receipt;

import java.time.LocalDate;
import java.util.ArrayList;

public class SplitSmartContext {

    private static SplitSmartContext instance = null;

    private SplitSmartContext(){
        CreateContainers();
    }

    public static SplitSmartContext GetInstance(){
        if (instance == null) {
            instance = new SplitSmartContext();
        }
        return instance;
    }

    public ArrayList<Person> PersonSet = new ArrayList<Person>();

    public ArrayList<Receipt> ReceiptSet = new ArrayList<Receipt>();

    public ArrayList<Connector> ConnectorSet = new ArrayList<Connector>();

    private void CreateContainers(){
        // Person seed
        Person john = new Person();
        john.setPersonId(1);
        john.setName("John");
        john.setPhone("205485552");
        john.setEmail("john@gmail.com");
        PersonSet.add(john);
        Person bill = new Person();
        bill.setPersonId(2);
        bill.setName("Bill");
        bill.setPhone("305677781");
        bill.setEmail("bill@gmail.com");
        PersonSet.add(bill);
        Person jane = new Person();
        jane.setPersonId(3);
        jane.setName("Jane");
        jane.setPhone("704346269");
        jane.setEmail("jane@gmail.com");
        PersonSet.add(jane);

        //Receipt seed
        Receipt groceries = new Receipt();
        groceries.setRecId(1);
        groceries.setRecName("Groceries");
        groceries.setDescription("Just common stuff, nothing fancy.");
        groceries.setDate(LocalDate.now().minusDays(14));
        groceries.setTotalCost(33.60f);
        groceries.setIsEqualSplit(true);
        groceries.setPayingPersonId(1);
        ReceiptSet.add(groceries);
        Receipt restaurant = new Receipt();
        restaurant.setRecId(2);
        restaurant.setRecName("Restaurant with da crew");
        restaurant.setDescription("Having some dinner after a long trip.");
        restaurant.setDate(LocalDate.now().minusDays(27));
        restaurant.setTotalCost(42.50f);
        restaurant.setIsEqualSplit(false);
        restaurant.setPayingPersonId(3);
        ReceiptSet.add(restaurant);

        //---Connector seed
        //-----Groceries connector
        Connector conn1 = new Connector();
        conn1.setConnId(1);
        conn1.setReceiptId(1);
        conn1.setPersonId(1);
        conn1.setSubTotal(33.60f/3);
        conn1.setIsPlayed(true);
        ConnectorSet.add(conn1);
        Connector conn2 = new Connector();
        conn2.setConnId(2);
        conn2.setReceiptId(1);
        conn2.setPersonId(2);
        conn2.setSubTotal(33.60f/3);
        conn2.setIsPlayed(false);
        ConnectorSet.add(conn2);
        Connector conn3 = new Connector();
        conn3.setConnId(3);
        conn3.setReceiptId(1);
        conn3.setPersonId(3);
        conn3.setSubTotal(33.60f/3);
        conn3.setIsPlayed(false);
        ConnectorSet.add(conn3);

        //-----Restaurant connector
        Connector conn4 = new Connector();
        conn4.setConnId(4);
        conn4.setReceiptId(2);
        conn4.setPersonId(2);
        conn4.setSubTotal(26.50f);
        conn4.setIsPlayed(true);
        ConnectorSet.add(conn4);
        Connector conn5 = new Connector();
        conn5.setConnId(5);
        conn5.setReceiptId(2);
        conn5.setPersonId(3);
        conn5.setSubTotal(16.00f);
        conn5.setIsPlayed(false);
        ConnectorSet.add(conn5);
    }

    private void SaveContainers(){

    }
}
