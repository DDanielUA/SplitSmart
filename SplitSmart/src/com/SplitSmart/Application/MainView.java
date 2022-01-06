package com.SplitSmart.Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView implements ActionListener
{
    private BaseFrame mainFrame;

    private JButton addButton;
    private JButton dieButton;

    private NewView newView;

    public MainView()
    {
        mainFrame = new BaseFrame();
        newView = new NewView();

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
        addButton.setBackground(mainFrame.buttonColor);
        addButton.setBorder(mainFrame.buttonBorder);
        mainFrame.add(addButton);

        //die button creation and settings
        this.dieButton = new JButton();
        dieButton.setBounds(200, 300, 70, 30);
        dieButton.addActionListener(this);
        dieButton.setText("Die");
        dieButton.setFocusable(false);
        dieButton.setBackground(mainFrame.buttonColor);
        dieButton.setBorder(mainFrame.buttonBorder);
        mainFrame.add(dieButton);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()== addButton)
        {
            System.out.println("adding new bill");

            mainFrame.dispose();
            newView.displayView();
        }

        if (e.getSource()== dieButton)
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
