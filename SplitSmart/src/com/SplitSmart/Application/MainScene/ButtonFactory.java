package com.SplitSmart.Application.MainScene;

import com.SplitSmart.Application.Config;
import com.SplitSmart.Model.Receipt;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class ButtonFactory extends JButton
{
    ButtonFactory(){}

    //creating buttons, base for bill view list
    public JButton getButton(Receipt receipt)
    {
        JButton button = new JButton();
        button.setText(receipt.getRecName());
        button.setFocusable(false);
        button.setBackground(Config._ButtonColor);
        button.setBorder(Config._ButtonBorder);
        button.addActionListener(e -> System.out.println(receipt.getDescription()));

        return button;
    }
}
