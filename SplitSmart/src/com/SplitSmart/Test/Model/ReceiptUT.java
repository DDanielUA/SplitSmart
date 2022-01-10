package com.SplitSmart.Test.Model;

import com.SplitSmart.Model.Receipt;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Objects;

public class ReceiptUT extends UTBase{
    private int testId;
    private String testRecName;
    private String testRecDesc;
    private LocalDate testDate;
    private float testTotCost;
    private boolean testIsEqualSplit;
    private int testPayPerId;

    public ReceiptUT(){
        //Intentionally left blank
    }

    @Before
    @Override
    public void initialize() {
        this.testId = 1;
        this.testRecName = "Burger King";
        this.testRecDesc = "Company event, lunch.";
        this.testDate = LocalDate.now();
        this.testTotCost = 35.7f;
        this.testIsEqualSplit = false;
        this.testPayPerId = 4;
    }

    @Test
    @Override
    public void t_testToString(){
        Receipt receiptUnderTest = new Receipt();
        receiptUnderTest.setRecId(this.testId);
        receiptUnderTest.setRecName(this.testRecName);
        receiptUnderTest.setDescription(this.testRecDesc);
        receiptUnderTest.setDate(this.testDate);
        receiptUnderTest.setTotalCost(this.testTotCost);
        receiptUnderTest.setIsEqualSplit(this.testIsEqualSplit);
        receiptUnderTest.setPayingPersonId(this.testPayPerId);

        String expectedResult = "Here are the details of your receipt{" +
                "Id: " + this.testId +
                ", Name: " + this.testRecName + '\'' +
                ", Description: " + this.testRecDesc + '\'' +
                ", Date of purchase: " + this.testDate +
                ", Total cost of purchase: " + this.testTotCost +
                ", Is it split equally between people: " + this.testIsEqualSplit +
                ", Id of the person who payed for it:" + this.testPayPerId +
                '}';

        String actualResult = receiptUnderTest.toString();

        Assert.assertEquals(
                "Testing whether the .toString() method returns a correct string.",
                expectedResult,
                actualResult);
    }

    @Test
    public void t_testEqualsWithReceipt(){
        Receipt receiptUnderTest1 = new Receipt();
        receiptUnderTest1.setRecId(this.testId);
        receiptUnderTest1.setRecName(this.testRecName);
        receiptUnderTest1.setDescription(this.testRecDesc);
        receiptUnderTest1.setDate(this.testDate);
        receiptUnderTest1.setTotalCost(this.testTotCost);
        receiptUnderTest1.setIsEqualSplit(this.testIsEqualSplit);
        receiptUnderTest1.setPayingPersonId(this.testPayPerId);

        Receipt receiptUnderTest2 = new Receipt();
        receiptUnderTest2.setRecId(this.testId++);
        receiptUnderTest2.setRecName("Domino's");
        receiptUnderTest2.setDescription(this.testRecDesc);
        receiptUnderTest2.setDate(this.testDate);
        receiptUnderTest2.setTotalCost(this.testTotCost * 2);
        receiptUnderTest2.setIsEqualSplit(this.testIsEqualSplit);
        receiptUnderTest2.setPayingPersonId(this.testPayPerId);

        Assert.assertEquals(
                "Testing whether the .equals(Object o) evaluates the comparison the right way if it receives a Person instance.",
                false,
                receiptUnderTest1.equals(receiptUnderTest2));
    }

    @Test
    @Override
    public void t_testEqualsWithObject(){
        Receipt receiptUnderTest = new Receipt();
        receiptUnderTest.setRecId(this.testId);
        receiptUnderTest.setRecName(this.testRecName);
        receiptUnderTest.setDescription(this.testRecDesc);
        receiptUnderTest.setDate(this.testDate);
        receiptUnderTest.setTotalCost(this.testTotCost);
        receiptUnderTest.setIsEqualSplit(this.testIsEqualSplit);
        receiptUnderTest.setPayingPersonId(this.testPayPerId);

        String mrMischief = "ops";

        Assert.assertEquals(
                "Testing whether the .equals(Object o) evaluates the comparison the right way if it receives a String instance.",
                false,
                receiptUnderTest.equals(mrMischief));

    }

    @Test
    @Override
    public void t_testHashCode(){
        Receipt receiptUnderTest = new Receipt();
        receiptUnderTest.setRecId(this.testId);
        receiptUnderTest.setRecName(this.testRecName);
        receiptUnderTest.setDescription(this.testRecDesc);
        receiptUnderTest.setDate(this.testDate);
        receiptUnderTest.setTotalCost(this.testTotCost);
        receiptUnderTest.setIsEqualSplit(this.testIsEqualSplit);
        receiptUnderTest.setPayingPersonId(this.testPayPerId);

        int expectedHash = Objects.hash(this.testId, this.testRecName, this.testRecDesc, this.testDate, this.testTotCost, this.testIsEqualSplit, this.testPayPerId);

        int actualHash = receiptUnderTest.hashCode();

        Assert.assertEquals(
                "Testing whether the .equals(Object o) evaluates the comparison the right way if it receives a Person instance.",
                expectedHash,
                actualHash);
    }
}
