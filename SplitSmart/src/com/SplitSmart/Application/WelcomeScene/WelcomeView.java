package com.SplitSmart.Application.WelcomeScene;

import com.SplitSmart.Application.Config;
import com.SplitSmart.Logic.ActionObserver.ActionAgency;
import com.SplitSmart.Logic.ActionObserver.WelcomeAction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeView extends WelcomeBase implements ActionListener
{
    private final JFrame welcomeFrame;

    private JLabel nameLabel;
    private JLabel sloganLabel;

    private JButton regButton;
    private JButton loginButton;


    public WelcomeView(ActionAgency<WelcomeAction> observer)
    {
        super(observer, null, null);

        welcomeFrame = new JFrame();

        FrameSettings();
        ConstructLabels();
        ConstructButtons();
        ConstructPanels();
    }

    private void FrameSettings()
    {
        welcomeFrame.setTitle("SplitSmart App");
        welcomeFrame.setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));
        welcomeFrame.setResizable(true); //do we need this?
        welcomeFrame.setSize(500, 666);
        welcomeFrame.setLayout(null);
        welcomeFrame.setVisible(false);
        welcomeFrame.getContentPane().setBackground(Config._BackgroundColor);
        welcomeFrame.setIconImage(Config._Logo.getImage()); //changes the image on the frame
        //this.setLocationRelativeTo(null);
    }

    private void ConstructLabels()
    {
        //name label creation and settings
        this.nameLabel = new JLabel("SplitSmart"); //, SwingConstants.CENTER
        nameLabel.setIcon(Config._Logo);
        nameLabel.setHorizontalTextPosition(JLabel.CENTER);
        nameLabel.setVerticalTextPosition(JLabel.TOP);
        nameLabel.setFont(new Font("MV Boli", Font.BOLD, 20));
        nameLabel.setVerticalAlignment(JLabel.TOP);
        nameLabel.setHorizontalAlignment(JLabel.CENTER);
        nameLabel.setFont(Config._BaseFont);

        //slogan label creation and settings
        this.sloganLabel = new JLabel(); //you could just add text here
        sloganLabel.setText("Make your friends pay!");
        sloganLabel.setFont(Config._BaseFont);
    }

    private void ConstructPanels()
    {
        //header panel creation and settings
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(Config._BackgroundColor);
        headerPanel.setBounds(0, 0, 500, 500);
        headerPanel.add(nameLabel);
        welcomeFrame.add(headerPanel);

        //slogan panel creation and settings
        JPanel sloganPanel = new JPanel();
        sloganPanel.setBackground(Config._BackgroundColor);
        sloganPanel.setBounds(0, 500, 500, 50);
        sloganPanel.add(sloganLabel);
        welcomeFrame.add(sloganPanel);

        //registration panel creation and settings
        JPanel regPanel = new JPanel();
        regPanel.setBackground(Config._BackgroundColor);
        regPanel.setBounds(0, 550, 250, 200);
        regPanel.add(regButton);
        welcomeFrame.add(regPanel);

        //login panel creation and settings
        JPanel loginPanel = new JPanel();
        loginPanel.setBackground(Config._BackgroundColor);
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
        loginButton.setBackground(Config._ButtonColor);
        loginButton.setBorder(Config._ButtonBorder);

        //registration button creation and settings
        this.regButton = new JButton();
        regButton.setBounds(250, 250, 150, 50);
        regButton.addActionListener(this);
        regButton.setText("Register");
        regButton.setFocusable(false);
        regButton.setBackground(Config._ButtonColor);
        regButton.setBorder(Config._ButtonBorder);
    }

    public void displayView()
    {
        welcomeFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == loginButton)
        {
            welcomeFrame.dispose();
            this.observer.update(WelcomeAction.InitiateLogIn);
        }

        if(e.getSource() == regButton)
        {
            welcomeFrame.dispose();
            this.observer.update(WelcomeAction.InitiateRegister);
        }
    }
}
