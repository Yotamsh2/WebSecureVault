package com.securevault.websecurevault.view;

import com.securevault.websecurevault.utilities.Category;
import com.securevault.websecurevault.utilities.Record;
import com.securevault.websecurevault.utilities.User;
import com.securevault.websecurevault.model.ExceptionMVVM;
import com.securevault.websecurevault.viewmodel.ViewModel;

import javax.swing.*;
import java.awt.event.*;

/**Add page is the page that responsible for entering a new record to the system.*/
public class Add {
    private JPanel addpagePanel;
    private JFrame addpageFrame = new JFrame();
    private JButton addButton;
    private JButton cancelButton;
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

    //to pass the main screen and user objects to the add/profile pages so it could be enabled back after exiting the page
    //or using the user details
    MainScreen mainToEnable = new MainScreen();
    User activeUser = new User();

    public Add() {
        this.categoryComboBox.addItem(Category.creditCards);
        this.categoryComboBox.addItem(Category.bankAccounts);
        this.categoryComboBox.addItem(Category.socialMedia);
        this.categoryComboBox.addItem(Category.websitesAndEmails);
        this.categoryComboBox.addItem(Category.onlineShopping);
        this.categoryComboBox.addItem(Category.notes);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewModel viewModel = new ViewModel();
                Record recordToAdd = new Record();
                recordToAdd.setUser_id(activeUser.getUser_id());
                recordToAdd.setCategory((String)categoryComboBox.getSelectedItem());
                recordToAdd.setUser_id(activeUser.getUser_id());
                recordToAdd.setRecord_id(null);
                recordToAdd.setTitle(titleTextField.getText());
                recordToAdd.setUser_name(usernameTextField.getText());
                recordToAdd.setPassword(passwordTextField.getText());
                recordToAdd.setBank_address(bankaddressTextField.getText());
                recordToAdd.setExpiring_date(expiringdateTextField.getText());
                recordToAdd.setEmail(emailTextField.getText());
                recordToAdd.setWebsite(websiteTextField.getText());
                recordToAdd.setNote(noteTextArea.getText());
                if (acountnumberTextField.getText().equals("")) {
                    recordToAdd.setAccount_number(0);
                    recordToAdd.setBank_number(0);
                } else {
                    recordToAdd.setAccount_number(Integer.parseInt(acountnumberTextField.getText()));
                    recordToAdd.setBank_number(Integer.parseInt(banknumberTextField.getText()));
                }
                if (cardnumberTextField.getText().equals("")) {
                    recordToAdd.setCard_number(0);
                    recordToAdd.setCvv(0);
                } else {
                    recordToAdd.setCard_number(Integer.parseInt(cardnumberTextField.getText()));
                    recordToAdd.setCvv(Integer.parseInt(cvvTextField.getText()));
                }

                try {
                    viewModel.insertNewRecord(recordToAdd);
                } catch (ExceptionMVVM exceptionMVVM) {
                    exceptionMVVM.printStackTrace();
                }

                addpageFrame.dispose();
                mainToEnable.setFrameEnabled();//enabling the main screen
            }
        });

        //changing the displayed components based on combobox option
        categoryComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(Category.creditCards.equals(categoryComboBox.getSelectedItem())) {
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

                if(Category.bankAccounts.equals(categoryComboBox.getSelectedItem())) {
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

                if(Category.socialMedia.equals(categoryComboBox.getSelectedItem())) {
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

                if(Category.websitesAndEmails.equals(categoryComboBox.getSelectedItem())) {
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

                if(Category.onlineShopping.equals(categoryComboBox.getSelectedItem())) {
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

                if(Category.notes.equals(categoryComboBox.getSelectedItem())) {
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

    /**Add page go method is responsible for displaying the add page.*/
    public void go(MainScreen mainScreen, User user)
    {
        this.mainToEnable = mainScreen;
        this.activeUser = user;
        addpageFrame.setSize(450,450);
        addpageFrame.setContentPane(addpagePanel);
        addpageFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addpageFrame.addWindowListener(new WindowAdapter() {//enabling the main screen when closing add page
            public void windowClosing(WindowEvent evt) {
                mainToEnable.setFrameEnabled();
            }
        });
        addpageFrame.setVisible(true);
    }
}