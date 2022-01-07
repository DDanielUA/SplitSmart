package com.SplitSmart.Application.WelcomeScene;

import com.SplitSmart.Application.BaseFrame;
import com.SplitSmart.Logic.ActionObserver.ActionAgency;
import com.SplitSmart.Logic.ActionObserver.WelcomeAction;
import com.SplitSmart.Model.Person;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FeedbackView extends WelcomeBase implements ActionListener
{
    private JLabel nameLabel;
    private JLabel idLabel;

    private JButton loginButton;

    public FeedbackView(ActionAgency<WelcomeAction> observer, Person user)
    {
        super(observer, user);

        ConstructLabels();
        ConstructButtons();
    }

    private void ConstructLabels()
    {
        //name label creation and settings
        String text = String.format("Your name is %s.", this.user.getName());
        this.nameLabel = new JLabel();
        nameLabel.setText(text);
        nameLabel.setFont(this._BaseFont);
        nameLabel.setBounds(60, 200, 300, 50);
        this.add(nameLabel);

        //id label creation and settings
        this.idLabel = new JLabel(String.format("Your ID is %s.", this.user.getPersonId()));
        idLabel.setFont(this._BaseFont);
        idLabel.setBounds(60, 250, 150, 50);
        this.add(idLabel);
    }

    private void ConstructButtons()
    {
        //login button creation and settings
        this.loginButton = new JButton();
        loginButton.setBounds(150, 400, 150, 50);
        loginButton.addActionListener(this);
        loginButton.setText("LogIn");
        loginButton.setFocusable(false);
        loginButton.setBackground(this._ButtonColor);
        loginButton.setBorder(this._ButtonBorder);
        this.add(loginButton);

        backButton.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()== loginButton)
        {
            this.setVisible(false);
            this.observer.update(WelcomeAction.InitiateLogIn);
        }
    }

    public void displayView()
    {
        this.setVisible(true);
    }
}
