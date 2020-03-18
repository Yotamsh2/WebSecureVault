package com.securevault.websecurevault.view;

import com.securevault.websecurevault.ObjectTypes.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogIn {
    private JButton logInButton;
    private JButton singUpButton;
    private JTextField username_textField;
    private JTextField password_textField;
    private JLabel username_label;
    private JLabel password_label;
    private JLabel securevault_label;
    private JLabel loginpage_label;

    MainScreen mainScreen = new MainScreen();
    User user = new User();
    public LogIn() {
        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: 18/03/2020 method that checks user credentials and returns the user object/user_id
                mainScreen.go(user);
            }
        });


        singUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: 18/03/2020 create sign up page starter method
            }
        });
    }

    public void go(){
        // TODO: 18/03/2020 make a method to start the login page.
        //  this page will be the firt page to run when opening the app.
    }
}
