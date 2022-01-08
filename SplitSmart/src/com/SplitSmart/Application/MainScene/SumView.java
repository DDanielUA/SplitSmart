package com.SplitSmart.Application.MainScene;

import com.SplitSmart.Application.BaseFrame;
import com.SplitSmart.Application.Main;
import com.SplitSmart.Logic.ActionObserver.ActionAgency;
import com.SplitSmart.Logic.ActionObserver.UserAction;
import com.SplitSmart.Model.Person;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SumView extends MainBase implements ActionListener
{
    private BaseFrame sumFrame;

    public SumView(ActionAgency<UserAction> observer, Person user)
    {
        super(observer, user, new BaseFrame());

    }

    private void ConstructLabels(){

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
