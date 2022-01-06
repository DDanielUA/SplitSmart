package com.SplitSmart.Application;

import com.SplitSmart.Logic.ActionObserver.ActionAgency;
import com.SplitSmart.Logic.ActionObserver.WelcomeAction;
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

    private ActionAgency<WelcomeAction> observer;
    private Person person;

    //private FeedbackView feedbackView;

    public static String regName;
    public static String regPhone;
    public static String regEmail;

    public RegView(ActionAgency<WelcomeAction> observer, Person person)
    {
        this.observer = observer;
        this.person = person;
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
        nameField.setFont(regFrame._BaseFont);
        nameField.setText("Example Ella");
        regFrame.add(nameField);

        //phone field creation and settings
        this.phoneField = new JTextField();
        phoneField.setPreferredSize(new Dimension(250, 30));
        phoneField.setBounds(180, 250, 250, 30);
        phoneField.setFont(regFrame._BaseFont);
        phoneField.setText("+36201234567");
        regFrame.add(phoneField);

        //email field creation and settings
        this.emailField = new JTextField();
        emailField.setPreferredSize(new Dimension(250, 30));
        emailField.setBounds(180, 300, 250, 30);
        emailField.setFont(regFrame._BaseFont);
        emailField.setText("example.ella@gmail.com");
        regFrame.add(emailField);
    }

    private void ConstructLabels()
    {
        //name label creation and settings
        this.nameLabel = new JLabel("Name: ");
        nameLabel.setFont(regFrame._BaseFont);
        nameLabel.setBounds(50, 200, 150, 30);
        regFrame.add(nameLabel);

        //phone label creation and settings
        this.phoneLabel = new JLabel("Phone number: ");
        phoneLabel.setFont(regFrame._BaseFont);
        phoneLabel.setBounds(50, 250, 150, 30);
        regFrame.add(phoneLabel);

        //email label creation and settings
        this.emailLabel = new JLabel("Email address: ");
        emailLabel.setFont(regFrame._BaseFont);
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
        regButton.setBackground(regFrame._ButtonColor);
        regButton.setBorder(regFrame._ButtonBorder);
        regFrame.add(regButton);
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
            this.person.setName(nameField.getText());
            this.person.setPhone(phoneField.getText());
            this.person.setEmail(emailField.getText());

            regFrame.setVisible(false);
            this.observer.update(WelcomeAction.AttemptRegister);
        }
    }

    public void displayView() { regFrame.setVisible(true); }
}
