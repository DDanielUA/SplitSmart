package com.SplitSmart.Application.WelcomeScene;

import com.SplitSmart.Application.BaseFrame;
import com.SplitSmart.Logic.ActionObserver.ActionAgency;
import com.SplitSmart.Logic.ActionObserver.WelcomeAction;
import com.SplitSmart.Model.Person;

public class WelcomeBase extends BaseFrame {

    protected ActionAgency<WelcomeAction> observer;
    protected Person user;

    protected WelcomeBase(ActionAgency<WelcomeAction> observer, Person user){
        this.observer = observer;
        this.user = user;
    }
}
