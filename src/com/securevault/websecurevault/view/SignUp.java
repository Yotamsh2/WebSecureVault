package com.securevault.websecurevault.view;

import com.securevault.websecurevault.utilities.User;
import com.securevault.websecurevault.viewmodel.ViewModel;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SignUp {
    private JPanel signupPagePanel;
    private JFrame signupPageFrame = new JFrame();
    private JButton signupButton;
    private JTextField emailTextField;
    private JTextField passwordTextField;
    private JTextField repeatpassTextField;
    private JTextField firstnameTextField;
    private JTextField lastnameTextField;
    private JLabel securevaultLabel;
    private JLabel emailLabel;
    private JLabel passwordLabel;
    private JLabel repeatpasslabel;
    private JLabel firstnameLabel;
    private JLabel lastnameLabel;
    private JLabel signuppageLabel;
    private JButton cancelButton;


    public SignUp() {
        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainScreen mainScreen = new MainScreen();
                ViewModel viewModel = new ViewModel();

                if(passwordTextField.getText().equals(repeatpassTextField.getText())) {
                    User user = new User(emailTextField.getText(), firstnameTextField.getText(), lastnameTextField.getText(), passwordTextField.getText());
                    viewModel.insertNewUser(user);
                    mainScreen.go(user, mainScreen);
                    signupPageFrame.dispose();
                } else {
                    JOptionPane.showMessageDialog(null,"Password and confirmation password do not match.","ERROR",JOptionPane.ERROR_MESSAGE,null);
                }
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LogIn logIn = new LogIn();
                logIn.go();
                signupPageFrame.dispose();
            }
        });
    }

    public void go(){
        signupPageFrame.setSize(300,250);
        signupPageFrame.setContentPane(signupPagePanel);
        signupPageFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        signupPageFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                LogIn logIn = new LogIn();
                logIn.go();
                signupPageFrame.dispose();
            }
        });
        signupPageFrame.setVisible(true);
    }
}