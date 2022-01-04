package com.SplitSmart.Application;

import javax.swing.*;
import java.awt.*;

public class BaseFrame extends JFrame
{
    BaseFrame()
    {
        JLabel slogan = new JLabel(); //you could just add text here
        slogan.setText("Make your friends pay!");

        JLabel name = new JLabel("SplitSmart");

        this.setTitle("SplitSmart App");
        this.setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));
        this.setResizable(false); //do we need this?
        this.setSize(1024, 640);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(53, 190, 205));

        ImageIcon logo = new ImageIcon("logo_png.png");
        this.setIconImage(logo.getImage()); //changes the image on the frame NOT WORKING

        this.add(name);
        this.add(slogan);
    }

}
