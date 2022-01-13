package com.SplitSmart.Application.MainScene;

import com.SplitSmart.Application.Config;

import javax.swing.*;

public class SumFactory
{
    SumFactory(){}

    //creating labels for global bills
    public JLabel getLabel(String name, float money)
    {
        JLabel sumLabel = new JLabel();

        sumLabel.setFont(Config._BaseFont);
        sumLabel.setBounds(20, 200, 500, 30);

        if (money > 0)
        {
            sumLabel.setText(name + " owes you " + Math.abs(money) + " euros.");
        }
        else
        {
            sumLabel.setText("You owe " + name + " " + Math.abs(money) + " euros.");
        }

        return sumLabel;
    }
}
