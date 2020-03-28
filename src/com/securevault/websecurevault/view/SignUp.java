package com.securevault.websecurevault.view;

import com.securevault.websecurevault.utilities.User;
import com.securevault.websecurevault.viewmodel.ViewModel;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    }

    public void go(){
        signupPageFrame.setSize(300,250);
        signupPageFrame.setContentPane(signupPagePanel);
        signupPageFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        signupPageFrame.setVisible(true);
    }
}