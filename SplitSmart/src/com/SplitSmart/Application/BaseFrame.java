package com.SplitSmart.Application;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BaseFrame extends JFrame implements ActionListener
{
    protected final Color _BackgroundColor = new Color(162, 243, 185);

    protected final ImageIcon _Logo = new ImageIcon("src/com/SplitSmart/Images/logo coloured.jpg");
    protected final ImageIcon _SmallLogo = new ImageIcon(new ImageIcon("src/com/SplitSmart/Images/logo coloured.jpg").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
    protected final ImageIcon _GreyLogo = new ImageIcon("src/com/SplitSmart/Images/logo.jpg");

    private JButton backButton;

    private JPanel headerPanel;
    private JPanel backPanel;
    private JPanel sloganPanel;

    private JLabel sloganLabel;
    private JLabel nameLabel;

    BaseFrame(){
        FrameSettings();
        ConstructLabels();
        ConstructButtons();
        ConstructPanels();
    }

    private void FrameSettings(){
        //setting basic things in the frame
        this.setTitle("SplitSmart App");
        this.setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));
        this.setResizable(true); //do we need this?
        this.setSize(500, 666);
        this.setLayout(null);
        this.setVisible(false);
        this.getContentPane().setBackground(this._BackgroundColor);
        this.setIconImage(_Logo.getImage()); //changes the image on the frame
        //this.setLocationRelativeTo(null);
    }

    private void ConstructLabels(){
        //slogan label creation and settings
        this.sloganLabel = new JLabel(); //you could just add text here
        sloganLabel.setText("Make your friends pay!");
        sloganLabel.setFont(new Font("Consolas", Font.PLAIN, 14));

        //name label creation and settings
        this.nameLabel = new JLabel("SplitSmart"); //, SwingConstants.CENTER
        nameLabel.setText("SplitSmart"); //"<html>First line<br>Second line</html>"
        nameLabel.setIcon(this._SmallLogo);
        nameLabel.setHorizontalTextPosition(JLabel.CENTER);
        nameLabel.setVerticalTextPosition(JLabel.TOP);
        nameLabel.setFont(new Font("MV Boli", Font.BOLD, 20));
        nameLabel.setVerticalAlignment(JLabel.TOP);
        nameLabel.setHorizontalAlignment(JLabel.CENTER);
        nameLabel.setFont(new Font("Consolas", Font.PLAIN, 14));
        //name.setBounds(100, 0, 250, 250);
    }

    private void ConstructPanels(){
        this.backPanel = new JPanel();
        this.add(backPanel);
        backPanel.setBackground(this._BackgroundColor);
        backPanel.setBounds(0, 0, 100, 120);
        backPanel.add(backButton);

        this.headerPanel = new JPanel();
        this.add(headerPanel);
        //header.setLayout(new FlowLayout( FlowLayout.CENTER));
        headerPanel.setBackground(this._BackgroundColor);
        headerPanel.setBounds(100, 0, 300, 120);
        headerPanel.add(nameLabel);

        this.sloganPanel = new JPanel();
        this.add(sloganPanel);
        //sloganPanel.setLayout( new GridLayout( 2 , 1 ) );  // 2 rows 1 column
        sloganPanel.setBackground(this._BackgroundColor);
        sloganPanel.setBounds(0, 120, 500, 50);
        sloganPanel.add(sloganLabel);
    }

    private void ConstructButtons(){
        Border buttonBorder = BorderFactory.createEtchedBorder();

        this.backButton = new JButton();
        backButton.setBounds(30, 60, 100, 50);
        backButton.addActionListener(this);
        backButton.setText("Back");
        backButton.setFocusable(false);
        backButton.setBackground(new Color(58, 167, 92));
        backButton.setBorder(buttonBorder);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()== backButton)
        {
            System.out.println("back");

            this.setVisible(false);
        }
    }
}
