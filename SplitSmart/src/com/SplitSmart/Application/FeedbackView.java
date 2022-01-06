package com.SplitSmart.Application;

import com.SplitSmart.Model.Person;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FeedbackView implements ActionListener
{
    private BaseFrame feedbackFrame;

    private JLabel nameLabel;
    private JLabel idLabel;

    private JButton loginButton;

    //private LoginView loginView;

    public FeedbackView(Person user) //we need user.PersonId and user.Name
    {
        feedbackFrame = new BaseFrame();
        //loginView = new LoginView();

        ConstructLabels();
        ConstructButtons();
    }

    private void ConstructLabels()
    {
        //name label creation and settings
        String text = String.format("Your name is %s.", RegView.regName);
        this.nameLabel = new JLabel();
        nameLabel.setText(text);
        nameLabel.setFont(feedbackFrame._BaseFont);
        nameLabel.setBounds(60, 200, 150, 50);
        feedbackFrame.add(nameLabel);

        //id label creation and settings
        this.idLabel = new JLabel(String.format("Your ID is %s.", 2));
        idLabel.setFont(feedbackFrame._BaseFont);
        idLabel.setBounds(60, 250, 150, 50);
        feedbackFrame.add(idLabel);
    }

    private void ConstructButtons()
    {
        //login button creation and settings
        this.loginButton = new JButton();
        loginButton.setBounds(150, 400, 150, 50);
        loginButton.addActionListener(this);
        loginButton.setText("LogIn");
        loginButton.setFocusable(false);
        loginButton.setBackground(feedbackFrame._ButtonColor);
        loginButton.setBorder(feedbackFrame._ButtonBorder);
        feedbackFrame.add(loginButton);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()== loginButton)
        {
            feedbackFrame.setVisible(false);
            //loginView.displayView();
        }
    }

    public void displayView()
    {
        feedbackFrame.setVisible(true);
    }
}
