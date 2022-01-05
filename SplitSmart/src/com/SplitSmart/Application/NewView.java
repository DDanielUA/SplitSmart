package com.SplitSmart.Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.zip.DataFormatException;

public class NewView extends JFrame implements ActionListener
{
    BaseFrame newFrame;
    JTextField billName;
    JTextField desc;
    JTextField date; //DATE
    JTextField total; //DOUBLE
    JCheckBox equal;
    //MainView mainView;

    JButton add;

    NewView()
    {
        newFrame = new BaseFrame();
        //mainView = new MainView();

        //name of the receipt
        billName = new JTextField();
        billName.setPreferredSize(new Dimension(250, 30));
        billName.setBounds(170, 200, 250, 30);
        billName.setFont(new Font("Consolas", Font.PLAIN, 14));
        billName.setText("LIDL");
        newFrame.add(billName);


        JLabel billLabel = new JLabel("Name of receipt: ");
        billLabel.setFont(new Font("Consolas", Font.PLAIN, 14));
        billLabel.setBounds(20, 200, 150, 30);
        newFrame.add(billLabel);

        //description of the receipt
        desc = new JTextField();
        desc.setPreferredSize(new Dimension(250, 30));
        desc.setBounds(170, 250, 250, 30);
        desc.setFont(new Font("Consolas", Font.PLAIN, 14));
        desc.setText("Groceries from LIDL in Antwerp");
        newFrame.add(desc);

        JLabel descLabel = new JLabel("Description of receipt: ");
        descLabel.setFont(new Font("Consolas", Font.PLAIN, 14));
        descLabel.setBounds(20, 250, 150, 30);
        newFrame.add(descLabel);

        //date of purchase
        date = new JTextField();
        date.setPreferredSize(new Dimension(250, 30));
        date.setBounds(170, 300, 250, 30);
        date.setFont(new Font("Consolas", Font.PLAIN, 14));
        date.setText("2022-01-03");
        newFrame.add(date);

        JLabel dateLabel = new JLabel("Date of purchase: ");
        dateLabel.setFont(new Font("Consolas", Font.PLAIN, 14));
        dateLabel.setBounds(20, 300, 150, 30);
        newFrame.add(dateLabel);

        //total amount of purchase
        total = new JTextField();
        total.setPreferredSize(new Dimension(250, 30));
        total.setBounds(170, 350, 250, 30);
        total.setFont(new Font("Consolas", Font.PLAIN, 14));
        total.setText("56");
        newFrame.add(total);

        JLabel totalLabel = new JLabel("Total amount of purchase: ");
        totalLabel.setFont(new Font("Consolas", Font.PLAIN, 14));
        totalLabel.setBounds(20, 350, 150, 30);
        newFrame.add(totalLabel);

        JLabel eurLabel = new JLabel("€");
        eurLabel.setFont(new Font("Consolas", Font.PLAIN, 14));
        eurLabel.setBounds(420, 350, 150, 30);
        newFrame.add(eurLabel);

        equal = new JCheckBox("Is the amount equally distributed?");
        equal.setFocusable(false);
        equal.setFont(new Font("Consolas", Font.PLAIN, 14));
        equal.setBounds(170, 400, 300, 30);
        newFrame.add(equal);

        //add button
        add = new JButton();
        add.setBounds(170, 470, 70, 30);
        add.addActionListener(this);
        add.setText("LogIn");
        add.setFocusable(false);
        add.setBackground(new Color(58, 167, 92));
        add.setBorder(BorderFactory.createEtchedBorder());
        newFrame.add(add);

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==add)
        {
            System.out.println("adding new bill");
            String bill = billName.getText();
            String description = desc.getText();
            try{
                LocalDate dateVar = LocalDate.parse(date.getText());
            }
            catch (DateTimeException ex)
            {
                ex.printStackTrace();
            }

            try{
                double totalCost = Double.parseDouble(total.getText());
            }
            catch (NumberFormatException ex)
            {
                ex.printStackTrace();
            }
            boolean isEqual = equal.isSelected();

            //newFrame.dispose();
            //mainView.displayView();
        }

    }

    public void displayView() { newFrame.setVisible(true); }
}
