package com.securevault.websecurevault.view;

import javax.swing.*;
import java.awt.event.*;

public class Add {
    private JPanel addpagePanel;
    private JFrame addpageFrame;
    private JButton addButton;
    private JComboBox<String> categoryComboBox;
    private JTextField usernameTextField;
    private JTextField titleTextField;
    private JTextField passwordTextField;
    private JTextField acountnumberTextField;
    private JTextField banknumberTextField;
    private JTextField bankaddressTextField;
    private JTextField cardnumberTextField;
    private JTextField cvvTextField;
    private JTextField expiringdateTextField;
    private JTextField emailTextField;
    private JTextField websiteTextField;
    private JTextArea noteTextArea;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel acountnumberLabel;
    private JLabel banknumberLabel;
    private JLabel bankaddressLabel;
    private JLabel cardnumberLabel;
    private JLabel cvvLabel;
    private JLabel expiringdateLabel;
    private JLabel websiteLabel;
    private JLabel emailLabel;
    private JLabel titleLabel;
    private JLabel noteLabel;
    private JButton cancelButton;

    //to pass the main screen object to add/profile pages so it could be enabled back after exiting the page
    MainScreen mainToEnable = new MainScreen();


    public Add() {
        this.categoryComboBox.addItem("Credit Cards");
        this.categoryComboBox.addItem("Bank Accounts");
        this.categoryComboBox.addItem("Social Media");
        this.categoryComboBox.addItem("Website and Email");
        this.categoryComboBox.addItem("Online Shopping");
        this.categoryComboBox.addItem("Notes");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addpageFrame.dispose();
                mainToEnable.setFrameEnabled();//enabling the main screen
            }
        });

        //changing the displayed components based on combobox option
        categoryComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if("Credit Cards".equals((String) categoryComboBox.getSelectedItem())) {
                    titleTextField.setVisible(true);
                    titleLabel.setVisible(true);
                    cardnumberTextField.setVisible(true);
                    cardnumberLabel.setVisible(true);
                    passwordTextField.setVisible(true);
                    passwordLabel.setVisible(true);
                    cvvTextField.setVisible(true);
                    cvvLabel.setVisible(true);
                    expiringdateTextField.setVisible(true);
                    expiringdateLabel.setVisible(true);
                    noteTextArea.setVisible(true);
                    noteLabel.setVisible(true);
                    usernameLabel.setVisible(false);
                    usernameTextField.setVisible(false);
                    acountnumberLabel.setVisible(false);
                    acountnumberTextField.setVisible(false);
                    banknumberLabel.setVisible(false);
                    banknumberTextField.setVisible(false);
                    bankaddressTextField.setVisible(false);
                    bankaddressLabel.setVisible(false);
                    emailTextField.setVisible(false);
                    emailLabel.setVisible(false);
                    websiteTextField.setVisible(false);
                    websiteLabel.setVisible(false);
                    addpagePanel.validate();
                    addpagePanel.repaint();
                    addpageFrame.revalidate();
                    addpageFrame.repaint();
                }

                if("Bank Accounts".equals((String) categoryComboBox.getSelectedItem())) {
                    titleTextField.setVisible(true);
                    titleLabel.setVisible(true);
                    usernameLabel.setVisible(true);
                    usernameTextField.setVisible(true);
                    passwordTextField.setVisible(true);
                    passwordLabel.setVisible(true);
                    acountnumberLabel.setVisible(true);
                    acountnumberTextField.setVisible(true);
                    banknumberLabel.setVisible(true);
                    banknumberTextField.setVisible(true);
                    bankaddressTextField.setVisible(true);
                    bankaddressLabel.setVisible(true);
                    noteTextArea.setVisible(true);
                    noteLabel.setVisible(true);
                    cardnumberTextField.setVisible(false);
                    cardnumberLabel.setVisible(false);
                    cvvTextField.setVisible(false);
                    cvvLabel.setVisible(false);
                    expiringdateTextField.setVisible(false);
                    expiringdateLabel.setVisible(false);
                    emailTextField.setVisible(false);
                    emailLabel.setVisible(false);
                    websiteTextField.setVisible(false);
                    websiteLabel.setVisible(false);
                    addpagePanel.validate();
                    addpagePanel.repaint();
                    addpageFrame.revalidate();
                    addpageFrame.repaint();
                }

                if("Social Media".equals((String) categoryComboBox.getSelectedItem())) {
                    titleTextField.setVisible(true);
                    titleLabel.setVisible(true);
                    usernameLabel.setVisible(true);
                    usernameTextField.setVisible(true);
                    passwordTextField.setVisible(true);
                    passwordLabel.setVisible(true);
                    websiteTextField.setVisible(true);
                    websiteLabel.setVisible(true);
                    emailTextField.setVisible(true);
                    emailLabel.setVisible(true);
                    noteTextArea.setVisible(true);
                    noteLabel.setVisible(true);
                    acountnumberLabel.setVisible(false);
                    acountnumberTextField.setVisible(false);
                    banknumberLabel.setVisible(false);
                    banknumberTextField.setVisible(false);
                    bankaddressTextField.setVisible(false);
                    bankaddressLabel.setVisible(false);
                    cardnumberTextField.setVisible(false);
                    cardnumberLabel.setVisible(false);
                    cvvTextField.setVisible(false);
                    cvvLabel.setVisible(false);
                    expiringdateTextField.setVisible(false);
                    expiringdateLabel.setVisible(false);
                    addpagePanel.validate();
                    addpagePanel.repaint();
                    addpageFrame.revalidate();
                    addpageFrame.repaint();
                }

                if("Website and Email".equals((String) categoryComboBox.getSelectedItem())) {
                    titleTextField.setVisible(true);
                    titleLabel.setVisible(true);
                    usernameLabel.setVisible(true);
                    usernameTextField.setVisible(true);
                    passwordTextField.setVisible(true);
                    passwordLabel.setVisible(true);
                    websiteTextField.setVisible(true);
                    websiteLabel.setVisible(true);
                    emailTextField.setVisible(true);
                    emailLabel.setVisible(true);
                    noteTextArea.setVisible(true);
                    noteLabel.setVisible(true);
                    acountnumberLabel.setVisible(false);
                    acountnumberTextField.setVisible(false);
                    banknumberLabel.setVisible(false);
                    banknumberTextField.setVisible(false);
                    bankaddressTextField.setVisible(false);
                    bankaddressLabel.setVisible(false);
                    cardnumberTextField.setVisible(false);
                    cardnumberLabel.setVisible(false);
                    cvvTextField.setVisible(false);
                    cvvLabel.setVisible(false);
                    expiringdateTextField.setVisible(false);
                    expiringdateLabel.setVisible(false);
                    addpagePanel.validate();
                    addpagePanel.repaint();
                    addpageFrame.revalidate();
                    addpageFrame.repaint();
                }

                if("Online Shopping".equals((String) categoryComboBox.getSelectedItem())) {
                    titleTextField.setVisible(true);
                    titleLabel.setVisible(true);
                    usernameLabel.setVisible(true);
                    usernameTextField.setVisible(true);
                    passwordTextField.setVisible(true);
                    passwordLabel.setVisible(true);
                    websiteTextField.setVisible(true);
                    websiteLabel.setVisible(true);
                    emailTextField.setVisible(true);
                    emailLabel.setVisible(true);
                    noteTextArea.setVisible(true);
                    noteLabel.setVisible(true);
                    acountnumberLabel.setVisible(false);
                    acountnumberTextField.setVisible(false);
                    banknumberLabel.setVisible(false);
                    banknumberTextField.setVisible(false);
                    bankaddressTextField.setVisible(false);
                    bankaddressLabel.setVisible(false);
                    cardnumberTextField.setVisible(false);
                    cardnumberLabel.setVisible(false);
                    cvvTextField.setVisible(false);
                    cvvLabel.setVisible(false);
                    expiringdateTextField.setVisible(false);
                    expiringdateLabel.setVisible(false);
                    addpagePanel.validate();
                    addpagePanel.repaint();
                    addpageFrame.revalidate();
                    addpageFrame.repaint();
                }

                if("Notes".equals((String) categoryComboBox.getSelectedItem())) {
                    titleTextField.setVisible(true);
                    titleLabel.setVisible(true);
                    noteTextArea.setVisible(true);
                    noteLabel.setVisible(true);
                    usernameLabel.setVisible(false);
                    usernameTextField.setVisible(false);
                    passwordTextField.setVisible(false);
                    passwordLabel.setVisible(false);
                    acountnumberLabel.setVisible(false);
                    acountnumberTextField.setVisible(false);
                    banknumberLabel.setVisible(false);
                    banknumberTextField.setVisible(false);
                    bankaddressTextField.setVisible(false);
                    bankaddressLabel.setVisible(false);
                    cardnumberTextField.setVisible(false);
                    cardnumberLabel.setVisible(false);
                    cvvTextField.setVisible(false);
                    cvvLabel.setVisible(false);
                    expiringdateTextField.setVisible(false);
                    expiringdateLabel.setVisible(false);
                    emailTextField.setVisible(false);
                    emailLabel.setVisible(false);
                    websiteTextField.setVisible(false);
                    websiteLabel.setVisible(false);
                    addpagePanel.validate();
                    addpagePanel.repaint();
                    addpageFrame.revalidate();
                    addpageFrame.repaint();
                }
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addpageFrame.dispose();
                mainToEnable.setFrameEnabled();//enabling the main screen
            }
        });
    }

    public void go(MainScreen mainScreen)
    {
        this.mainToEnable = mainScreen;
        addpageFrame = new JFrame();
        addpageFrame.setSize(400,450);
        addpageFrame.setContentPane(addpagePanel);
        addpageFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addpageFrame.addWindowListener(new WindowAdapter() {//enabling the main screen on close of add page
            public void windowClosing(WindowEvent evt) {
                mainToEnable.setFrameEnabled();
            }
        });
        addpageFrame.setVisible(true);
    }

    public static void main(String[] args) {
        Add test = new Add();
        test.go(null);
    }
}
