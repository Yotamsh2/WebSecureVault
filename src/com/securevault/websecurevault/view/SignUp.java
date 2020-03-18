package com.securevault.websecurevault.view;

import com.securevault.websecurevault.ObjectTypes.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUp {
    private JTextField username_textField;
    private JTextField password_textField;
    private JTextField repeatpass_textField;
    private JButton signUp_Button;
    private JLabel securevault_label;
    private JLabel email_label;
    private JLabel password_label;
    private JLabel repeatpasslabel;
    private JTextField firstname_textField;
    private JTextField lastname_textField;
    private JLabel firstname_label;
    private JLabel lastname_label;
    private JLabel signuppage_label;

    public SignUp() {
        signUp_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainScreen mainScreen = new MainScreen();
                User user = new User();
                // TODO: 18/03/2020 make a method that inserts a new user to the DB and returns the user object/user_id
                mainScreen.go(user);
            }
        });
    }
}
