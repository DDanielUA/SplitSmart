package com.SplitSmart.Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame implements ActionListener
{
    BaseFrame loginFrame;
    JTextField name;
    JTextField id;
    JButton login;

    LoginView()
    {
        loginFrame = new BaseFrame();

        //name
        name = new JTextField();
        name.setPreferredSize(new Dimension(250, 30));
        name.setBounds(150, 200, 250, 30);
        name.setFont(new Font("Consolas", Font.PLAIN, 14));
        name.setText("Example Ella");
        loginFrame.add(name);

        JLabel nameLabel = new JLabel("Name: ");
        nameLabel.setFont(new Font("Consolas", Font.PLAIN, 14));
        nameLabel.setBounds(60, 200, 150, 30);
        loginFrame.add(nameLabel);

        //id
        id = new JTextField();
        id.setPreferredSize(new Dimension(250, 30));
        id.setBounds(150, 250, 250, 30);
        id.setFont(new Font("Consolas", Font.PLAIN, 14));
        id.setText("123");
        loginFrame.add(id);

        JLabel idLabel = new JLabel("ID number: ");
        idLabel.setFont(new Font("Consolas", Font.PLAIN, 14));
        idLabel.setBounds(60, 250, 150, 30);
        loginFrame.add(idLabel);

        //LogIn button
        login = new JButton();
        login.setBounds(200, 300, 70, 30);
        login.addActionListener(this);
        login.setText("LogIn");
        login.setFocusable(false);
        login.setBackground(new Color(58, 167, 92));
        login.setBorder(BorderFactory.createEtchedBorder());
        loginFrame.add(login);

        //loginFrame.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        /*if(e.getSource()==back)
        {
            System.out.println("back");
            //loginFrame.dispose();
            //welcomeView.displayView();
        } */

        if(e.getSource()==login)
        {
            System.out.println("logging in");
            String loginName = name.getText();
            try{
                int loginId = Integer.parseInt(id.getText());
            }
            catch (NumberFormatException ex)
            {
                ex.printStackTrace();
            }

            //loginFrame.dispose();
            //mainView.displayView();
        }

    }

    public void displayLogin() { loginFrame.setVisible(true); }
}
