package com.SplitSmart.Test.Integration;

import com.SplitSmart.Logic.ActionObserver.UserAction;
import com.SplitSmart.Logic.MainService;
import com.SplitSmart.Model.Connector;
import com.SplitSmart.Model.Person;
import com.SplitSmart.Model.Receipt;
import com.SplitSmart.Repository.Data.SplitSmartContext;
import org.junit.Assert;
import org.junit.Test;

public class MainIT {

    public MainIT(){
        //Intentionally left blank
    }
    @Test
    public void t_testPayDebt(){
        Connector testConnector = new Connector(
                9999,
                9999,
                9999,
                9999.9f,
                false
        );
        SplitSmartContext.GetInstance().ConnectorSet.add(testConnector);

        Person testPerson = new Person();
        testPerson.setPersonId(9999);

        Receipt testReceipt = new Receipt();
        testReceipt.setRecId(9999);

        MainService mainService = new MainService(null, testPerson);

        mainService.Notify(UserAction.PayDebt, testReceipt);

        Assert.assertEquals("Testing if the payDebt() function works correctly."
        ,true,
                SplitSmartContext.GetInstance().ConnectorSet.get(
                        SplitSmartContext.GetInstance().ConnectorSet.size() - 1
                        ).getIsPayed());
    }
}
