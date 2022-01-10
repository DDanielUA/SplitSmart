package com.SplitSmart.Test.Model;

import com.SplitSmart.Model.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Objects;

public class PersonUT extends UTBase {

    private int testId;
    private String testName;
    private String testEmail;
    private String testPhone;

    public PersonUT(){
        //Intentionally left blank
    }

    @Before
    @Override
    public void initialize(){
        this.testId = 1;
        this.testName = "Test";
        this.testEmail = "testMail@gmail.com";
        this.testPhone = "123456789";
    }

    @Test
    @Override
    public void t_testToString(){
        Person personUnderTest = new Person();
        personUnderTest.setPersonId(this.testId);
        personUnderTest.setName(this.testName);
        personUnderTest.setEmail(this.testEmail);
        personUnderTest.setPhone(this.testPhone);

        String expectedResult = "Information about this person:{" +
                "Id number: " + this.testId +
                ", Name: '" + this.testName + '\'' +
                ", Phone number: " + this.testPhone + '\'' +
                ", Email: " + this.testEmail + '\'' +
                '}';

        String actualResult = personUnderTest.toString();

        Assert.assertEquals(
                "Testing whether the .toString() method returns a correct string.",
                expectedResult,
                actualResult);
    }

    @Test
    public void t_testEqualsWithPerson(){
        Person personUnderTest1 = new Person();
        personUnderTest1.setPersonId(this.testId);
        personUnderTest1.setName(this.testName);
        personUnderTest1.setEmail(this.testEmail);
        personUnderTest1.setPhone(this.testPhone);

        Person personUnderTest2 = new Person();
        personUnderTest2.setPersonId(this.testId++);
        personUnderTest2.setName(this.testName + "Test");
        personUnderTest2.setEmail(this.testEmail);
        personUnderTest2.setPhone(this.testPhone);

        Assert.assertEquals(
                "Testing whether the .equals(Object o) evaluates the comparison the right way if it receives a Person instance.",
                false,
                personUnderTest1.equals(personUnderTest2));
    }

    @Test
    @Override
    public void t_testEqualsWithObject(){
        Person personUnderTest = new Person();
        personUnderTest.setPersonId(this.testId);
        personUnderTest.setName(this.testName);
        personUnderTest.setEmail(this.testEmail);
        personUnderTest.setPhone(this.testPhone);

        String mrMischief = "ops";

        Assert.assertEquals(
                "Testing whether the .equals(Object o) evaluates the comparison the right way if it receives a String instance.",
                false,
                personUnderTest.equals(mrMischief));

    }

    @Test
    @Override
    public void t_testHashCode(){
        Person personUnderTest = new Person();
        personUnderTest.setPersonId(this.testId);
        personUnderTest.setName(this.testName);
        personUnderTest.setEmail(this.testEmail);
        personUnderTest.setPhone(this.testPhone);

        int expectedHash = Objects.hash(this.testId, this.testName, this.testPhone, this.testEmail);

        int actualHash = personUnderTest.hashCode();

        Assert.assertEquals(
                "Testing whether the .equals(Object o) evaluates the comparison the right way if it receives a Person instance.",
                expectedHash,
                actualHash);
    }
}
