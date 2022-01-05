package com.SplitSmart.Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegView extends JFrame implements ActionListener
{
    BaseFrame regFrame;
    JTextField name;
    JTextField phone;
    JTextField email;
    JButton reg;
    FeedbackView feedbackView;

    public static String regName;
    public static String regPhone;
    public static String regEmail;

    RegView()
    {
        regFrame = new BaseFrame();

        //name
        name = new JTextField();
        name.setPreferredSize(new Dimension(250, 30));
        name.setBounds(180, 200, 250, 30);
        name.setFont(new Font("Consolas", Font.PLAIN, 14));
        name.setText("Example Ella");
        regFrame.add(name);
        feedbackView = new FeedbackView();

        JLabel nameLabel = new JLabel("Name: ");
        nameLabel.setFont(new Font("Consolas", Font.PLAIN, 14));
        nameLabel.setBounds(50, 200, 150, 30);
        regFrame.add(nameLabel);

        //phone
        phone = new JTextField();
        phone.setPreferredSize(new Dimension(250, 30));
        phone.setBounds(180, 250, 250, 30);
        phone.setFont(new Font("Consolas", Font.PLAIN, 14));
        phone.setText("+36201234567");
        regFrame.add(phone);

        JLabel phoneLabel = new JLabel("Phone number: ");
        phoneLabel.setFont(new Font("Consolas", Font.PLAIN, 14));
        phoneLabel.setBounds(50, 250, 150, 30);
        regFrame.add(phoneLabel);

        //email
        email = new JTextField();
        email.setPreferredSize(new Dimension(250, 30));
        email.setBounds(180, 300, 250, 30);
        email.setFont(new Font("Consolas", Font.PLAIN, 14));
        email.setText("example.ella@gmail.com");
        regFrame.add(email);

        JLabel emailLabel = new JLabel("Email address: ");
        emailLabel.setFont(new Font("Consolas", Font.PLAIN, 14));
        emailLabel.setBounds(50, 300, 150, 30);
        regFrame.add(emailLabel);

        //registration button
        reg = new JButton();
        reg.setBounds(200, 350, 70, 30);
        reg.addActionListener(this);
        reg.setText("LogIn");
        reg.setFocusable(false);
        reg.setBackground(new Color(58, 167, 92));
        reg.setBorder(BorderFactory.createEtchedBorder());
        regFrame.add(reg);

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==reg)
        {
            System.out.println("adding you to the system");
            regName = name.getText();
            regPhone = phone.getText();
            regEmail = email.getText();

            regFrame.dispose();
            feedbackView.displayView();
        }
    }

    public void displayView() { regFrame.setVisible(true); }
}
