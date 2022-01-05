package com.SplitSmart.Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView extends JFrame implements ActionListener
{
    BaseFrame mainFrame;
    JButton add;
    JButton die;
    NewView newView;

    MainView()
    {
        mainFrame = new BaseFrame();
        newView = new NewView();

        //add button
        add = new JButton();
        add.setBounds(200, 300, 70, 30);
        add.addActionListener(this);
        add.setText("Add");
        add.setFocusable(false);
        add.setBackground(new Color(58, 167, 92));
        add.setBorder(BorderFactory.createEtchedBorder());
        mainFrame.add(add);

        //die button
        die = new JButton();
        die.setBounds(200, 300, 70, 30);
        die.addActionListener(this);
        die.setText("Die");
        die.setFocusable(false);
        die.setBackground(new Color(58, 167, 92));
        die.setBorder(BorderFactory.createEtchedBorder());
        mainFrame.add(die);


    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==add)
        {
            System.out.println("adding new bill");

            mainFrame.dispose();
            newView.displayView();
        }

        if (e.getSource()==die)
        {
            System.out.println("do you wanna die?");

            DelView delView = new DelView();
        }
    }

    public void displayView()
    {
        mainFrame.setVisible(true);
    }
}
