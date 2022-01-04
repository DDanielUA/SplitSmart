package com.SplitSmart.Application;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class WelcomeView extends JFrame
{
    JFrame welcomeFrame;
    JButton reg;
    JButton log;

    WelcomeView()
    {
        //base
        welcomeFrame = new JFrame();

        ImageIcon logo = new ImageIcon("src/com/SplitSmart/Images/logo coloured.jpg");
        Color background = new Color(162, 243, 185);
        Border buttonBorder = BorderFactory.createEtchedBorder();
        LoginView loginView = new LoginView();

        //slogan label creation and settings
        JLabel slogan = new JLabel(); //you could just add text here
        slogan.setText("Make your friends pay!");

        //name label creation and settings
        JLabel name = new JLabel("SplitSmart"); //, SwingConstants.CENTER
        //name.setText("SplitSmart"); //"<html>First line<br>Second line</html>"
        name.setIcon(logo);
        name.setHorizontalTextPosition(JLabel.CENTER);
        name.setVerticalTextPosition(JLabel.TOP);
        name.setFont(new Font("MV Boli", Font.BOLD, 20));
        name.setVerticalAlignment(JLabel.TOP);
        name.setHorizontalAlignment(JLabel.CENTER);
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
        log.setBounds(50, 250, 70, 30);
        log.addActionListener(e -> loginView.displayLogin());
        log.setText("LogIn");
        log.setFocusable(false);
        log.setBackground(new Color(58, 167, 92));
        log.setBorder(buttonBorder);

        //reg button
        reg = new JButton();
        reg.setBounds(250, 250, 120, 30);
        reg.addActionListener(e -> System.out.println("reg"));
        reg.setText("Register");
        reg.setFocusable(false);
        reg.setBackground(new Color(58, 167, 92));
        reg.setBorder(buttonBorder);

        //adding panels
        JPanel header = new JPanel();
        header.setBackground(background);
        header.setBounds(0, 0, 500, 120);

        JPanel sloganPanel = new JPanel();
        sloganPanel.setBackground(background);
        sloganPanel.setBounds(0, 120, 500, 50);

        this.add(header);
        this.add(sloganPanel);

        header.add(name);
        sloganPanel.add(slogan);
    }

    public void DisplayView()
    {
        welcomeFrame.setVisible(true);
    }
}
