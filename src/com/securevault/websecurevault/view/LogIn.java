package com.securevault.websecurevault.view;

import com.securevault.websecurevault.utilities.User;
import com.securevault.websecurevault.viewmodel.ViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**Login page is the page that responsible for the user login screen.*/
public class LogIn {
    private JPanel loginPagePanel;
    private JFrame loginPageFrame;
    private JButton logInButton;
    private JButton singUpButton;
    private JTextField emailTextField;
    private JTextField passwordTextField;

    public LogIn() {
        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainScreen mainScreen = new MainScreen();
                User user = new User();
                ViewModel viewModel = new ViewModel();
                user.setUser_id(emailTextField.getText());
                user.setMaster_pass(passwordTextField.getText());
                user = viewModel.checkCredentials(user);
                if (user.getUser_id() == null) {
                    JOptionPane.showMessageDialog(null,"The User Name or Password entered is incorrect.  Please try again.",
                            "ERROR",JOptionPane.ERROR_MESSAGE,null);
                }
                else {
                    mainScreen.go(user, mainScreen);
                    loginPageFrame.dispose();
                }
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

    /**Login page go method is responsible for displaying the login page.*/
    public void go(){
        loginPageFrame = new JFrame();
        loginPageFrame.setSize(420,250);
        loginPageFrame.setContentPane(loginPagePanel);
        loginPageFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        loginPageFrame.setVisible(true);
    }

}
