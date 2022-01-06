package com.SplitSmart.Application;

import com.SplitSmart.Logic.ActionObserver.ActionAgency;
import com.SplitSmart.Logic.ActionObserver.WelcomeAction;
import com.SplitSmart.Model.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView implements ActionListener
{
    private BaseFrame loginFrame;

    private JTextField nameField;
    private JTextField idField;

    private JLabel nameLabel;
    private JLabel idLabel;

    private JButton loginButton;

    //Logic observer
    private ActionAgency<WelcomeAction> observer;
    //Logic data
    private Person person;

    //private MainView mainView;

    public LoginView(ActionAgency<WelcomeAction> observer, Person person)
    {
        this.observer = observer;
        this.person = person;

        loginFrame = new BaseFrame();
        //mainView = new MainView();

        ConstructFields();
        ConstructLabels();
        ConstructButtons();
    }

    private void ConstructFields()
    {
        //name field creation and settings
        this.nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(250, 30));
        nameField.setBounds(150, 200, 250, 30);
        nameField.setFont(loginFrame._BaseFont);
        nameField.setText("Example Ella");
        loginFrame.add(nameField);

        //id field creation and settings
        this.idField = new JTextField();
        idField.setPreferredSize(new Dimension(250, 30));
        idField.setBounds(150, 250, 250, 30);
        idField.setFont(loginFrame._BaseFont);
        idField.setText("123");
        loginFrame.add(idField);
    }

    private void ConstructLabels()
    {
        //name label creation and settings
        this.nameLabel = new JLabel("Name: ");
        nameLabel.setFont(loginFrame._BaseFont);
        nameLabel.setBounds(60, 200, 150, 30);
        loginFrame.add(nameLabel);

        //id label creation and settings
        this.idLabel = new JLabel("ID number: ");
        idLabel.setFont(loginFrame._BaseFont);
        idLabel.setBounds(60, 250, 150, 30);
        loginFrame.add(idLabel);
    }

    private void ConstructButtons()
    {
        //login button creation and settings
        this.loginButton = new JButton();
        loginButton.setBounds(200, 300, 70, 30);
        loginButton.addActionListener(this);
        loginButton.setText("LogIn");
        loginButton.setFocusable(false);
        loginButton.setBackground(loginFrame._ButtonColor);
        loginButton.setBorder(loginFrame._ButtonBorder);
        loginFrame.add(loginButton);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()== loginButton)
        {
            System.out.println("logging in");
            //String loginName = nameField.getText();
            try{
                this.person.setPersonId(Integer.parseInt(idField.getText()));
            }
            catch (NumberFormatException ex)
            {
                ex.printStackTrace();
            }

            this.person.setName(nameField.getText());

            loginFrame.setVisible(false);
            this.observer.update(WelcomeAction.AttemptLogIn);
        }
    }

    public void displayView() { loginFrame.setVisible(true); }
}
