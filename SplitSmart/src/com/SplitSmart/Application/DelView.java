package com.SplitSmart.Application;

import com.SplitSmart.Model.Person;

import javax.swing.*;

public class DelView
{
    //MainView mainView;
    DelView(Person personToDelete) //we need to delete them
    {
        //mainView = new MainView();

        int answer = JOptionPane.showConfirmDialog
                (null,
                        "Are you sure you want to delete your account?",
                        "Don't let me die",
                        JOptionPane.YES_NO_OPTION); //0 = yes, 1 = no, -1 = x

        if (answer == 0)
        {
            //delete the user
            System.out.println("delete");
        }
        else
        {
            //go back to MainView
            System.out.println("back");

            //mainView.displayView();
        }
    }

}
