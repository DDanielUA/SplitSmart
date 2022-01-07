package com.SplitSmart.Application.WelcomeScene;

import com.SplitSmart.Application.BaseFrame;
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

    private JLabel nameLabel;
    private JLabel phoneLabel;
    private JLabel emailLabel;

    private JButton regButton;

    public RegView(ActionAgency<WelcomeAction> observer, Person user)
    {
        super(observer, user);

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
        nameField.setFont(this._BaseFont);
        nameField.setText("Example Ella");
        this.add(nameField);

        //phone field creation and settings
        this.phoneField = new JTextField();
        phoneField.setPreferredSize(new Dimension(250, 30));
        phoneField.setBounds(180, 250, 250, 30);
        phoneField.setFont(this._BaseFont);
        phoneField.setText("+36201234567");
        this.add(phoneField);

        //email field creation and settings
        this.emailField = new JTextField();
        emailField.setPreferredSize(new Dimension(250, 30));
        emailField.setBounds(180, 300, 250, 30);
        emailField.setFont(this._BaseFont);
        emailField.setText("example.ella@gmail.com");
        this.add(emailField);
    }

    private void ConstructLabels()
    {
        //name label creation and settings
        this.nameLabel = new JLabel("Name: ");
        nameLabel.setFont(this._BaseFont);
        nameLabel.setBounds(50, 200, 150, 30);
        this.add(nameLabel);

        //phone label creation and settings
        this.phoneLabel = new JLabel("Phone number: ");
        phoneLabel.setFont(this._BaseFont);
        phoneLabel.setBounds(50, 250, 150, 30);
        this.add(phoneLabel);

        //email label creation and settings
        this.emailLabel = new JLabel("Email address: ");
        emailLabel.setFont(this._BaseFont);
        emailLabel.setBounds(50, 300, 150, 30);
        this.add(emailLabel);
    }

    private void ConstructButtons()
    {
        //registration button creation and settings
        this.regButton = new JButton();
        regButton.setBounds(200, 350, 70, 30);
        regButton.addActionListener(this);
        regButton.setText("Register");
        regButton.setFocusable(false);
        regButton.setBackground(this._ButtonColor);
        regButton.setBorder(this._ButtonBorder);
        this.add(regButton);

        this.backButton.addActionListener(this);
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

            this.dispose();
            this.observer.update(WelcomeAction.AttemptRegister);
        }

        if (e.getSource() == backButton){
            this.dispose();
            this.observer.update(WelcomeAction.Default);
        }
    }

    public void displayView() { this.setVisible(true); }
}
