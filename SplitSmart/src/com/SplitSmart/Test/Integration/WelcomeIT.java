package com.SplitSmart.Test.Integration;

import com.SplitSmart.Logic.ActionObserver.WelcomeAction;
import com.SplitSmart.Logic.WelcomeService;
import com.SplitSmart.Model.Person;
import com.SplitSmart.Repository.Data.SplitSmartContext;
import com.SplitSmart.Repository.PersonRepository;
import org.junit.Assert;
import org.junit.Test;

public class WelcomeIT {

    public WelcomeIT(){
        //Intentionally left blank
    }

    @Test
    public void t_testRegistration(){
        Person testPerson = new Person();
        testPerson.setPersonId(99999);
        testPerson.setName("Test Person");
        testPerson.setEmail("testPerson@gmail.com");
        testPerson.setPhone("123456789");

        WelcomeService welService = new WelcomeService(null);
        welService.Notify(WelcomeAction.AttemptRegister, testPerson);

        SplitSmartContext ctx = SplitSmartContext.GetInstance();
        Person actualPerson = ctx.PersonSet.get((ctx.NextPersonId -2));

        Assert.assertEquals("Test if the person is correctly registrated.",
                true,
                actualPerson.equals(testPerson));

        PersonRepository perRepo = new PersonRepository(ctx);
        perRepo.Remove(testPerson);
    }
}
