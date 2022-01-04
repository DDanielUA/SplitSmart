package com.SplitSmart.Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame implements ActionListener
{
    BaseFrame loginFrame;

    LoginView()
    {
        loginFrame = new BaseFrame();

        loginFrame.setLayout(new FlowLayout());

        JTextField name = new JTextField();
        name.setPreferredSize(new Dimension(250, 40));
        loginFrame.add(name);

        loginFrame.pack();


        //button
        JButton login = new JButton();
        login.setBounds(20, 40, 70, 30);
        login.addActionListener(e -> System.out.println("back"));
        login.setText("Back");
        login.setFocusable(false);
        login.setBackground(new Color(58, 167, 92));
        login.setBorder(BorderFactory.createEtchedBorder());
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

    }

    public void displayLogin() { loginFrame.setVisible(true); }
}
