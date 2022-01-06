package com.SplitSmart.Application;

import com.SplitSmart.Model.Person;
import com.SplitSmart.Model.Receipt;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BillView implements ActionListener
{
    private BaseFrame billFrame;

    private JButton payButton;

    public BillView(Receipt receipt) //we will write out everything about it
    {
        billFrame = new BaseFrame();

        ConstructButtons();
    }

    private void ConstructButtons()
    {
        //add button creation and settings
        this.payButton = new JButton();
        payButton.setBounds(200, 300, 70, 30);
        payButton.addActionListener(this);
        payButton.setText("Pay");
        payButton.setFocusable(false);
        payButton.setBackground(billFrame._ButtonColor);
        payButton.setBorder(billFrame._ButtonBorder);
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
