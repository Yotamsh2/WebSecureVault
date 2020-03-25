package com.securevault.websecurevault.view;

import com.securevault.websecurevault.Utilities.Category;
import com.securevault.websecurevault.Utilities.Record;
import com.securevault.websecurevault.Utilities.User;
import com.securevault.websecurevault.model.ExceptionMVVM;
import com.securevault.websecurevault.viewmodel.ViewModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

//TODO: make variables camelCase and not snake_case
//TODO: meaningful variable names
//TODO: make panels final with initalization
public class MainScreen extends JFrame{
    private JFrame mainFrame = new JFrame();
    private JLabel usernameLabel = new JLabel();
    private JLabel logoLabel;
    private JLabel tableLabel = new JLabel(Category.creditCards);
    private JPanel mainPanel;
    private JPanel flowLeftPanel = new JPanel();
    private JPanel flowRightPanel = new JPanel();
    private JPanel categoryButtonPanel;
    private JPanel tablePanel;
    private JPanel topBarPanel;
    private JButton profileButton;
    private JButton addButton;
    private JButton deleteButton = new JButton("Delete");
    private JButton categoryButton1 = new JButton(Category.creditCards);
    private JButton categoryButton2 = new JButton(Category.bankAccounts);
    private JButton categoryButton3 = new JButton(Category.socialMedia);
    private JButton categoryButton4 = new JButton(Category.websitesAndEmails);
    private JButton categoryButton5 = new JButton(Category.onlineShopping);
    private JButton categoryButton6 = new JButton(Category.notes);

    static MainScreen mainScreen = new MainScreen();
    private ViewModel viewModel = new ViewModel();//MVVM connection variable
    private User activeUser = new User(); //the user that logged in to the system
    private Vector<Record> records;
    private int selectedRecordIndex;
    private Vector<String> columnNamesToRefresh = new Vector<>();

    private JTable formViewTable = new JTable();
    DefaultTableModel tableModel = new DefaultTableModel();

    public MainScreen() {

        // Initializing components
        mainPanel = new JPanel();
        categoryButtonPanel = new JPanel();
        tablePanel = new JPanel();
        topBarPanel = new JPanel();
        this.selectedRecordIndex = 0;

        //setting the layout and settings of the components
        mainPanel.setBorder(new EmptyBorder(5,5,5,5));
        mainPanel.setLayout(new BorderLayout());
        flowLeftPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
        flowRightPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 10));
        categoryButtonPanel.setLayout(new GridLayout(3,2));
        tablePanel.setLayout(new BorderLayout());
        topBarPanel.setLayout(new GridLayout(1,2));
        formViewTable.getTableHeader().setReorderingAllowed(false);
        tableLabel.setHorizontalAlignment(0);
        Dimension d = new Dimension(90,25);
        profileButton.setMinimumSize(d);
        profileButton.setPreferredSize(d);
        profileButton.setMaximumSize(d);
        addButton.setMinimumSize(d);
        addButton.setPreferredSize(d);
        addButton.setMaximumSize(d);
        deleteButton.setMinimumSize(d);
        deleteButton.setPreferredSize(d);
        deleteButton.setMaximumSize(d);

        //adding components to panels
        flowLeftPanel.add(logoLabel);
        flowLeftPanel.add(usernameLabel);
        flowRightPanel.add(deleteButton);
        flowRightPanel.add(profileButton);
        flowRightPanel.add(addButton);
        categoryButtonPanel.add(categoryButton1);
        categoryButtonPanel.add(categoryButton2);
        categoryButtonPanel.add(categoryButton3);
        categoryButtonPanel.add(categoryButton4);
        categoryButtonPanel.add(categoryButton5);
        categoryButtonPanel.add(categoryButton6);
        tablePanel.add(tableLabel,BorderLayout.NORTH);
        tablePanel.add(new JScrollPane(formViewTable),BorderLayout.CENTER);
        topBarPanel.add(flowLeftPanel);
        topBarPanel.add(flowRightPanel);
        mainPanel.add(categoryButtonPanel,BorderLayout.EAST);
        mainPanel.add(tablePanel,BorderLayout.CENTER);
        mainPanel.add(topBarPanel,BorderLayout.NORTH);

        //Listeners
        profileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Profile profile = new Profile();
                mainFrame.setEnabled(false);
                profile.go(mainScreen, activeUser);
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Add add = new Add();
                mainFrame.setEnabled(false);
                add.go(mainScreen, activeUser);
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (formViewTable.getSelectedRow() != -1) {
                    try {
                        selectedRecordIndex = records.get(formViewTable.getSelectedRow()).getRecord_id();
                        viewModel.deleteRecord(selectedRecordIndex);
                    } catch (ExceptionMVVM exceptionMVVM) {
                        exceptionMVVM.printStackTrace();
                    }
                    //refreshing the table
                    records.remove(formViewTable.getSelectedRow());
                    records.forEach(record -> System.out.println(record.toString()));
                    Vector<Vector<String>> rowsToRefresh = new Vector<>();
                    records.forEach(record -> rowsToRefresh.add(record.asVector(record.getCategory())));
                    tableModel.setDataVector(rowsToRefresh, columnNamesToRefresh);
                    formViewTable.setModel(tableModel);
                } else {
                    JOptionPane.showMessageDialog(null,"Please select a record to delete.",
                            "ERROR",JOptionPane.ERROR_MESSAGE,null);
                }
            }
        });
        categoryButton1.addActionListener(new ActionListener() {//Credit Card
            @Override
            public void actionPerformed(ActionEvent e) {
                tableLabel.setText(Category.creditCards);
                Vector<String> columnNames = new Vector<>();
                columnNames.add("Title");
                columnNames.add("Card Number");
                columnNames.add("Password");
                columnNames.add("CVV");
                columnNames.add("Expiring Date");
                columnNames.add("Note");
                columnNamesToRefresh = columnNames;

                records = viewModel.getRecordsByCategory(Category.creditCards, activeUser);
                Vector<Vector<String>> rows = new Vector<>();
                records.forEach(record -> rows.add(record.asVector(Category.creditCards)));
                tableModel.setDataVector(rows, columnNames);
                formViewTable.setModel(tableModel);
            }
        });
        categoryButton2.addActionListener(new ActionListener() {//Bank Account
            @Override
            public void actionPerformed(ActionEvent e) {
                tableLabel.setText(Category.bankAccounts);
                Vector<String> columnNames = new Vector<>();
                columnNames.add("Title");
                columnNames.add("User Name");
                columnNames.add("Password");
                columnNames.add("Account Number");
                columnNames.add("Bank Number");
                columnNames.add("Bank Address");
                columnNames.add("Note");

                records = viewModel.getRecordsByCategory(Category.bankAccounts, activeUser);
                Vector<Vector<String>> rows = new Vector<>();
                records.forEach(record -> rows.add(record.asVector(Category.bankAccounts)));
                tableModel.setDataVector(rows, columnNames);
                formViewTable.setModel(tableModel);
            }
        });
        categoryButton3.addActionListener(new ActionListener() {//Social Media
            @Override
            public void actionPerformed(ActionEvent e) {
                tableLabel.setText(Category.socialMedia);
                Vector<String> columnNames = new Vector<>();
                columnNames.add("Title");
                columnNames.add("User Name");
                columnNames.add("Password");
                columnNames.add("Website");
                columnNames.add("Email");
                columnNames.add("Note");

                records = viewModel.getRecordsByCategory(Category.socialMedia, activeUser);
                Vector<Vector<String>> rows = new Vector<>();
                records.forEach(record -> rows.add(record.asVector(Category.socialMedia)));
                tableModel.setDataVector(rows, columnNames);
                formViewTable.setModel(tableModel);
            }
        });
        categoryButton4.addActionListener(new ActionListener() {//Website and Email
            @Override
            public void actionPerformed(ActionEvent e) {
                tableLabel.setText(Category.websitesAndEmails);
                Vector<String> columnNames = new Vector<>();
                columnNames.add("Title");
                columnNames.add("User Name");
                columnNames.add("Password");
                columnNames.add("Website");
                columnNames.add("Email");
                columnNames.add("Note");

                records = viewModel.getRecordsByCategory(Category.websitesAndEmails, activeUser);
                Vector<Vector<String>> rows = new Vector<>();
                records.forEach(record -> rows.add(record.asVector(Category.websitesAndEmails)));
                tableModel.setDataVector(rows, columnNames);
                formViewTable.setModel(tableModel);
            }
        });
        categoryButton5.addActionListener(new ActionListener() {//Online Shopping
            @Override
            public void actionPerformed(ActionEvent e) {
                tableLabel.setText(Category.onlineShopping);
                Vector<String> columnNames = new Vector<>();
                columnNames.add("Title");
                columnNames.add("User Name");
                columnNames.add("Password");
                columnNames.add("Website");
                columnNames.add("Email");
                columnNames.add("Note");

                records = viewModel.getRecordsByCategory(Category.onlineShopping, activeUser);
                Vector<Vector<String>> rows = new Vector<>();
                records.forEach(record -> rows.add(record.asVector(Category.onlineShopping)));
                tableModel.setDataVector(rows, columnNames);
                formViewTable.setModel(tableModel);
            }
        });
        categoryButton6.addActionListener(new ActionListener() {//Note
            @Override
            public void actionPerformed(ActionEvent e) {
                tableLabel.setText(Category.notes);
                Vector<String> columnNames = new Vector<>();
                columnNames.add("Title");
                columnNames.add("Note");
                columnNamesToRefresh = columnNames;

                records = viewModel.getRecordsByCategory(Category.notes, activeUser);
                Vector<Vector<String>> rows = new Vector<>();
                records.forEach(record -> rows.add(record.asVector(Category.notes)));
                tableModel.setDataVector(rows, columnNames);
                formViewTable.setModel(tableModel);
            }
        });
    }

    /**making mainPanel enabled again after being disabled.*/
    public void setFrameEnabled() {
        mainFrame.setEnabled(true);
        mainFrame.setVisible(true);
    }

    /**
     * The main go function will be called after user has logged in or singed up to the system.
     * this function is running the main screen and making it visible.
     */
    public void go(User user, MainScreen mainscreen) {
        mainScreen = mainscreen;
        activeUser = user;
        mainFrame.setSize(1000,500);
        mainFrame.setContentPane(mainPanel);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);

        //Initializing table for first run
        tableLabel.setText(Category.creditCards);
        Vector<String> columnNames = new Vector<>();
        columnNames.add("Title");
        columnNames.add("Card Number");
        columnNames.add("Password");
        columnNames.add("CVV");
        columnNames.add("Expiring Date");
        columnNames.add("Note");
        records = viewModel.getRecordsByCategory(Category.creditCards, activeUser);
        Vector<Vector<String>> rows = new Vector<>();
        records.forEach(record -> rows.add(record.asVector(Category.creditCards)));
        tableModel.setDataVector(rows, columnNames);
        formViewTable.setModel(tableModel);
    }
}
