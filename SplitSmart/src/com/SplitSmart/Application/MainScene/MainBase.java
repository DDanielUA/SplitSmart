package com.SplitSmart.Application.MainScene;

import com.SplitSmart.Application.BaseFrame;
import com.SplitSmart.Logic.ActionObserver.ActionAgent;
import com.SplitSmart.Logic.ActionObserver.UserAction;
import com.SplitSmart.Model.Person;
import com.SplitSmart.Model.Receipt;

import java.util.ArrayList;

class MainBase {
    protected BaseFrame baseFrame;

    protected ActionAgent<UserAction> observer;
    protected Person user;
    protected ArrayList<Receipt> receipts;

    protected MainBase(ActionAgent<UserAction> observer, Person user, BaseFrame frame){
        this.baseFrame = frame;
        this.baseFrame.setSloganLabel("Make your friends pay, " + user.getName() + "!");

        this.observer = observer;
        this.user = user;
    }

    protected MainBase(ActionAgent<UserAction> observer, Person user, ArrayList<Receipt> receipts, BaseFrame frame){
        this.baseFrame = frame;
        this.baseFrame.setSloganLabel("Make your friends pay, " + user.getName() + "!");

        this.observer = observer;
        this.user = user;

        this.receipts = receipts;
    }

    public void displayView(){
        this.baseFrame.setVisible(true);
    }
}
