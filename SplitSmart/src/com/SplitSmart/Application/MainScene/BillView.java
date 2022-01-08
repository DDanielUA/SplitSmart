package com.SplitSmart.Application.MainScene;

import com.SplitSmart.Application.BaseFrame;
import com.SplitSmart.Application.Config;
import com.SplitSmart.Logic.ActionObserver.ActionAgency;
import com.SplitSmart.Logic.ActionObserver.UserAction;
import com.SplitSmart.Model.Person;
import com.SplitSmart.Model.Receipt;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BillView extends MainBase implements ActionListener
{
    private JButton payButton;

    private final ActionAgency<UserAction> observer;
    private final ArrayList<Person> participants;
    private final Receipt selectedReceipt;

    public BillView(ActionAgency<UserAction> observer, Person user, ArrayList<Person> participants, Receipt receipt)
    {
        super(observer, user, new BaseFrame());
        this.observer = observer;
        this.participants = participants;
        this.selectedReceipt = receipt;

        ConstructLabels();
        ConstructButtons();
    }

    private void ConstructLabels()
    {
        //label for the name of the receipt
        JLabel billLabel = new JLabel("Name of receipt: " + selectedReceipt.getRecName());
        billLabel.setFont(Config._BaseFont);
        billLabel.setBounds(20, 200, 150, 30);
        baseFrame.add(billLabel);

        //label for the description of the receipt
        JLabel descLabel = new JLabel("Description of receipt: " + selectedReceipt.getDescription());
        descLabel.setFont(Config._BaseFont);
        descLabel.setBounds(20, 250, 300, 30);
        baseFrame.add(descLabel);

        //label for the date of purchase
        JLabel dateLabel = new JLabel("Date of purchase: " + selectedReceipt.getDate().toString());
        dateLabel.setFont(Config._BaseFont);
        dateLabel.setBounds(20, 300, 300, 30);
        baseFrame.add(dateLabel);

        //label for the total amount of purchase
        JLabel totalLabel = new JLabel("Total amount of purchase: " + selectedReceipt.getTotalCost());
        totalLabel.setFont(Config._BaseFont);
        totalLabel.setBounds(20, 350, 300, 30);
        baseFrame.add(totalLabel);

        //label for euro symbol
        JLabel eurLabel = new JLabel("€");
        eurLabel.setFont(Config._BaseFont);
        eurLabel.setBounds(420, 350, 150, 30);
        baseFrame.add(eurLabel);

        //label for participating users
        StringBuilder names = new StringBuilder();
        for (Person p : participants){
            names.append(p.getName()).append(", ");
        }
        JLabel participantsLabel = new JLabel("Names of the people who participated: " + names);
        participantsLabel.setFont(Config._BaseFont);
        participantsLabel.setBounds(20, 400, 350, 30);
        baseFrame.add(participantsLabel);
    }

    private void ConstructButtons()
    {
        //add button creation and settings
        this.payButton = new JButton();
        payButton.setBounds(200, 300, 70, 30);
        payButton.addActionListener(this);
        payButton.setText("Pay");
        payButton.setFocusable(false);
        payButton.setBackground(Config._ButtonColor);
        payButton.setBorder(Config._ButtonBorder);
        baseFrame.add(payButton);

        baseFrame.backButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()== payButton)
        {
            baseFrame.dispose();
            observer.update(UserAction.PayDebt);
        }
        if (e.getSource() == baseFrame.backButton)
        {
            baseFrame.dispose();
            observer.update(UserAction.Default);
        }
    }

    public void displayView(){
        baseFrame.setVisible(true);
    }
}
