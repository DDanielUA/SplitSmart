package com.SplitSmart.Application.WelcomeScene;

import com.SplitSmart.Application.BaseFrame;
import com.SplitSmart.Logic.ActionObserver.ActionAgency;
import com.SplitSmart.Logic.ActionObserver.WelcomeAction;
import com.SplitSmart.Model.Person;

class WelcomeBase {

    protected BaseFrame baseFrame;

    protected ActionAgency<WelcomeAction> observer;
    protected Person user;

    protected WelcomeBase(ActionAgency<WelcomeAction> observer, Person user, BaseFrame frame){
        this.baseFrame = frame;
        this.observer = observer;
        this.user = user;
    }

    public void displayView(){
        this.baseFrame.setVisible(true);
    }
}
