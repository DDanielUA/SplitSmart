package com.SplitSmart.Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class NewView extends JFrame implements ActionListener
{
    private BaseFrame newFrame;

    private JTextField billNameField;
    private JTextField descField;
    private JTextField dateField; //DATE
    private JTextField totalField; //DOUBLE

    private JLabel billLabel;
    private JLabel descLabel;
    private JLabel dateLabel;
    private JLabel totalLabel;
    private JLabel eurLabel;

    private JCheckBox equalCheckBox;

    private JButton addButton;

    public NewView()
    {
        newFrame = new BaseFrame();

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
        billNameField.setFont(newFrame.baseFont);
        billNameField.setText("LIDL");
        newFrame.add(billNameField);

        //text field for the description of the receipt
        this.descField = new JTextField();
        descField.setPreferredSize(new Dimension(250, 30));
        descField.setBounds(170, 250, 250, 30);
        descField.setFont(newFrame.baseFont);
        descField.setText("Groceries from LIDL in Antwerp");
        newFrame.add(descField);

        //text field for the date of purchase
        this.dateField = new JTextField();
        dateField.setPreferredSize(new Dimension(250, 30));
        dateField.setBounds(170, 300, 250, 30);
        dateField.setFont(newFrame.baseFont);
        dateField.setText("2022-01-03");
        newFrame.add(dateField);

        //text field for the total amount of purchase
        this.totalField = new JTextField();
        totalField.setPreferredSize(new Dimension(250, 30));
        totalField.setBounds(170, 350, 250, 30);
        totalField.setFont(newFrame.baseFont);
        totalField.setText("56");
        newFrame.add(totalField);
    }

    private void ConstructLabels()
    {
        //label for the name of the receipt
        this.billLabel = new JLabel("Name of receipt: ");
        billLabel.setFont(newFrame.baseFont);
        billLabel.setBounds(20, 200, 150, 30);
        newFrame.add(billLabel);

        //label for the description of the receipt
        this.descLabel = new JLabel("Description of receipt: ");
        descLabel.setFont(newFrame.baseFont);
        descLabel.setBounds(20, 250, 150, 30);
        newFrame.add(descLabel);

        //label for the date of purchase
        this.dateLabel = new JLabel("Date of purchase: ");
        dateLabel.setFont(newFrame.baseFont);
        dateLabel.setBounds(20, 300, 150, 30);
        newFrame.add(dateLabel);

        //label for the total amount of purchase
        this.totalLabel = new JLabel("Total amount of purchase: ");
        totalLabel.setFont(newFrame.baseFont);
        totalLabel.setBounds(20, 350, 150, 30);
        newFrame.add(totalLabel);

        //label for euro symbol
        this.eurLabel = new JLabel("€");
        eurLabel.setFont(newFrame.baseFont);
        eurLabel.setBounds(420, 350, 150, 30);
        newFrame.add(eurLabel);
    }

    private void ConstructCheckboxes()
    {
        //checkbox for version of the bill
        this.equalCheckBox = new JCheckBox("Is the amount equally distributed?");
        equalCheckBox.setFocusable(false);
        equalCheckBox.setFont(newFrame.baseFont);
        equalCheckBox.setBounds(170, 400, 300, 30);
        newFrame.add(equalCheckBox);
    }

    private void ConstructButtons()
    {
        //add button creation and settings
        this.addButton = new JButton();
        addButton.setBounds(170, 470, 70, 30);
        addButton.addActionListener(this);
        addButton.setText("LogIn");
        addButton.setFocusable(false);
        addButton.setBackground(newFrame.buttonColor);
        addButton.setBorder(newFrame.buttonBorder);
        newFrame.add(addButton);
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

            newFrame.setVisible(false);
            //mainView.displayView();
        }
    }

    public void displayView() { newFrame.setVisible(true); }
}
