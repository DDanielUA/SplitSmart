package com.SplitSmart.Application.MainScene;

import com.SplitSmart.Application.BaseFrame;
import com.SplitSmart.Application.Config;
import com.SplitSmart.Application.Main;
import com.SplitSmart.Logic.ActionObserver.ActionAgency;
import com.SplitSmart.Logic.ActionObserver.UserAction;
import com.SplitSmart.Model.Person;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.Callable;

public class SumView extends MainBase implements ActionListener
{
    ArrayList<Map.Entry<Person, Float>> summary;

    public SumView(ActionAgency<UserAction> observer, Person user, ArrayList<Map.Entry<Person, Float>> summary)
    {
        super(observer, user, new BaseFrame());

        this.summary = summary;
        ConstructLabels();
        this.baseFrame.backButton.addActionListener(this);
    }

    private void ConstructLabels()
    {
        SumFactory sFactory = new SumFactory();

        int y = 200;
        for (Map.Entry<Person, Float> sum : summary){
            JLabel sumLabel = sFactory.getLabel(sum.getKey().getName(), sum.getValue());
            sumLabel.setFont(Config._BaseFont);
            sumLabel.setBounds(20, y, 400, 30);
            baseFrame.add(sumLabel);

            y += 50;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == baseFrame.backButton){
            observer.update(UserAction.Default);
            baseFrame.dispose();
        }
    }

    public void displayView() { baseFrame.setVisible(true); }
}
