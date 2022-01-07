package com.SplitSmart.Application.MainScene;

import com.SplitSmart.Application.BaseFrame;
import com.SplitSmart.Application.Config;
import com.SplitSmart.Application.Main;
import com.SplitSmart.Logic.ActionObserver.ActionAgency;
import com.SplitSmart.Logic.ActionObserver.MainAction;
import com.SplitSmart.Model.Person;
import com.SplitSmart.Model.Receipt;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainView extends MainBase implements ActionListener
{
    private JButton addButton;
    private JButton dieButton;
    private JButton sumButton;

    public MainView(ActionAgency<MainAction> observer, Person user, ArrayList<Receipt> receipts)
    {
        super(observer, user, receipts, new BaseFrame());

        ConstructButtons();
    }

    private void ConstructButtons()
    {
        //add button creation and settings
        this.addButton = new JButton();
        addButton.setBounds(200, 300, 70, 30);
        addButton.addActionListener(this);
        addButton.setText("Add");
        addButton.setFocusable(false);
        addButton.setBackground(Config._ButtonColor);
        addButton.setBorder(Config._ButtonBorder);
        baseFrame.add(addButton);

        //die button creation and settings
        this.dieButton = new JButton();
        dieButton.setBounds(200, 300, 70, 30);
        dieButton.addActionListener(this);
        dieButton.setText("Die");
        dieButton.setFocusable(false);
        dieButton.setBackground(Config._ButtonColor);
        dieButton.setBorder(Config._ButtonBorder);
        baseFrame.add(dieButton);

        //sum button creation and settings
        this.sumButton = new JButton();
        sumButton.setBounds(200, 300, 70, 30);
        sumButton.addActionListener(this);
        sumButton.setText("Sum");
        sumButton.setFocusable(false);
        sumButton.setBackground(Config._ButtonColor);
        sumButton.setBorder(Config._ButtonBorder);
        baseFrame.add(sumButton);

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()== addButton)
        {
            System.out.println("adding new bill");

            baseFrame.setVisible(false);
            //newView.displayView();
        }

        if (e.getSource()== dieButton)
        {
            System.out.println("do you wanna die?");

            //DelView delView = new DelView();
        }

        if (e.getSource()== sumButton)
        {
            System.out.println("sum of your trip");

            //DelView delView = new DelView();
        }
    }

    public void displayView()
    {
        baseFrame.setVisible(true);
    }
}
