package com.securevault.websecurevault.view;

import com.securevault.websecurevault.ObjectTypes.User;
import com.securevault.websecurevault.viewmodel.ViewModel;

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
    private JPanel signupPagePanel;
    private JFrame signupPageFrame;

    public SignUp() {
        signUp_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainScreen mainScreen = new MainScreen();
                ViewModel viewModel = new ViewModel();
                User user = new User();
                if(password_textField.getText().equals(repeatpass_textField.getText())) {
                    // TODO: 18/03/2020 make a method that inserts a new user to the DB and returns the user object/user_id
                    //user = viewModel.insertNewUser();
                    mainScreen.go(user);
                } else {
                    JOptionPane.showMessageDialog(null,"Your password and confirmation password do not match.","ERROR",JOptionPane.ERROR_MESSAGE,null);
                }
            }
        });
    }

    public void go(){
        signupPageFrame = new JFrame();
        signupPageFrame.setSize(300,250);
        signupPageFrame.setContentPane(signupPagePanel);
        signupPageFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        signupPageFrame.setVisible(true);
    }
}
