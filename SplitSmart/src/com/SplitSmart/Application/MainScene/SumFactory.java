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
        sumLabel.setText("Your money situation with " + name + " is " + money);
        sumLabel.setFont(Config._BaseFont);
        sumLabel.setBounds(20, 200, 500, 30);

        return sumLabel;
    }
}
