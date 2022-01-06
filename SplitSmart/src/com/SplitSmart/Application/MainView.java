package com.SplitSmart.Application;

import com.SplitSmart.Model.Connector;
import com.SplitSmart.Model.Person;
import com.SplitSmart.Model.Receipt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainView implements ActionListener
{
    private BaseFrame mainFrame;

    private JButton addButton;
    private JButton dieButton;
    private JButton sumButton;

    //private NewView newView;

    public MainView(ArrayList<Receipt> receiptList) //we need a specific user's receipts
    {
        mainFrame = new BaseFrame();
        //newView = new NewView();

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
        addButton.setBackground(mainFrame._ButtonColor);
        addButton.setBorder(mainFrame._ButtonBorder);
        mainFrame.add(addButton);

        //die button creation and settings
        this.dieButton = new JButton();
        dieButton.setBounds(200, 300, 70, 30);
        dieButton.addActionListener(this);
        dieButton.setText("Die");
        dieButton.setFocusable(false);
        dieButton.setBackground(mainFrame._ButtonColor);
        dieButton.setBorder(mainFrame._ButtonBorder);
        mainFrame.add(dieButton);

        //sum button creation and settings
        this.sumButton = new JButton();
        sumButton.setBounds(200, 300, 70, 30);
        sumButton.addActionListener(this);
        sumButton.setText("Sum");
        sumButton.setFocusable(false);
        sumButton.setBackground(mainFrame._ButtonColor);
        sumButton.setBorder(mainFrame._ButtonBorder);
        mainFrame.add(sumButton);

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()== addButton)
        {
            System.out.println("adding new bill");

            mainFrame.setVisible(false);
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
        mainFrame.setVisible(true);
    }
}
