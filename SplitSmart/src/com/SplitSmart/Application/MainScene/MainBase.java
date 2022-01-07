package com.SplitSmart.Application.MainScene;

import com.SplitSmart.Application.BaseFrame;
import com.SplitSmart.Logic.ActionObserver.ActionAgency;
import com.SplitSmart.Logic.ActionObserver.MainAction;
import com.SplitSmart.Model.Person;
import com.SplitSmart.Model.Receipt;

import java.util.ArrayList;

class MainBase {
    protected BaseFrame baseFrame;

    protected ActionAgency<MainAction> observer;
    protected Person user;
    protected ArrayList<Receipt> receipts;

    protected MainBase(ActionAgency<MainAction> observer, Person user, ArrayList<Receipt> receipts, BaseFrame frame){
        this.baseFrame = frame;

        this.observer = observer;
        this.user = user;
        this.receipts = receipts;
    }
}
