package com.SplitSmart.Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeView extends BaseFrame implements ActionListener
{
    private JFrame welcomeFrame;

    private JLabel nameLabel;
    private JLabel sloganLabel;

    private JPanel headerPanel;
    private JPanel sloganPanel;
    private JPanel regPanel;
    private JPanel loginPanel;

    private JButton regButton;
    private JButton loginButton;

    private LoginView loginView;
    private RegView regView;

    public WelcomeView()
    {
        //base
        welcomeFrame = new JFrame();

        loginView = new LoginView();
        regView = new RegView();

        FrameSettings();
        ConstructLabels();
        ConstructPanels();
        ConstructButtons();
    }

    private void FrameSettings()
    {
        welcomeFrame.setTitle("SplitSmart App");
        welcomeFrame.setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));
        welcomeFrame.setResizable(true); //do we need this?
        welcomeFrame.setSize(500, 666);
        welcomeFrame.setLayout(null);
        welcomeFrame.setVisible(false);
        welcomeFrame.getContentPane().setBackground(_BackgroundColor);
        welcomeFrame.setIconImage(_Logo.getImage()); //changes the image on the frame
        //this.setLocationRelativeTo(null);
    }

    private void ConstructLabels()
    {
        //name label creation and settings
        this.nameLabel = new JLabel("SplitSmart"); //, SwingConstants.CENTER
        nameLabel.setIcon(_Logo);
        nameLabel.setHorizontalTextPosition(JLabel.CENTER);
        nameLabel.setVerticalTextPosition(JLabel.TOP);
        nameLabel.setFont(new Font("MV Boli", Font.BOLD, 20));
        nameLabel.setVerticalAlignment(JLabel.TOP);
        nameLabel.setHorizontalAlignment(JLabel.CENTER);
        nameLabel.setFont(baseFont);

        //slogan label creation and settings
        this.sloganLabel = new JLabel(); //you could just add text here
        sloganLabel.setText("Make your friends pay!");
        sloganLabel.setFont(baseFont);
    }

    private void ConstructPanels()
    {
        //header panel creation and settings
        this.headerPanel = new JPanel();
        headerPanel.setBackground(_BackgroundColor);
        headerPanel.setBounds(0, 0, 500, 500);
        headerPanel.add(nameLabel);
        welcomeFrame.add(headerPanel);

        //slogan panel creation and settings
        this.sloganPanel = new JPanel();
        sloganPanel.setBackground(_BackgroundColor);
        sloganPanel.setBounds(0, 500, 500, 50);
        sloganPanel.add(sloganLabel);
        welcomeFrame.add(sloganPanel);

        //registration panel creation and settings
        this.regPanel = new JPanel();
        regPanel.setBackground(_BackgroundColor);
        regPanel.setBounds(0, 550, 250, 200);
        regPanel.add(regButton);
        welcomeFrame.add(regPanel);

        //login panel creation and settings
        this.loginPanel = new JPanel();
        loginPanel.setBackground(_BackgroundColor);
        loginPanel.setBounds(250, 550, 250, 200);
        loginPanel.add(loginButton);
        welcomeFrame.add(loginPanel);
    }

    private void ConstructButtons()
    {
        //login button creation and settings
        this.loginButton = new JButton();
        loginButton.setBounds(550, 250, 150, 50);
        loginButton.addActionListener(this);
        loginButton.setText("LogIn");
        loginButton.setFocusable(false);
        loginButton.setBackground(buttonColor);
        loginButton.setBorder(buttonBorder);

        //registration button creation and settings
        this.regButton = new JButton();
        regButton.setBounds(250, 250, 150, 50);
        regButton.addActionListener(this);
        regButton.setText("Register");
        regButton.setFocusable(false);
        regButton.setBackground(buttonColor);
        regButton.setBorder(buttonBorder);
    }

    public void displayView()
    {
        welcomeFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()== loginButton)
        {
            welcomeFrame.dispose();
            loginView.displayView();
        }

        if(e.getSource()== regButton)
        {
            welcomeFrame.dispose();
            regView.displayView();
        }
    }
}
