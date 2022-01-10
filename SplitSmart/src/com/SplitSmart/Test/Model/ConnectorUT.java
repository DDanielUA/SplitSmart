package com.SplitSmart.Test.Model;

import com.SplitSmart.Model.Connector;
import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;

public class ConnectorUT extends UTBase {
    private int testId;
    private int testRecId;
    private int testPerId;
    private float testSubTot;
    private boolean testIsPayed;

    public ConnectorUT(){
        //Intentionally left blank
    }

    @Override
    public void initialize() {
        this.testId = 1;
        this.testRecId = 4;
        this.testPerId = 6;
        this.testSubTot = 14.54f;
        this.testIsPayed = true;
    }

    @Test
    @Override
    public void t_testToString(){
        Connector connectorUnderTest = new Connector();
        connectorUnderTest.setConnId(this.testId);
        connectorUnderTest.setReceiptId(this.testRecId);
        connectorUnderTest.setPersonId(this.testPerId);
        connectorUnderTest.setSubTotal(this.testSubTot);
        connectorUnderTest.setIsPayed(this.testIsPayed);

        String expectedResult = "This connection has{" +
                "Id number: " + this.testId +
                ", Id of the receipt: " + this.testRecId +
                ", Id of the person: " + this.testPerId +
                ", Subtotal of the receipt: " + this.testSubTot +
                ", Is it already payed: " + this.testIsPayed +
                '}';

        String actualResult = connectorUnderTest.toString();

        Assert.assertEquals(
                "Testing whether the .toString() method returns a correct string.",
                expectedResult,
                actualResult);
    }

    @Test
    public void t_testEqualsWithConnector(){
        Connector connectorUnderTest1 = new Connector();
        connectorUnderTest1.setConnId(this.testId);
        connectorUnderTest1.setReceiptId(this.testRecId);
        connectorUnderTest1.setPersonId(this.testPerId);
        connectorUnderTest1.setSubTotal(this.testSubTot);
        connectorUnderTest1.setIsPayed(this.testIsPayed);


        Connector connectorUnderTest2 = new Connector();
        connectorUnderTest2.setConnId(this.testId++);
        connectorUnderTest2.setReceiptId(this.testRecId--);
        connectorUnderTest2.setPersonId(this.testPerId++);
        connectorUnderTest2.setSubTotal(33.1f);
        connectorUnderTest2.setIsPayed(this.testIsPayed);

        Assert.assertEquals(
                "Testing whether the .equals(Object o) evaluates the comparison the right way if it receives a Connector instance.",
                false,
                connectorUnderTest1.equals(connectorUnderTest2));
    }

    @Test
    @Override
    public void t_testEqualsWithObject(){
        Connector connectorUnderTest = new Connector();
        connectorUnderTest.setConnId(this.testId);
        connectorUnderTest.setReceiptId(this.testRecId);
        connectorUnderTest.setPersonId(this.testPerId);
        connectorUnderTest.setSubTotal(this.testSubTot);
        connectorUnderTest.setIsPayed(this.testIsPayed);

        String mrMischief = "ops";

        Assert.assertEquals(
                "Testing whether the .equals(Object o) evaluates the comparison the right way if it receives a String instance.",
                false,
                connectorUnderTest.equals(mrMischief));

    }

    @Test
    @Override
    public void t_testHashCode(){
        Connector connectorUnderTest = new Connector();
        connectorUnderTest.setConnId(this.testId);
        connectorUnderTest.setReceiptId(this.testRecId);
        connectorUnderTest.setPersonId(this.testPerId);
        connectorUnderTest.setSubTotal(this.testSubTot);
        connectorUnderTest.setIsPayed(this.testIsPayed);

        int expectedHash = Objects.hash(this.testId, this.testRecId, this.testPerId, this.testSubTot, this.testIsPayed);

        int actualHash = connectorUnderTest.hashCode();

        Assert.assertEquals(
                "Testing whether the .equals(Object o) evaluates the comparison the right way if it receives a Connector instance.",
                expectedHash,
                actualHash);
    }
}
