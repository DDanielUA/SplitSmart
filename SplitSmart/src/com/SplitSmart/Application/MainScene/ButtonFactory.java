package com.SplitSmart.Application.MainScene;

import com.SplitSmart.Application.Config;
import com.SplitSmart.Model.Receipt;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class ButtonFactory extends JButton
{
    ButtonFactory(){}

    public JButton getButton(Receipt receipt)
    {
        JButton button = new JButton();
        button.setText(receipt.getRecName());
        //button.setBounds(200, -50, 70, 30);
        button.setFocusable(false);
        button.setBackground(Config._ButtonColor);
        button.setBorder(Config._ButtonBorder);
        button.addActionListener(e -> System.out.println(receipt.getDescription()));

        return button;
    }
}
