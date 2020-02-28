package com.securevault.websecurevault.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class test {
    private JFrame frame;

    BufferedImage img;
    private JPanel panel_main;
    private JButton button_msg3;
    private JButton button_msg1;
    private JButton button_msg2;
    private JPanel panel_1;
    private JTable table1;

    public test() {
        panel_1 = new JPanel();
        panel_1.setLayout(new BorderLayout());
        String[][] data = {
                { "Credit Card Laumi", "1234-5678", "123" },
                { "Credit Card Hapoalim", "1234-5678", "123" }
        };
        String[] columnNames = { "Title", "Card Number", "CVV" };
        //this.table1.add;
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        table1.setModel(tableModel);
        panel_1.add(table1,BorderLayout.CENTER);
        frame = new JFrame();
        panel_main.add(panel_1);
        /*try {
            img = ImageIO.read(new File("C:/Users/yuval/Desktop/Background.jpg"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }*/

        button_msg1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Button 1 is Working! \n Good Job :)");
            }
        });
        button_msg2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Button 2 is Working! \n Good Job :)");
            }
        });
        button_msg3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Button 3 is Working! \n Good Job :)");
            }
        });
    }
/*
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }*/
public void go()
{
    frame.setSize(500,400);
    frame.setContentPane(panel_main);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
}

    public static void main(String[] args) {
        test test1 = new test();
        test1.go();
    }
    
}
/*class JPanelEx1 extends JFrame
{
    test pe;

    public static void main(String args[])
    {
        new JPanelEx1();
        /*JFrame frame = new JFrame("test");
        frame.setContentPane(new test().panel_main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }*/

    /*JPanelEx1()
    {
        pe = new test();

        add(pe);
        setTitle("JPanel Title");
        setContentPane(new test().panel_main);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setSize(320,240);
        setVisible(true);
    }*/
