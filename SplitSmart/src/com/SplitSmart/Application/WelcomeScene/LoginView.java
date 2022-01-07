package com.SplitSmart.Application.WelcomeScene;

import com.SplitSmart.Application.BaseFrame;
import com.SplitSmart.Application.Config;
import com.SplitSmart.Logic.ActionObserver.ActionAgency;
import com.SplitSmart.Logic.ActionObserver.WelcomeAction;
import com.SplitSmart.Model.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends WelcomeBase implements ActionListener
{
    private JTextField nameField;
    private JTextField idField;

    private JButton loginButton;

    private final boolean isError;

    public LoginView(ActionAgency<WelcomeAction> observer, Person user, boolean isError)
    {
        super(observer, user, new BaseFrame());
        this.isError = isError;

        ConstructFields();
        ConstructLabels();
        ConstructButtons();
    }

    private void ConstructFields()
    {
        //name field creation and settings
        nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(250, 30));
        nameField.setBounds(150, 200, 250, 30);
        nameField.setFont(Config._BaseFont);
        nameField.setText("Ella");
        this.baseFrame.add(nameField);

        //id field creation and settings
        idField = new JTextField();
        idField.setPreferredSize(new Dimension(250, 30));
        idField.setBounds(150, 250, 250, 30);
        idField.setFont(Config._BaseFont);
        idField.setText("123");
        this.baseFrame.add(idField);
    }

    private void ConstructLabels()
    {
        //name label creation and settings
        JLabel nameLabel = new JLabel("Name: ");
        nameLabel.setFont(Config._BaseFont);
        nameLabel.setBounds(60, 200, 150, 30);
        this.baseFrame.add(nameLabel);

        //id label creation and settings
        JLabel idLabel = new JLabel("ID number: ");
        idLabel.setFont(Config._BaseFont);
        idLabel.setBounds(60, 250, 150, 30);
        this.baseFrame.add(idLabel);

        if (isError){
            //Failed login label
            JLabel errorLabel = new JLabel("Wrong username or id!");
            errorLabel.setFont(Config._ErrorFont);
            errorLabel.setForeground(Color.red);
            errorLabel.setBounds(60, 300, 300, 30);
            baseFrame.add(errorLabel);
        }
    }

    private void ConstructButtons()
    {
        //login button creation and settings
        loginButton = new JButton();
        loginButton.setBounds(200, 350, 70, 30);
        loginButton.addActionListener(this);
        loginButton.setText("LogIn");
        loginButton.setFocusable(false);
        loginButton.setBackground(Config._ButtonColor);
        loginButton.setBorder(Config._ButtonBorder);
        this.baseFrame.add(loginButton);

        this.baseFrame.backButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == loginButton)
        {
            try{
                user.setPersonId(Integer.parseInt(idField.getText()));
            }
            catch (NumberFormatException ex)
            {
                ex.printStackTrace();
            }

            user.setName(nameField.getText());

            this.baseFrame.dispose();
            observer.update(WelcomeAction.AttemptLogIn);
        }

        if (e.getSource() == baseFrame.backButton){
            this.baseFrame.dispose();
            observer.update(WelcomeAction.Default);
        }
    }

    public void displayView() { baseFrame.setVisible(true); }
}
