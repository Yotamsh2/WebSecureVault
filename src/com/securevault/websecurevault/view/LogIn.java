package com.securevault.websecurevault.view;

import com.securevault.websecurevault.ObjectTypes.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogIn {
    private JPanel loginPagePanel;
    private JFrame loginPageFrame;
    private JButton logInButton;
    private JButton singUpButton;
    private JTextField emailTextField;
    private JTextField passwordTextField;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel securevaultLabel;
    private JLabel loginpageLabel;


    MainScreen mainScreen = new MainScreen();
    User user = new User();
    public LogIn() {
        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: 18/03/2020 method that checks user credentials and returns the user object/user_id
                mainScreen.go(user);
                loginPageFrame.dispose();
            }
        });

        singUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SignUp signUp = new SignUp();
                signUp.go();
                loginPageFrame.dispose();
            }
        });
    }

    public void go(){
        loginPageFrame = new JFrame();
        loginPageFrame.setSize(300,250);
        loginPageFrame.setContentPane(loginPagePanel);
        loginPageFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        loginPageFrame.setVisible(true);
    }
}
