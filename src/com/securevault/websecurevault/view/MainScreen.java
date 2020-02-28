package com.securevault.websecurevault.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreen extends JFrame{
    private JLabel username_label;
    private JLabel logo_label;
    private JTable formView_table;
    private JPanel main_panel,p1,p2,p3,p4,p5;
    private JButton profile_button;
    private JButton add_button;
    private JButton category_button1, category_button2, category_button3;
    private JButton category_button4, category_button5, category_button6;

    private JFrame f = new JFrame();
    static MainScreen mainScreen = new MainScreen();

    public MainScreen() {
        // Initializing components
        main_panel = new JPanel();
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        p5 = new JPanel();

        //data test
        String[][] data = {
                { "Credit Card Laumi", "1234-5678", "123" },
                { "Credit Card Laumi", "1234-5678", "123" },
                { "Credit Card Laumi", "1234-5678", "123" },
                { "Credit Card Laumi", "1234-5678", "123" },
                { "Credit Card Laumi", "1234-5678", "123" },
                { "Credit Card Laumi", "1234-5678", "123" },
                { "Credit Card Laumi", "1234-5678", "123" },
                { "Credit Card Laumi", "1234-5678", "123" },
                { "Credit Card Laumi", "1234-5678", "123" },
                { "Credit Card Laumi", "1234-5678", "123" },
                { "Credit Card Laumi", "1234-5678", "123" },
                { "Credit Card Laumi", "1234-5678", "123" },
                { "Credit Card Laumi", "1234-5678", "123" },
                { "Credit Card Laumi", "1234-5678", "123" },
                { "Credit Card Laumi", "1234-5678", "123" },
                { "Credit Card Laumi", "1234-5678", "123" },
                { "Credit Card Laumi", "1234-5678", "123" },
                { "Credit Card Laumi", "1234-5678", "123" },
                { "Credit Card Laumi", "1234-5678", "123" },
                { "Credit Card Laumi", "1234-5678", "123" },
                { "Credit Card Laumi", "1234-5678", "123" },
                { "Credit Card Laumi", "1234-5678", "123" },
                { "Credit Card Laumi", "1234-5678", "123" },
                { "Credit Card Hapoalim", "1234-5678", "123" }
        };
        String[] columnNames = { "Title", "Card Number", "CVV" };

        //setting the layout and models of the components
        main_panel.setLayout(new BorderLayout());
        p1.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
        p2.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 10));
        p3.setLayout(new GridLayout(3,2));
        p4.setLayout(new BorderLayout());
        p5.setLayout(new GridLayout(1,2));
        formView_table = new JTable(data, columnNames);
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        formView_table.setModel(tableModel);

        //adding components to panels
        p1.add(logo_label);
        p1.add(username_label);
        p2.add(profile_button);
        p2.add(add_button);
        p3.add(category_button1);
        p3.add(category_button2);
        p3.add(category_button3);
        p3.add(category_button4);
        p3.add(category_button5);
        p3.add(category_button6);
        p4.add(new JScrollPane(formView_table),BorderLayout.CENTER);
        p5.add(p1);
        p5.add(p2);
        main_panel.add(p3,BorderLayout.EAST);
        main_panel.add(p4,BorderLayout.CENTER);
        main_panel.add(p5,BorderLayout.NORTH);


        profile_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Here You Will View Your Profile");
            }
        });
        add_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Add add = new Add();
                f.setEnabled(false);
                add.go(mainScreen);
            }
        });
    }

    public void setFrameEnabled() {
        f.setEnabled(true);
    }

    public void go()
    {
        f.setSize(600,400);
        f.setContentPane(main_panel);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        mainScreen.go();
    }
}
