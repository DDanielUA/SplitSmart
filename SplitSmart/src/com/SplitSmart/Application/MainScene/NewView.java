package com.SplitSmart.Application.MainScene;

import com.SplitSmart.Application.BaseFrame;
import com.SplitSmart.Application.Config;
import com.SplitSmart.Application.MainScene.Model.NewReceiptResult;
import com.SplitSmart.Logic.ActionObserver.ActionAgent;
import com.SplitSmart.Logic.ActionObserver.UserAction;
import com.SplitSmart.Model.Person;
import com.SplitSmart.Model.Receipt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class NewView extends MainBase implements ActionListener
{
    private JTextField billNameField;
    private JTextField descField;
    private JTextField totalField; //DOUBLE
    private JTextField howMuchField;
    private JTextField participantsField;

    private JTextArea howMuchLabel;

    private JCheckBox equalCheckBox;

    private JButton addButton;

    public NewView(ActionAgent<UserAction> observer, Person user)
    {
        super(observer, user, null, new BaseFrame());

        ConstructCheckboxes();
        ConstructFields();
        ConstructLabels();
        ConstructButtons();
    }

    private void ConstructFields()
    {
        //text field for the name of the receipt
        this.billNameField = new JTextField();
        billNameField.setPreferredSize(new Dimension(250, 30));
        billNameField.setBounds(210, 180, 240, 30);
        billNameField.setFont(Config._BaseFont);
        billNameField.setText("LIDL");
        baseFrame.add(billNameField);

        //text field for the description of the receipt
        this.descField = new JTextField();
        descField.setPreferredSize(new Dimension(250, 30));
        descField.setBounds(210, 230, 240, 30);
        descField.setFont(Config._BaseFont);
        descField.setText("Groceries from LIDL in Antwerp");
        baseFrame.add(descField);

        //text field for the date of purchase
        //DATE
        JTextField dateField = new JTextField();
        dateField.setPreferredSize(new Dimension(250, 30));
        dateField.setBounds(210, 280, 240, 30);
        dateField.setFont(Config._BaseFont);
        dateField.setText("2022-01-03");
        baseFrame.add(dateField);

        //text field for the total amount of purchase
        this.totalField = new JTextField();
        totalField.setPreferredSize(new Dimension(250, 30));
        totalField.setBounds(210, 330, 240, 30);
        totalField.setFont(Config._BaseFont);
        totalField.setText("56");
        baseFrame.add(totalField);

        //text field for participating users
        participantsField = new JTextField();
        participantsField.setPreferredSize(new Dimension(350, 30));
        participantsField.setBounds(20, 430, 350, 30);
        participantsField.setFont(Config._BaseFont);
        participantsField.setText("Bill, Bob, Jane, Dalia");
        baseFrame.add(participantsField);

        //text field for amount of money payed for each person
        this.howMuchField = new JTextField();
        howMuchField.setPreferredSize(new Dimension(350, 30));
        howMuchField.setBounds(20, 590, 350, 30);
        howMuchField.setFont(Config._BaseFont);
        howMuchField.setText("10, 14, 15.50, 16.50");
        howMuchField.setVisible(false);
        baseFrame.add(howMuchField);
    }

    private void ConstructLabels()
    {
        //label for the name of the receipt
        JLabel billLabel = new JLabel("Name of receipt: ");
        billLabel.setFont(Config._BaseFont);
        billLabel.setBounds(20, 180, 150, 30);
        baseFrame.add(billLabel);

        //label for the description of the receipt
        JLabel descLabel = new JLabel("Description of receipt: ");
        descLabel.setFont(Config._BaseFont);
        descLabel.setBounds(20, 230, 200, 30);
        baseFrame.add(descLabel);

        //label for the date of purchase
        JLabel dateLabel = new JLabel("Date of purchase: ");
        dateLabel.setFont(Config._BaseFont);
        dateLabel.setBounds(20, 280, 150, 30);
        baseFrame.add(dateLabel);

        //label for the total amount of purchase
        JLabel totalLabel = new JLabel("Total amount spent: ");
        totalLabel.setFont(Config._BaseFont);
        totalLabel.setBounds(20, 330, 200, 30);
        baseFrame.add(totalLabel);

        //label for euro symbol
        JLabel eurLabel = new JLabel("€");
        eurLabel.setFont(Config._BaseFont);
        eurLabel.setBounds(460, 330, 150, 30);
        baseFrame.add(eurLabel);

        //labels for participating users
        JTextArea participantsLabel = new JTextArea("Names of the people who participated (Please enter in the format shown below):");
        participantsLabel.setFont(Config._BaseFont);
        participantsLabel.setBackground(Config._BackgroundColor);
        participantsLabel.setLineWrap(true);
        participantsLabel.setBounds(20, 380, 500, 30);
        baseFrame.add(participantsLabel);

        //label for saying who paid how much
        this.howMuchLabel = new JTextArea("How much each person payed (enter in the same order as the names, in the format below, using decimal points if needed:");
        howMuchLabel.setFont(Config._BaseFont);
        howMuchLabel.setBackground(Config._BackgroundColor);
        howMuchLabel.setLineWrap(true);
        howMuchLabel.setBounds(20, 530, 440, 50);
        howMuchLabel.setVisible(false);
        baseFrame.add(howMuchLabel);
    }

    private void ConstructCheckboxes()
    {
        //checkbox for version of the bill
        this.equalCheckBox = new JCheckBox("Is the amount equally distributed?");
        equalCheckBox.setFocusable(false);
        equalCheckBox.setFont(Config._BaseFont);
        equalCheckBox.setBounds(100, 480, 300, 30);
        equalCheckBox.setSelected(true);
        equalCheckBox.addActionListener(this);
        baseFrame.add(equalCheckBox);
    }

    private void ConstructButtons()
    {
        //add button creation and settings
        this.addButton = new JButton();
        addButton.setBounds(400, 590, 70, 30);
        addButton.addActionListener(this);
        addButton.setText("Add");
        addButton.setFocusable(false);
        addButton.setBackground(Config._ButtonColor);
        addButton.setBorder(Config._ButtonBorder);
        baseFrame.add(addButton);

        baseFrame.backButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == addButton)
        {
            Receipt newReceipt = new Receipt(
                    -1,
                    billNameField.getText(),
                    descField.getText(),
                    LocalDate.now(),
                    Float.parseFloat(totalField.getText()),
                    equalCheckBox.isSelected(),
                    this.user.getPersonId()
            );

            NewReceiptResult result = new NewReceiptResult(newReceipt, participantsField.getText(), howMuchField.getText());

            baseFrame.dispose();
            this.observer.update(UserAction.AddReceipt, result);
        }
        if (e.getSource() == baseFrame.backButton){

            baseFrame.dispose();
            this.observer.update(UserAction.Default);
        }
        if (e.getSource() == equalCheckBox)
        {
            if (equalCheckBox.isSelected()){
                howMuchField.setVisible(false);
                howMuchLabel.setVisible(false);
            }
            else{
                howMuchField.setVisible(true);
                howMuchLabel.setVisible(true);
            }
        }
    }
}
