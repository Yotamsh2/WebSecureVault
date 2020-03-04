package com.securevault.websecurevault.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Profile {
    private JLabel securevaultLabel;
    private JTextField usernameTextField;
    private JTextField emailTextField;
    private JTextField newpasswordTextField;
    private JTextField repeatpasswordTextField;
    private JButton saveButton;
    private JButton returnButton;
    private JLabel usernameLabel;
    private JLabel emailLabel;
    private JPanel profilepagePanel;
    private JTextField currentpasswordTextField;
    private JLabel currentpasswordLabel;
    private JLabel newpasswordLabel;
    private JLabel repeatpasswordLabel;
    private JFrame profilepageFrame;

    MainScreen mainToEnable = new MainScreen();


    public Profile() {
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                profilepageFrame.dispose();
                mainToEnable.setFrameEnabled();//enabling the main screen
            }
        });
    }

    public void go(MainScreen mainScreen)
    {
        this.mainToEnable = mainScreen;
        profilepageFrame = new JFrame();
        profilepageFrame.setSize(400,450);
        profilepageFrame.setContentPane(profilepagePanel);
        profilepageFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        profilepageFrame.addWindowListener(new WindowAdapter() {//enabling the main screen on close of add page
            public void windowClosing(WindowEvent evt) {
                mainToEnable.setFrameEnabled();
            }
        });
        profilepageFrame.setVisible(true);
    }
}
