package com.SplitSmart.Application;
import com.SplitSmart.Model.Person;
import com.SplitSmart.Repository.PersonRepository;
import com.SplitSmart.Repository.SplitSmartContext;

import javax.swing.*;
import java.util.ArrayList;

public class Main {

    private static SplitSmartContext ctx;

    public static void main(String[] args)
    {
        System.out.println("Make your friends pay!");

        JFrame frame = new JFrame();
        frame.setTitle("SplitSmart App");
        frame.setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));
        frame.setResizable(false); //ez az hogy nem lehet állítani az ablak méretet, idk kell e majd kitaláljuk
        frame.setSize(1024, 640);
        frame.setVisible(true);

        /*
        ctx = SplitSmartContext.GetInstance();
        PersonRepository perRepo = new PersonRepository(ctx);
         */
    }
}
