package com.securevault.websecurevault.view;

import com.securevault.websecurevault.Utilities.User;
import com.securevault.websecurevault.viewmodel.ViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Profile {
    private JFrame profilepageFrame;
    private JPanel profilepagePanel;
    private JButton saveButton;
    private JButton returnButton;
    private JTextField firstnameTextField;
    private JTextField emailTextField;
    private JTextField currentpasswordTextField;
    private JTextField newpasswordTextField;
    private JTextField repeatpasswordTextField;
    private JTextField lastnameTextField;
    private JLabel securevaultLabel;
    private JLabel firstnameLabel;
    private JLabel emailLabel;
    private JLabel currentpasswordLabel;
    private JLabel newpasswordLabel;
    private JLabel repeatpasswordLabel;
    private JLabel lastnameLabel;

    MainScreen mainToEnable = new MainScreen();
    User activeUser = new User();

    public Profile() {
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                profilepageFrame.dispose();
                mainToEnable.setFrameEnabled();//enabling the main screen
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User userToUpdate = activeUser;
                ViewModel viewModel = new ViewModel();
                if (!emailTextField.getText().equals(""))
                    userToUpdate.setUser_id(emailTextField.getText());
                if (!firstnameTextField.getText().equals(""))
                    userToUpdate.setFirst_name(firstnameTextField.getText());
                if (!lastnameTextField.getText().equals(""))
                    userToUpdate.setLast_name(lastnameTextField.getText());
                if (!currentpasswordTextField.getText().equals("")){
                    if (currentpasswordTextField.getText().equals(activeUser.getMaster_pass())) {
                        if (newpasswordTextField.getText().equals(repeatpasswordTextField.getText()))
                            userToUpdate.setMaster_pass(newpasswordTextField.getText());
                        else { JOptionPane.showMessageDialog(null,"Password and confirmation password do not match.",
                                    "ERROR",JOptionPane.ERROR_MESSAGE,null); }
                    }
                    else { JOptionPane.showMessageDialog(null,"Current password is incorrect.",
                                "ERROR",JOptionPane.ERROR_MESSAGE,null); }
                }
                if (viewModel.updateUser(userToUpdate)) {
                    activeUser = userToUpdate;
                    JOptionPane.showMessageDialog(null,"Updated user information successfully.",
                            "Success",JOptionPane.PLAIN_MESSAGE,null);
                }
                else JOptionPane.showMessageDialog(null,"Update fail.",
                        "ERROR",JOptionPane.ERROR_MESSAGE,null);

            }
        });
    }

    public void go(MainScreen mainScreen, User user)
    {
        activeUser = user;
        System.out.println("email: "+activeUser.getUser_id()+"first name: "+activeUser.getFirst_name()+"last name: "+activeUser.getLast_name()+"pass: "+activeUser.getMaster_pass());
        mainToEnable = mainScreen;
        profilepageFrame = new JFrame();
        profilepageFrame.setSize(400,450);
        profilepageFrame.setContentPane(profilepagePanel);
        profilepageFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        profilepageFrame.addWindowListener(new WindowAdapter() {//enabling the main screen on close of add page
            public void windowClosing(WindowEvent evt) {
                mainToEnable.setFrameEnabled();
            }
        });
        emailTextField.setText(activeUser.getUser_id());
        firstnameTextField.setText(activeUser.getFirst_name());
        lastnameTextField.setText(activeUser.getLast_name());
        profilepageFrame.setVisible(true);
    }
}
