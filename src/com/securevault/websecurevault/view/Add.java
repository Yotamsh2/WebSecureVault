package com.securevault.websecurevault.view;

import javax.swing.*;
import java.awt.event.*;

public class Add {
    private JPanel addpage_panel;
    private JFrame f;
    private JButton add_button;
    private JComboBox<String> category_comboBox;
    private JTextField username_textField;
    private JTextField title_textField;
    private JTextField password_textField3;
    private JTextField acountnumber_textField;
    private JTextField banknumber_textField;
    private JTextField bankaddress_textField;
    private JTextField cardnumber_textField;
    private JTextField cvv_textField;
    private JTextField expiringdate_textField;
    private JTextField email_textField;
    private JTextField website_textField;
    private JTextArea note_textArea;
    private JLabel username_label;
    private JLabel password_label;
    private JLabel acountnumber_label;
    private JLabel banknumber_label;
    private JLabel bankaddress_label;
    private JLabel cardnumber_label;
    private JLabel cvv_label;
    private JLabel expiringdate_label;
    private JLabel website_label;
    private JLabel email_label;
    private JLabel title_label;
    private JLabel note_label;

    MainScreen mainToEnable = new MainScreen();


    public Add() {
        this.category_comboBox.addItem("Credit Cards");
        this.category_comboBox.addItem("Bank Accounts");
        this.category_comboBox.addItem("Social Media");
        this.category_comboBox.addItem("Website and Email");
        this.category_comboBox.addItem("Online Shopping");
        this.category_comboBox.addItem("Notes");

        add_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                mainToEnable.setFrameEnabled();//enabling the main screen
            }
        });

        //changing the displayed components based on combobox option
        category_comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if("Credit Cards".equals((String)category_comboBox.getSelectedItem())) {
                    title_textField.setVisible(true);
                    title_label.setVisible(true);
                    password_textField3.setVisible(true);
                    password_label.setVisible(true);
                    cardnumber_textField.setVisible(true);
                    cardnumber_label.setVisible(true);
                    cvv_textField.setVisible(true);
                    cvv_label.setVisible(true);
                    expiringdate_textField.setVisible(true);
                    expiringdate_label.setVisible(true);
                    note_textArea.setVisible(true);
                    note_label.setVisible(true);
                    username_label.setVisible(false);
                    username_textField.setVisible(false);
                    acountnumber_label.setVisible(false);
                    acountnumber_textField.setVisible(false);
                    banknumber_label.setVisible(false);
                    banknumber_textField.setVisible(false);
                    bankaddress_textField.setVisible(false);
                    bankaddress_label.setVisible(false);
                    email_textField.setVisible(false);
                    email_label.setVisible(false);
                    website_textField.setVisible(false);
                    website_label.setVisible(false);
                    addpage_panel.validate();
                    addpage_panel.repaint();
                    f.revalidate();
                    f.repaint();
                }

                if("Bank Accounts".equals((String)category_comboBox.getSelectedItem())) {
                    title_textField.setVisible(true);
                    title_label.setVisible(true);
                    username_label.setVisible(true);
                    username_textField.setVisible(true);
                    password_textField3.setVisible(true);
                    password_label.setVisible(true);
                    acountnumber_label.setVisible(true);
                    acountnumber_textField.setVisible(true);
                    banknumber_label.setVisible(true);
                    banknumber_textField.setVisible(true);
                    bankaddress_textField.setVisible(true);
                    bankaddress_label.setVisible(true);
                    note_textArea.setVisible(true);
                    note_label.setVisible(true);
                    cardnumber_textField.setVisible(false);
                    cardnumber_label.setVisible(false);
                    cvv_textField.setVisible(false);
                    cvv_label.setVisible(false);
                    expiringdate_textField.setVisible(false);
                    expiringdate_label.setVisible(false);
                    email_textField.setVisible(false);
                    email_label.setVisible(false);
                    website_textField.setVisible(false);
                    website_label.setVisible(false);
                    addpage_panel.validate();
                    addpage_panel.repaint();
                    f.revalidate();
                    f.repaint();
                }

                if("Social Media".equals((String)category_comboBox.getSelectedItem())) {
                    title_textField.setVisible(true);
                    title_label.setVisible(true);
                    username_label.setVisible(true);
                    username_textField.setVisible(true);
                    password_textField3.setVisible(true);
                    password_label.setVisible(true);
                    website_textField.setVisible(true);
                    website_label.setVisible(true);
                    email_textField.setVisible(true);
                    email_label.setVisible(true);
                    note_textArea.setVisible(true);
                    note_label.setVisible(true);
                    acountnumber_label.setVisible(false);
                    acountnumber_textField.setVisible(false);
                    banknumber_label.setVisible(false);
                    banknumber_textField.setVisible(false);
                    bankaddress_textField.setVisible(false);
                    bankaddress_label.setVisible(false);
                    cardnumber_textField.setVisible(false);
                    cardnumber_label.setVisible(false);
                    cvv_textField.setVisible(false);
                    cvv_label.setVisible(false);
                    expiringdate_textField.setVisible(false);
                    expiringdate_label.setVisible(false);
                    addpage_panel.validate();
                    addpage_panel.repaint();
                    f.revalidate();
                    f.repaint();
                }

                if("Website and Email".equals((String)category_comboBox.getSelectedItem())) {
                    title_textField.setVisible(true);
                    title_label.setVisible(true);
                    username_label.setVisible(true);
                    username_textField.setVisible(true);
                    password_textField3.setVisible(true);
                    password_label.setVisible(true);
                    website_textField.setVisible(true);
                    website_label.setVisible(true);
                    email_textField.setVisible(true);
                    email_label.setVisible(true);
                    note_textArea.setVisible(true);
                    note_label.setVisible(true);
                    acountnumber_label.setVisible(false);
                    acountnumber_textField.setVisible(false);
                    banknumber_label.setVisible(false);
                    banknumber_textField.setVisible(false);
                    bankaddress_textField.setVisible(false);
                    bankaddress_label.setVisible(false);
                    cardnumber_textField.setVisible(false);
                    cardnumber_label.setVisible(false);
                    cvv_textField.setVisible(false);
                    cvv_label.setVisible(false);
                    expiringdate_textField.setVisible(false);
                    expiringdate_label.setVisible(false);
                    addpage_panel.validate();
                    addpage_panel.repaint();
                    f.revalidate();
                    f.repaint();
                }

                if("Online Shopping".equals((String)category_comboBox.getSelectedItem())) {
                    title_textField.setVisible(true);
                    title_label.setVisible(true);
                    username_label.setVisible(true);
                    username_textField.setVisible(true);
                    password_textField3.setVisible(true);
                    password_label.setVisible(true);
                    website_textField.setVisible(true);
                    website_label.setVisible(true);
                    email_textField.setVisible(true);
                    email_label.setVisible(true);
                    note_textArea.setVisible(true);
                    note_label.setVisible(true);
                    acountnumber_label.setVisible(false);
                    acountnumber_textField.setVisible(false);
                    banknumber_label.setVisible(false);
                    banknumber_textField.setVisible(false);
                    bankaddress_textField.setVisible(false);
                    bankaddress_label.setVisible(false);
                    cardnumber_textField.setVisible(false);
                    cardnumber_label.setVisible(false);
                    cvv_textField.setVisible(false);
                    cvv_label.setVisible(false);
                    expiringdate_textField.setVisible(false);
                    expiringdate_label.setVisible(false);
                    addpage_panel.validate();
                    addpage_panel.repaint();
                    f.revalidate();
                    f.repaint();
                }

                if("Notes".equals((String)category_comboBox.getSelectedItem())) {
                    title_textField.setVisible(true);
                    title_label.setVisible(true);
                    note_textArea.setVisible(true);
                    note_label.setVisible(true);
                    username_label.setVisible(false);
                    username_textField.setVisible(false);
                    password_textField3.setVisible(false);
                    password_label.setVisible(false);
                    acountnumber_label.setVisible(false);
                    acountnumber_textField.setVisible(false);
                    banknumber_label.setVisible(false);
                    banknumber_textField.setVisible(false);
                    bankaddress_textField.setVisible(false);
                    bankaddress_label.setVisible(false);
                    cardnumber_textField.setVisible(false);
                    cardnumber_label.setVisible(false);
                    cvv_textField.setVisible(false);
                    cvv_label.setVisible(false);
                    expiringdate_textField.setVisible(false);
                    expiringdate_label.setVisible(false);
                    email_textField.setVisible(false);
                    email_label.setVisible(false);
                    website_textField.setVisible(false);
                    website_label.setVisible(false);
                    addpage_panel.validate();
                    addpage_panel.repaint();
                    f.revalidate();
                    f.repaint();
                }
            }
        });
    }

    public void go(MainScreen mainScreen)
    {
        this.mainToEnable = mainScreen;
        f = new JFrame();
        f.setSize(400,450);
        f.setContentPane(addpage_panel);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.addWindowListener(new WindowAdapter() {//enabling the main screen on close of add page
            public void windowClosing(WindowEvent evt) {
                mainToEnable.setFrameEnabled();
            }
        });
        f.setVisible(true);
    }

    public static void main(String[] args) {
        Add test = new Add();
        test.go(null);
    }
}
