package com.SplitSmart.Application.MainScene;

import com.SplitSmart.Application.BaseFrame;
import com.SplitSmart.Application.Config;
import com.SplitSmart.Logic.ActionObserver.ActionAgency;
import com.SplitSmart.Logic.ActionObserver.MainAction;
import com.SplitSmart.Model.Person;
import com.SplitSmart.Model.Receipt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

public class NewView extends MainBase implements ActionListener
{
    private JTextField billNameField;
    private JTextField descField;
    private JTextField dateField; //DATE
    private JTextField totalField; //DOUBLE

    private JCheckBox equalCheckBox;

    private JButton addButton;

    public NewView(ActionAgency<MainAction> observer, Person user, ArrayList<Receipt> receipts)
    {
        super(observer, user, receipts, new BaseFrame());

        ConstructFields();
        ConstructLabels();
        ConstructCheckboxes();
        ConstructButtons();
    }

    private void ConstructFields()
    {
        //text field for the name of the receipt
        this.billNameField = new JTextField();
        billNameField.setPreferredSize(new Dimension(250, 30));
        billNameField.setBounds(170, 200, 250, 30);
        billNameField.setFont(Config._BaseFont);
        billNameField.setText("LIDL");
        baseFrame.add(billNameField);

        //text field for the description of the receipt
        this.descField = new JTextField();
        descField.setPreferredSize(new Dimension(250, 30));
        descField.setBounds(170, 250, 250, 30);
        descField.setFont(Config._BaseFont);
        descField.setText("Groceries from LIDL in Antwerp");
        baseFrame.add(descField);

        //text field for the date of purchase
        this.dateField = new JTextField();
        dateField.setPreferredSize(new Dimension(250, 30));
        dateField.setBounds(170, 300, 250, 30);
        dateField.setFont(Config._BaseFont);
        dateField.setText("2022-01-03");
        baseFrame.add(dateField);

        //text field for the total amount of purchase
        this.totalField = new JTextField();
        totalField.setPreferredSize(new Dimension(250, 30));
        totalField.setBounds(170, 350, 250, 30);
        totalField.setFont(Config._BaseFont);
        totalField.setText("56");
        baseFrame.add(totalField);
    }

    private void ConstructLabels()
    {
        //label for the name of the receipt
        JLabel billLabel = new JLabel("Name of receipt: ");
        billLabel.setFont(Config._BaseFont);
        billLabel.setBounds(20, 200, 150, 30);
        baseFrame.add(billLabel);

        //label for the description of the receipt
        JLabel descLabel = new JLabel("Description of receipt: ");
        descLabel.setFont(Config._BaseFont);
        descLabel.setBounds(20, 250, 150, 30);
        baseFrame.add(descLabel);

        //label for the date of purchase
        JLabel dateLabel = new JLabel("Date of purchase: ");
        dateLabel.setFont(Config._BaseFont);
        dateLabel.setBounds(20, 300, 150, 30);
        baseFrame.add(dateLabel);

        //label for the total amount of purchase
        JLabel totalLabel = new JLabel("Total amount of purchase: ");
        totalLabel.setFont(Config._BaseFont);
        totalLabel.setBounds(20, 350, 150, 30);
        baseFrame.add(totalLabel);

        //label for euro symbol
        JLabel eurLabel = new JLabel("€");
        eurLabel.setFont(Config._BaseFont);
        eurLabel.setBounds(420, 350, 150, 30);
        baseFrame.add(eurLabel);
    }

    private void ConstructCheckboxes()
    {
        //checkbox for version of the bill
        this.equalCheckBox = new JCheckBox("Is the amount equally distributed?");
        equalCheckBox.setFocusable(false);
        equalCheckBox.setFont(Config._BaseFont);
        equalCheckBox.setBounds(170, 400, 300, 30);
        baseFrame.add(equalCheckBox);
    }

    private void ConstructButtons()
    {
        //add button creation and settings
        this.addButton = new JButton();
        addButton.setBounds(170, 470, 70, 30);
        addButton.addActionListener(this);
        addButton.setText("LogIn");
        addButton.setFocusable(false);
        addButton.setBackground(Config._ButtonColor);
        addButton.setBorder(Config._ButtonBorder);
        baseFrame.add(addButton);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()== addButton)
        {
            System.out.println("adding new bill");
            String bill = billNameField.getText();
            String description = descField.getText();
            try{
                LocalDate dateVar = LocalDate.parse(dateField.getText());
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }

            try{
                double totalCost = Double.parseDouble(totalField.getText());
            }
            catch (NumberFormatException ex)
            {
                ex.printStackTrace();
            }
            boolean isEqual = equalCheckBox.isSelected();

            baseFrame.setVisible(false);
        }
    }

    public void displayView() { baseFrame.setVisible(true); }
}
