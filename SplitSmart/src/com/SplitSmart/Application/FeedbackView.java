package com.SplitSmart.Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FeedbackView extends JFrame implements ActionListener
{
    BaseFrame feedbackFrame;
    JButton login;
    LoginView loginView;

    FeedbackView()
    {
        feedbackFrame = new BaseFrame();
        loginView = new LoginView();

        //name
        String text = String.format("Your name is %s.", RegView.regName);
        JLabel nameLabel = new JLabel();
        nameLabel.setText(text);
        nameLabel.setFont(new Font("Consolas", Font.PLAIN, 14));
        nameLabel.setBounds(60, 200, 150, 50);
        feedbackFrame.add(nameLabel);

        //id
        JLabel idLabel = new JLabel(String.format("Your ID is %s.", 2));
        idLabel.setFont(new Font("Consolas", Font.PLAIN, 14));
        idLabel.setBounds(60, 250, 150, 50);
        feedbackFrame.add(idLabel);

        //login button
        login = new JButton();
        login.setBounds(150, 400, 150, 50);
        login.addActionListener(this);
        login.setText("LogIn");
        login.setFocusable(false);
        login.setBackground(new Color(58, 167, 92));
        login.setBorder(BorderFactory.createEtchedBorder());
        feedbackFrame.add(login);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==login)
        {
            feedbackFrame.dispose();
            loginView.displayView();
        }
    }

    public void displayView()
    {
        feedbackFrame.setVisible(true);
    }
}
