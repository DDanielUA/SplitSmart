package com.SplitSmart.Application.MainScene;

import com.SplitSmart.Application.BaseFrame;
import com.SplitSmart.Application.Config;
import com.SplitSmart.Logic.ActionObserver.ActionAgent;
import com.SplitSmart.Logic.ActionObserver.UserAction;
import com.SplitSmart.Model.Person;
import com.SplitSmart.Model.Receipt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainView extends MainBase implements ActionListener
{
    private JButton addButton;
    private JButton dieButton;
    private JButton sumButton;

    public MainView(ActionAgent<UserAction> observer, Person user, ArrayList<Receipt> receipts)
    {
        super(observer, user, receipts, new BaseFrame());

        ConstructList();
        ConstructButtons();
    }

    private void ConstructList()
    {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Config._BackgroundColor);
        buttonPanel.setBounds(150, 300, 500, 500);
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));    //Vertical button layout

        ButtonFactory factory = new ButtonFactory();

        for (Receipt receipt : this.receipts) {
            JButton button = factory.getButton(receipt);
            button.setMaximumSize(new Dimension(200, 30));
            button.addActionListener(this);
            buttonPanel.add(button);
            buttonPanel.add(Box.createRigidArea(new Dimension(0,20)));
        }

        baseFrame.add(buttonPanel);
    }

    private void ConstructButtons()
    {
        //add button creation and settings
        this.addButton = new JButton();
        addButton.setBounds(115, 200, 70, 30);
        addButton.addActionListener(this);
        addButton.setText("Add");
        addButton.setFocusable(false);
        addButton.setBackground(Config._ButtonColor);
        addButton.setBorder(Config._ButtonBorder);
        baseFrame.add(addButton);

        //die button creation and settings
        this.dieButton = new JButton();
        dieButton.setBounds(315, 200, 70, 30);
        dieButton.addActionListener(this);
        dieButton.setText("Die");
        dieButton.setFocusable(false);
        dieButton.setBackground(Config._ButtonColor);
        dieButton.setBorder(Config._ButtonBorder);
        baseFrame.add(dieButton);

        //sum button creation and settings
        this.sumButton = new JButton();
        sumButton.setBounds(215, 200, 70, 30);
        sumButton.addActionListener(this);
        sumButton.setText("Sum");
        sumButton.setFocusable(false);
        sumButton.setBackground(Config._ButtonColor);
        sumButton.setBorder(Config._ButtonBorder);
        baseFrame.add(sumButton);

        this.baseFrame.backButton.setText("LogOut");
        baseFrame.backButton.addActionListener(this);
    }

    private boolean displayDeletePopUp(){
        int answer = JOptionPane.showConfirmDialog
                (null,
                        "Are you sure you want to delete your account?",
                        "Don't let me die",
                        JOptionPane.YES_NO_OPTION); //0 = yes, 1 = no, -1 = x

        return answer == 0;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        JButton pressedButton = (JButton)e.getSource();
        if(pressedButton.equals(addButton))
        {
            baseFrame.dispose();
            observer.update(UserAction.NewReceipt);
        }
        else if (pressedButton.equals(dieButton))
        {
            boolean isDelete = displayDeletePopUp();
            baseFrame.dispose();
            observer.update(UserAction.DeleteUser, isDelete);
        }
        else if (pressedButton.equals(sumButton))
        {
            baseFrame.dispose();
            observer.update(UserAction.ShowSummary);
        }
        else if (pressedButton.equals(baseFrame.backButton))
        {
            baseFrame.dispose();
            observer.update(UserAction.LogOut);
        }
        else
        {
            for (Receipt r : receipts){
                if (pressedButton.getText().equals(r.getRecName())){
                    baseFrame.dispose();
                    observer.update(UserAction.ShowReceipt, r);
                }
            }
        }
    }
}
