package com.SplitSmart.Application;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BaseFrame extends JFrame
{
    JButton back;

    BaseFrame()
    {
        //creating basic components
        ImageIcon logo = new ImageIcon("src/com/SplitSmart/Images/logo coloured.jpg");
        ImageIcon smallLogo = new ImageIcon(new ImageIcon("src/com/SplitSmart/Images/logo coloured.jpg").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
        ImageIcon logoGrey = new ImageIcon("src/com/SplitSmart/Images/logo.jpg");
        Border buttonBorder = BorderFactory.createEtchedBorder();
        Color background = new Color(162, 243, 185);

        //button
        back = new JButton();
        back.setBounds(30, 60, 100, 50);
        back.addActionListener(e -> System.out.println("back"));
        back.setText("Back");
        back.setFocusable(false);
        back.setBackground(new Color(58, 167, 92));
        back.setBorder(buttonBorder);

        //slogan label creation and settings
        JLabel slogan = new JLabel(); //you could just add text here
        slogan.setText("Make your friends pay!");
        slogan.setFont(new Font("Consolas", Font.PLAIN, 14));


        //name label creation and settings
        JLabel name = new JLabel("SplitSmart"); //, SwingConstants.CENTER
        name.setText("SplitSmart"); //"<html>First line<br>Second line</html>"
        name.setIcon(smallLogo);
        name.setHorizontalTextPosition(JLabel.CENTER);
        name.setVerticalTextPosition(JLabel.TOP);
        name.setFont(new Font("MV Boli", Font.BOLD, 20));
        name.setVerticalAlignment(JLabel.TOP);
        name.setHorizontalAlignment(JLabel.CENTER);
        name.setFont(new Font("Consolas", Font.PLAIN, 14));
        //name.setBounds(100, 0, 250, 250);

        //setting basic things in the frame
        this.setTitle("SplitSmart App");
        this.setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));
        this.setResizable(true); //do we need this?
        this.setSize(500, 666);
        this.setLayout(null);
        this.setVisible(false);
        this.getContentPane().setBackground(background);
        this.setIconImage(logo.getImage()); //changes the image on the frame
        //this.setLocationRelativeTo(null);

        //adding panels
        JPanel backPanel = new JPanel();
        backPanel.setBackground(background);
        backPanel.setBounds(0, 0, 100, 120);

        JPanel header = new JPanel();
        //header.setLayout(new FlowLayout( FlowLayout.CENTER));
        header.setBackground(background);
        header.setBounds(100, 0, 300, 120);

        JPanel sloganPanel = new JPanel();
        //sloganPanel.setLayout( new GridLayout( 2 , 1 ) );  // 2 rows 1 column
        sloganPanel.setBackground(background);
        sloganPanel.setBounds(0, 120, 500, 50);

        //header.add(sloganPanel);

        //editing label things in the frame

        this.add(backPanel);
        this.add(header);
        this.add(sloganPanel);

        backPanel.add(back);
        header.add(name);
        sloganPanel.add(slogan);

        //this.add(name);
        //this.add(slogan);
        //this.pack(); //makes the frame as big as components need it to be
    }


}
