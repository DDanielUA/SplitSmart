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

public class RegView extends WelcomeBase implements ActionListener
{
    private JTextField nameField;
    private JTextField phoneField;
    private JTextField emailField;

    private JButton regButton;

    public RegView(ActionAgency<WelcomeAction> observer, Person user)
    {
        super(observer, user, new BaseFrame());

        ConstructFields();
        ConstructLabels();
        ConstructButtons();
    }

    private void ConstructFields()
    {
        //name field creation and settings
        this.nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(250, 30));
        nameField.setBounds(180, 200, 250, 30);
        nameField.setFont(Config._BaseFont);
        nameField.setText("Example Ella");
        baseFrame.add(nameField);

        //phone field creation and settings
        this.phoneField = new JTextField();
        phoneField.setPreferredSize(new Dimension(250, 30));
        phoneField.setBounds(180, 250, 250, 30);
        phoneField.setFont(Config._BaseFont);
        phoneField.setText("+36201234567");
        baseFrame.add(phoneField);

        //email field creation and settings
        this.emailField = new JTextField();
        emailField.setPreferredSize(new Dimension(250, 30));
        emailField.setBounds(180, 300, 250, 30);
        emailField.setFont(Config._BaseFont);
        emailField.setText("example.ella@gmail.com");
        baseFrame.add(emailField);
    }

    private void ConstructLabels()
    {
        //name label creation and settings
        JLabel nameLabel = new JLabel("Name: ");
        nameLabel.setFont(Config._BaseFont);
        nameLabel.setBounds(50, 200, 150, 30);
        baseFrame.add(nameLabel);

        //phone label creation and settings
        JLabel phoneLabel = new JLabel("Phone number: ");
        phoneLabel.setFont(Config._BaseFont);
        phoneLabel.setBounds(50, 250, 150, 30);
        baseFrame.add(phoneLabel);

        //email label creation and settings
        JLabel emailLabel = new JLabel("Email address: ");
        emailLabel.setFont(Config._BaseFont);
        emailLabel.setBounds(50, 300, 150, 30);
        baseFrame.add(emailLabel);
    }

    private void ConstructButtons()
    {
        //registration button creation and settings
        this.regButton = new JButton();
        regButton.setBounds(200, 350, 70, 30);
        regButton.addActionListener(this);
        regButton.setText("Register");
        regButton.setFocusable(false);
        regButton.setBackground(Config._ButtonColor);
        regButton.setBorder(Config._ButtonBorder);
        baseFrame.add(regButton);

        baseFrame.backButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()== regButton)
        {
            /// !!!!!
            /// CAN'T HAVE ';' ':' '|' IN NAME!!! (Repo.Data.SSML save/read file)
            /// !!!!!

            //System.out.println("adding you to the system");
            this.user.setName(nameField.getText());
            this.user.setPhone(phoneField.getText());
            this.user.setEmail(emailField.getText());

            baseFrame.dispose();
            this.observer.update(WelcomeAction.AttemptRegister);
        }

        if (e.getSource() == baseFrame.backButton){
            baseFrame.dispose();
            this.observer.update(WelcomeAction.Default);
        }
    }

    public void displayView() { baseFrame.setVisible(true); }
}
