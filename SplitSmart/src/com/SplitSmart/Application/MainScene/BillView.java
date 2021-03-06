package com.SplitSmart.Application.MainScene;

import com.SplitSmart.Application.BaseFrame;
import com.SplitSmart.Application.Config;
import com.SplitSmart.Logic.ActionObserver.ActionAgent;
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

    private final ActionAgent<UserAction> observer;
    private final ArrayList<Person> participants;
    private final Receipt selectedReceipt;
    private final boolean isPayed;

    public BillView(ActionAgent<UserAction> observer, Person user, ArrayList<Person> participants, Receipt receipt, boolean isPayed)
    {
        super(observer, user, new BaseFrame());
        this.observer = observer;
        this.participants = participants;
        this.selectedReceipt = receipt;
        this.isPayed = isPayed;

        ConstructLabels();

        DecidePayedOption();
    }

    private void DecidePayedOption() {
        if (this.isPayed)
        {
            //label for showing if the bill is paid
            JLabel isPayedLabel = new JLabel("The bill is payed ");
            isPayedLabel.setIcon(Config._CheckMark);
            isPayedLabel.setHorizontalTextPosition(JLabel.LEFT);
            isPayedLabel.setFont(Config._BaseFont);
            isPayedLabel.setBounds(150, 500, 200, 30);
            baseFrame.add(isPayedLabel);
        }
        else
        {
            //add button creation and settings
            this.payButton = new JButton();
            payButton.setBounds(200, 550, 70, 30);
            payButton.addActionListener(this);
            payButton.setText("Pay");
            payButton.setFocusable(false);
            payButton.setBackground(Config._ButtonColor);
            payButton.setBorder(Config._ButtonBorder);
            baseFrame.add(payButton);
        }
        baseFrame.backButton.addActionListener(this);
    }

    private void ConstructLabels()
    {
        //label for the name of the receipt
        JLabel billLabel = new JLabel("Name of receipt: " + selectedReceipt.getRecName());
        billLabel.setFont(Config._BaseFont);
        billLabel.setBounds(20, 200, 480, 30);
        baseFrame.add(billLabel);

        //label for the description of the receipt
        JTextArea descLabel = new JTextArea("Description of receipt: " + selectedReceipt.getDescription());
        descLabel.setFont(Config._BaseFont);
        descLabel.setBounds(20, 250, 450, 30);
        descLabel.setLineWrap(true);
        descLabel.setEditable(false);
        descLabel.setBackground(Config._BackgroundColor);
        baseFrame.add(descLabel);

        //label for the date of purchase
        JLabel dateLabel = new JLabel("Date of purchase: " + selectedReceipt.getDate().toString());
        dateLabel.setFont(Config._BaseFont);
        dateLabel.setBounds(20, 300, 500, 30);
        baseFrame.add(dateLabel);

        //label for the total amount of purchase
        JLabel totalLabel = new JLabel("Total amount of purchase: " + selectedReceipt.getTotalCost());
        totalLabel.setFont(Config._BaseFont);
        totalLabel.setBounds(20, 350, 250, 30);
        baseFrame.add(totalLabel);

        //label for euro symbol
        JLabel eurLabel = new JLabel("???");
        eurLabel.setFont(Config._BaseFont);
        eurLabel.setBounds(270, 350, 150, 30);
        baseFrame.add(eurLabel);

        //label for participating users
        StringBuilder names = new StringBuilder();
        for (int i = 0; i < participants.size(); i++){
            if (i < participants.size() -1 ){
                names.append(participants.get(i).getName()).append(", ");
            }
            else{
                names.append(participants.get(i).getName());
            }
        }
        JTextArea participantsLabel = new JTextArea("Names of the people who participated: " + names);
        participantsLabel.setFont(Config._BaseFont);
        participantsLabel.setBounds(20, 400, 450, 30);
        participantsLabel.setLineWrap(true);
        participantsLabel.setEditable(false);
        participantsLabel.setBackground(Config._BackgroundColor);
        baseFrame.add(participantsLabel);

        String payingPerson = "Me";
        for (int i = 0; i < participants.size(); i++)
        {
            if (participants.get(i).getPersonId() == this.selectedReceipt.getPayingPersonId())
            {
                payingPerson = participants.get(i).getName();
                break;
            }
        }
        JTextArea payingPersonLabel = new JTextArea("Who payed for this receipt: " + payingPerson);
        payingPersonLabel.setFont(Config._BaseFont);
        payingPersonLabel.setBounds(20, 450, 450, 30);
        payingPersonLabel.setLineWrap(true);
        payingPersonLabel.setEditable(false);
        payingPersonLabel.setBackground(Config._BackgroundColor);
        baseFrame.add(payingPersonLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()== payButton)
        {
            baseFrame.dispose();
            observer.update(UserAction.PayDebt, this.selectedReceipt);
        }
        if (e.getSource() == baseFrame.backButton)
        {
            baseFrame.dispose();
            observer.update(UserAction.Default);
        }
    }
}
