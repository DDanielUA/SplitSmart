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
        Person personUnderTest = new Person(
                this.testId,
                this.testName,
                this.testEmail,
                this.testEmail
        );

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
        Person personUnderTest1 = new Person(
                this.testId,
                this.testName,
                this.testEmail,
                this.testEmail
        );
        Person personUnderTest2 = new Person(
                this.testId++,
                this.testName + "Test",
                this.testEmail,
                this.testEmail
        );

        Assert.assertEquals(
                "Testing whether the .equals(Object o) evaluates the comparison the right way if it receives a Person instance.",
                false,
                personUnderTest1.equals(personUnderTest2));
    }

    @Test
    @Override
    public void t_testEqualsWithObject(){
        Person personUnderTest = new Person(
                this.testId,
                this.testName,
                this.testEmail,
                this.testEmail
        );

        String mrMischief = "ops";

        Assert.assertEquals(
                "Testing whether the .equals(Object o) evaluates the comparison the right way if it receives a String instance.",
                false,
                personUnderTest.equals(mrMischief));

    }

    @Test
    @Override
    public void t_testHashCode(){
        Person personUnderTest = new Person(
                this.testId,
                this.testName,
                this.testEmail,
                this.testEmail
        );

        int expectedHash = Objects.hash(this.testId, this.testName, this.testPhone, this.testEmail);

        int actualHash = personUnderTest.hashCode();

        Assert.assertEquals(
                "Testing whether the .equals(Object o) evaluates the comparison the right way if it receives a Person instance.",
                expectedHash,
                actualHash);
    }
}
