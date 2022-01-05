package com.SplitSmart.Application;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeView extends JFrame implements ActionListener
{
    JFrame welcomeFrame;
    JButton reg;
    JButton log;
    LoginView loginView;

    WelcomeView()
    {
        //base
        welcomeFrame = new JFrame();

        ImageIcon logo = new ImageIcon("src/com/SplitSmart/Images/logo coloured.jpg");
        Color background = new Color(162, 243, 185);
        Border buttonBorder = BorderFactory.createEtchedBorder();
        loginView = new LoginView();

        //slogan label creation and settings
        JLabel slogan = new JLabel(); //you could just add text here
        slogan.setText("Make your friends pay!");
        slogan.setFont(new Font("Consolas", Font.PLAIN, 14));

        //name label creation and settings
        JLabel name = new JLabel("SplitSmart"); //, SwingConstants.CENTER
        name.setIcon(logo);
        name.setHorizontalTextPosition(JLabel.CENTER);
        name.setVerticalTextPosition(JLabel.TOP);
        name.setFont(new Font("MV Boli", Font.BOLD, 20));
        name.setVerticalAlignment(JLabel.TOP);
        name.setHorizontalAlignment(JLabel.CENTER);
        name.setFont(new Font("Consolas", Font.PLAIN, 14));
        //name.setBounds(100, 0, 250, 250);

        //setting basic things in the frame
        welcomeFrame.setTitle("SplitSmart App");
        welcomeFrame.setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));
        welcomeFrame.setResizable(true); //do we need this?
        welcomeFrame.setSize(500, 666);
        welcomeFrame.setLayout(null);
        welcomeFrame.setVisible(false);
        welcomeFrame.getContentPane().setBackground(background);
        welcomeFrame.setIconImage(logo.getImage()); //changes the image on the frame
        //this.setLocationRelativeTo(null);

        //log button
        log = new JButton();
        log.setBounds(550, 250, 150, 50);
        log.addActionListener(this);
        log.setText("LogIn");
        log.setFocusable(false);
        log.setBackground(new Color(58, 167, 92));
        log.setBorder(buttonBorder);

        //reg button
        reg = new JButton();
        reg.setBounds(250, 250, 150, 50);
        reg.addActionListener(e -> System.out.println("reg"));
        reg.setText("Register");
        reg.setFocusable(false);
        reg.setBackground(new Color(58, 167, 92));
        reg.setBorder(buttonBorder);

        //adding panels
        JPanel header = new JPanel();
        header.setBackground(background);
        header.setBounds(0, 0, 500, 500);

        JPanel sloganPanel = new JPanel();
        sloganPanel.setBackground(background);
        sloganPanel.setBounds(0, 500, 500, 50);

        JPanel regPanel = new JPanel();
        regPanel.setBackground(background);
        regPanel.setBounds(0, 550, 250, 200);

        JPanel logPanel = new JPanel();
        logPanel.setBackground(background);
        logPanel.setBounds(250, 550, 250, 200);

        welcomeFrame.add(header);
        welcomeFrame.add(sloganPanel);
        welcomeFrame.add(regPanel);
        welcomeFrame.add(logPanel);

        header.add(name);
        sloganPanel.add(slogan);
        regPanel.add(reg);
        logPanel.add(log);
    }

    public void displayView()
    {
        welcomeFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==log)
        {
            welcomeFrame.dispose();
            loginView.displayLogin();
            //welcomeFrame.setVisible(false);
        }
    }
}
