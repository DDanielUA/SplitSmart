package com.SplitSmart.Application.WelcomeScene;

import com.SplitSmart.Application.BaseFrame;
import com.SplitSmart.Application.Config;
import com.SplitSmart.Logic.ActionObserver.ActionAgency;
import com.SplitSmart.Logic.ActionObserver.WelcomeAction;
import com.SplitSmart.Model.Person;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FeedbackView extends WelcomeBase implements ActionListener
{
    private JButton loginButton;

    public FeedbackView(ActionAgency<WelcomeAction> observer, Person user)
    {
        super(observer, user, new BaseFrame());

        ConstructLabels();
        ConstructButtons();
    }

    private void ConstructLabels()
    {
        //name label creation and settings
        String text = String.format("Your name is %s.", this.user.getName());
        JLabel nameLabel = new JLabel();
        nameLabel.setText(text);
        nameLabel.setFont(Config._BaseFont);
        nameLabel.setBounds(60, 200, 300, 50);
        this.baseFrame.add(nameLabel);

        //id label creation and settings
        JLabel idLabel = new JLabel(String.format("Your ID is %s.", this.user.getPersonId()));
        idLabel.setFont(Config._BaseFont);
        idLabel.setBounds(60, 250, 150, 50);
        this.baseFrame.add(idLabel);
    }

    private void ConstructButtons()
    {
        //login button creation and settings
        loginButton = new JButton();
        loginButton.setBounds(150, 400, 150, 50);
        loginButton.addActionListener(this);
        loginButton.setText("LogIn");
        loginButton.setFocusable(false);
        loginButton.setBackground(Config._ButtonColor);
        loginButton.setBorder(Config._ButtonBorder);
        this.baseFrame.add(loginButton);

        this.baseFrame.backButton.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()== loginButton)
        {
            this.baseFrame.setVisible(false);
            observer.update(WelcomeAction.InitiateLogIn);
        }
    }
}
