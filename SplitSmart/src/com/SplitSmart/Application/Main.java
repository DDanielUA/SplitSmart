package com.SplitSmart.Application;
import javax.swing.JFrame;

public class Main {

    public static void main(String[] args)
    {
        System.out.println("Make your friends pay!");

        JFrame frame = new JFrame();
        frame.setTitle("SplitSmart App");
        frame.setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));
        frame.setResizable(false); //ez az hogy nem lehet állítani az ablak méretet, idk kell e majd kitaláljuk
        frame.setSize(1024, 640);
        frame.setVisible(true);

    }
}
