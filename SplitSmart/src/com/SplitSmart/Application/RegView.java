package com.SplitSmart.Application;

import com.SplitSmart.Model.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegView extends JFrame implements ActionListener
{
    private BaseFrame regFrame;

    private JTextField nameField;
    private JTextField phoneField;
    private JTextField emailField;

    private JLabel nameLabel;
    private JLabel phoneLabel;
    private JLabel emailLabel;

    private JButton regButton;

    //private FeedbackView feedbackView;

    public static String regName;
    public static String regPhone;
    public static String regEmail;

    public RegView()
    {
        regFrame = new BaseFrame();
        //feedbackView = new FeedbackView();

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
        nameField.setFont(regFrame.baseFont);
        nameField.setText("Example Ella");
        regFrame.add(nameField);

        //phone field creation and settings
        this.phoneField = new JTextField();
        phoneField.setPreferredSize(new Dimension(250, 30));
        phoneField.setBounds(180, 250, 250, 30);
        phoneField.setFont(regFrame.baseFont);
        phoneField.setText("+36201234567");
        regFrame.add(phoneField);

        //email field creation and settings
        this.emailField = new JTextField();
        emailField.setPreferredSize(new Dimension(250, 30));
        emailField.setBounds(180, 300, 250, 30);
        emailField.setFont(regFrame.baseFont);
        emailField.setText("example.ella@gmail.com");
        regFrame.add(emailField);
    }

    private void ConstructLabels()
    {
        //name label creation and settings
        this.nameLabel = new JLabel("Name: ");
        nameLabel.setFont(regFrame.baseFont);
        nameLabel.setBounds(50, 200, 150, 30);
        regFrame.add(nameLabel);

        //phone label creation and settings
        this.phoneLabel = new JLabel("Phone number: ");
        phoneLabel.setFont(regFrame.baseFont);
        phoneLabel.setBounds(50, 250, 150, 30);
        regFrame.add(phoneLabel);

        //email label creation and settings
        this.emailLabel = new JLabel("Email address: ");
        emailLabel.setFont(regFrame.baseFont);
        emailLabel.setBounds(50, 300, 150, 30);
        regFrame.add(emailLabel);
    }

    private void ConstructButtons()
    {
        //registration button creation and settings
        this.regButton = new JButton();
        regButton.setBounds(200, 350, 70, 30);
        regButton.addActionListener(this);
        regButton.setText("Register");
        regButton.setFocusable(false);
        regButton.setBackground(regFrame.buttonColor);
        regButton.setBorder(regFrame.buttonBorder);
        regFrame.add(regButton);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()== regButton)
        {
            System.out.println("adding you to the system");
            regName = nameField.getText();
            regPhone = phoneField.getText();
            regEmail = emailField.getText();

            regFrame.setVisible(false);
            //feedbackView.displayView();
        }
    }

    public void displayView() { regFrame.setVisible(true); }
}
