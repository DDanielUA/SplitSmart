package com.SplitSmart.Application.MainScene;

import com.SplitSmart.Application.BaseFrame;
import com.SplitSmart.Application.Config;
import com.SplitSmart.Logic.ActionObserver.ActionAgency;
import com.SplitSmart.Logic.ActionObserver.UserAction;
import com.SplitSmart.Model.Person;
import com.SplitSmart.Model.Receipt;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainView extends MainBase implements ActionListener
{
    private JButton addButton;
    private JButton dieButton;
    private JButton sumButton;

    public MainView(ActionAgency<UserAction> observer, Person user, ArrayList<Receipt> receipts)
    {
        super(observer, user, receipts, new BaseFrame());

        ConstructButtons();
        ConstructList();
    }

    private void ConstructList()
    {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Config._BackgroundColor);
        buttonPanel.setBounds(0, 500, 500, 500);

        int numOfButtons = receipts.size();
        ButtonFactory factory = new ButtonFactory();

        for (int i = 0; i < numOfButtons; i++)
        {
            int y = 0;
            JButton button = factory.getButton(receipts.get(i));
            button.setBounds(200, y, 70, 30);
            buttonPanel.add(button);
            y = y + 50;
        }

        baseFrame.add(buttonPanel);
    }

    private void ConstructButtons()
    {
        //add button creation and settings
        this.addButton = new JButton();
        addButton.setBounds(200, 300, 70, 30);
        addButton.addActionListener(this);
        addButton.setText("Add");
        addButton.setFocusable(false);
        addButton.setBackground(Config._ButtonColor);
        addButton.setBorder(Config._ButtonBorder);
        baseFrame.add(addButton);

        //die button creation and settings
        this.dieButton = new JButton();
        dieButton.setBounds(250, 350, 70, 30);
        dieButton.addActionListener(this);
        dieButton.setText("Die");
        dieButton.setFocusable(false);
        dieButton.setBackground(Config._ButtonColor);
        dieButton.setBorder(Config._ButtonBorder);
        baseFrame.add(dieButton);

        //sum button creation and settings
        this.sumButton = new JButton();
        sumButton.setBounds(150, 350, 70, 30);
        sumButton.addActionListener(this);
        sumButton.setText("Sum");
        sumButton.setFocusable(false);
        sumButton.setBackground(Config._ButtonColor);
        sumButton.setBorder(Config._ButtonBorder);
        baseFrame.add(sumButton);

        this.baseFrame.backButton.setText("LogOut");
        baseFrame.backButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == addButton)
        {
            baseFrame.dispose();
            observer.update(UserAction.AddReceipt);
        }

        if (e.getSource() == dieButton)
        {
            baseFrame.dispose();
            observer.update(UserAction.DeleteUser);
        }

        if (e.getSource() == sumButton)
        {
            baseFrame.dispose();
            observer.update(UserAction.ShowSummary);
        }

        if (e.getSource() == baseFrame.backButton){
            baseFrame.dispose();
            observer.update(UserAction.LogOut);
        }
    }

    public void displayView()
    {
        baseFrame.setVisible(true);
    }
}
