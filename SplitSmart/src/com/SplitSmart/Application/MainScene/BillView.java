package com.SplitSmart.Application.MainScene;

import com.SplitSmart.Application.BaseFrame;
import com.SplitSmart.Application.Config;
import com.SplitSmart.Model.Person;
import com.SplitSmart.Model.Receipt;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BillView implements ActionListener
{
    private BaseFrame billFrame;

    private JLabel billLabel;
    private JLabel descLabel;
    private JLabel dateLabel;
    private JLabel totalLabel;
    private JLabel eurLabel;
    private JLabel participantsLabel;

    private JLabel billLabel2;
    private JLabel descLabel2;
    private JLabel dateLabel2;
    private JLabel totalLabel2;
    private JLabel eurLabel2;
    private JLabel participantsLabel2;

    private JButton payButton;

    public BillView(Receipt receipt) //we will write out everything about it
    {
        billFrame = new BaseFrame();

        ConstructLabels();
        ConstructButtons();
    }

    private void ConstructLabels()
    {
        //label for the name of the receipt
        this.billLabel = new JLabel("Name of receipt: ");
        billLabel.setFont(Config._BaseFont);
        billLabel.setBounds(20, 200, 150, 30);
        billFrame.add(billLabel);

        /*
        this.billLabel2 = new JLabel(BillView.receipt.getName());
        billLabel2.setFont(Config._BaseFont);
        billLabel2.setBounds(170, 200, 150, 30);
        billFrame.add(billLabel2);
        */

        //label for the description of the receipt
        this.descLabel = new JLabel("Description of receipt: ");
        descLabel.setFont(Config._BaseFont);
        descLabel.setBounds(20, 250, 150, 30);
        billFrame.add(descLabel);

        //label for the date of purchase
        this.dateLabel = new JLabel("Date of purchase: ");
        dateLabel.setFont(Config._BaseFont);
        dateLabel.setBounds(20, 300, 150, 30);
        billFrame.add(dateLabel);

        //label for the total amount of purchase
        this.totalLabel = new JLabel("Total amount of purchase: ");
        totalLabel.setFont(Config._BaseFont);
        totalLabel.setBounds(20, 350, 150, 30);
        billFrame.add(totalLabel);

        //label for euro symbol
        this.eurLabel = new JLabel("€");
        eurLabel.setFont(Config._BaseFont);
        eurLabel.setBounds(420, 350, 150, 30);
        billFrame.add(eurLabel);

        //label for participating users
        this.participantsLabel = new JLabel("Names of the people who participated:");
        participantsLabel.setFont(Config._BaseFont);
        participantsLabel.setBounds(20, 400, 350, 30);
        billFrame.add(participantsLabel);
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
        billFrame.add(payButton);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()== payButton)
        {
            System.out.println("you payed your part of the bill");

            //receipt.isPayed = true;
        }
    }
}
