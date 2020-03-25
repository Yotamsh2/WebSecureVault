package com.securevault.websecurevault.view;

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
    private final JPanel flowLeftPanel = new JPanel();
    private  JLabel usernameLabel = new JLabel();
    private JLabel logoLabel;
    private JLabel tableLabel = new JLabel("Credit Card");
    private JTable formViewTable;
    private JPanel mainPanel;
    private final JPanel flowRightPanel = new JPanel();
    private JPanel categoryButtonPanel;
    private JPanel tablePanel;
    private JPanel topBarPanel;
    private JButton profileButton;
    private JButton addButton;
    private JButton deleteButton = new JButton("Delete");
    private JButton categoryButton1 = new JButton("Credit Card");
    private JButton categoryButton2 = new JButton("Bank Account");
    private JButton categoryButton3 = new JButton("Social Media");
    private JButton categoryButton4 = new JButton("Website and Email");
    private JButton categoryButton5 = new JButton("Online Shopping");
    private JButton categoryButton6 = new JButton("Note");
    private JFrame mainFrame = new JFrame();

    static MainScreen mainScreen = new MainScreen();
    User activeUser = new User();
    private Vector<Record> records;
    private int selectedRecordIndex;
    private Vector<String> columnNamesToRefresh = new Vector<>();

    public MainScreen() {
        ViewModel viewModel = new ViewModel();//MVVM connection variable

        // Initializing components
        mainPanel = new JPanel();
        categoryButtonPanel = new JPanel();
        tablePanel = new JPanel();
        topBarPanel = new JPanel();
        this.selectedRecordIndex = 0;

        //data test
        String[][] data = {
                { "Credit Card Laumi", "1234-5678", "1234", "123", "1.1.2020", "note..." },
                { "Credit Card Laumi", "1234-5678", "1234", "123", "1.1.2020", "note..." },
                { "Credit Card Laumi", "1234-5678", "1234", "123", "1.1.2020", "note..." },
                { "Credit Card Laumi", "1234-5678", "1234", "123", "1.1.2020", "note..." },
                { "Credit Card Laumi", "1234-5678", "1234", "123", "1.1.2020", "note..." },
                { "Credit Card Laumi", "1234-5678", "1234", "123", "1.1.2020", "note..." },
                { "Credit Card Laumi", "1234-5678", "1234", "123", "1.1.2020", "note..." },
                { "Credit Card Laumi", "1234-5678", "1234", "123", "1.1.2020", "note..." },
                { "Credit Card Laumi", "1234-5678", "1234", "123", "1.1.2020", "note..." },
                { "Credit Card Laumi", "1234-5678", "1234", "123", "1.1.2020", "note..." },
                { "Credit Card Laumi", "1234-5678", "1234", "123", "1.1.2020", "note..." },
                { "Credit Card Laumi", "1234-5678", "1234", "123", "1.1.2020", "note..." },
                { "Credit Card Laumi", "1234-5678", "1234", "123", "1.1.2020", "note..." },
                { "Credit Card Laumi", "1234-5678", "1234", "123", "1.1.2020", "note..." },
                { "Credit Card Laumi", "1234-5678", "1234", "123", "1.1.2020", "note..." },
                { "Credit Card Laumi", "1234-5678", "1234", "123", "1.1.2020", "note..." },
                { "Credit Card Laumi", "1234-5678", "1234", "123", "1.1.2020", "note..." },
                { "Credit Card Laumi", "1234-5678", "1234", "123", "1.1.2020", "note..." },
                { "Credit Card Laumi", "1234-5678", "1234", "123", "1.1.2020", "note..." },
                { "Credit Card Laumi", "1234-5678", "1234", "123", "1.1.2020", "note..." },
                { "Credit Card Laumi", "1234-5678", "1234", "123", "1.1.2020", "note..." },
                { "Credit Card Laumi", "1234-5678", "1234", "123", "1.1.2020", "note..." },
                { "Credit Card Laumi", "1234-5678", "1234", "123", "1.1.2020", "note..." },
                { "Credit Card Laumi", "1234-5678", "1234", "123", "1.1.2020", "note..." },
                { "Credit Card Laumi", "1234-5678", "1234", "123", "1.1.2020", "note..." },
                { "Credit Card Laumi", "1234-5678", "1234", "123", "1.1.2020", "note..." },
                { "Credit Card Laumi", "1234-5678", "1234", "123", "1.1.2020", "note..." },
                { "Credit Card Laumi", "1234-5678", "1234", "123", "1.1.2020", "note..." },
                { "Credit Card Laumi", "1234-5678", "1234", "123", "1.1.2020", "note..." },
                { "Credit Card Laumi", "1234-5678", "1234", "123", "1.1.2020", "note..." },
        };
        String[] columnNames = { "Title", "Card Number","Password", "CVV","Expiring Date", "Note" };

        //setting the layout and models of the components
        mainPanel.setBorder(new EmptyBorder(5,5,5,5));
        mainPanel.setLayout(new BorderLayout());
        flowLeftPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
        flowRightPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 10));
        categoryButtonPanel.setLayout(new GridLayout(3,2));
        tablePanel.setLayout(new BorderLayout());
        topBarPanel.setLayout(new GridLayout(1,2));
        formViewTable = new JTable(data, columnNames);
        formViewTable.getTableHeader().setReorderingAllowed(false);
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        formViewTable.setModel(tableModel);
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
                try {
                    selectedRecordIndex = records.get(formViewTable.getSelectedRow()).getRecord_id();
                    viewModel.deleteRecord(selectedRecordIndex);
                } catch (ExceptionMVVM exceptionMVVM) {
                    exceptionMVVM.printStackTrace();
                }
                // TODO: 23/03/2020 check why the refresh function doesn't work
                records.remove(formViewTable.getSelectedRow());
                records.forEach(record -> System.out.println(record.toString()));
                Vector<Vector<String>> rowsToRefresh = new Vector<>();
                records.forEach(record -> rowsToRefresh.add(record.asVector(record.getCategory())));
                tableModel.setDataVector(rowsToRefresh, columnNamesToRefresh);
                formViewTable.setModel(tableModel);
            }
        });
        categoryButton1.addActionListener(new ActionListener() {//Credit Card
            @Override
            public void actionPerformed(ActionEvent e) {
                tableLabel.setText("Credit Cards");
                Vector<String> columnNames = new Vector<>();
                columnNames.add("Title");
                columnNames.add("Card Number");
                columnNames.add("Password");
                columnNames.add("CVV");
                columnNames.add("Expiring Date");
                columnNames.add("Note");
                columnNamesToRefresh = columnNames;

                records = viewModel.getRecordsByCategory("Credit Cards", activeUser);
                Vector<Vector<String>> rows = new Vector<>();
                records.forEach(record -> rows.add(record.asVector("Credit Cards")));
                tableModel.setDataVector(rows, columnNames);
                formViewTable.setModel(tableModel);
            }
        });
        categoryButton2.addActionListener(new ActionListener() {//Bank Account
            @Override
            public void actionPerformed(ActionEvent e) {
                tableLabel.setText("Bank Accounts");
                Vector<String> columnNames = new Vector<>();
                columnNames.add("Title");
                columnNames.add("User Name");
                columnNames.add("Password");
                columnNames.add("Account Number");
                columnNames.add("Bank Number");
                columnNames.add("Bank Address");
                columnNames.add("Note");

                records = viewModel.getRecordsByCategory("Bank Accounts", activeUser);
                Vector<Vector<String>> rows = new Vector<>();
                records.forEach(record -> rows.add(record.asVector("Bank Accounts")));
                tableModel.setDataVector(rows, columnNames);
                formViewTable.setModel(tableModel);
            }
        });
        categoryButton3.addActionListener(new ActionListener() {//Social Media
            @Override
            public void actionPerformed(ActionEvent e) {
                tableLabel.setText("Social Media");
                Vector<String> columnNames = new Vector<>();
                columnNames.add("Title");
                columnNames.add("User Name");
                columnNames.add("Password");
                columnNames.add("Website");
                columnNames.add("Email");
                columnNames.add("Note");

                records = viewModel.getRecordsByCategory("Social Media", activeUser);
                Vector<Vector<String>> rows = new Vector<>();
                records.forEach(record -> rows.add(record.asVector("Social Media")));
                tableModel.setDataVector(rows, columnNames);
                formViewTable.setModel(tableModel);
            }
        });
        categoryButton4.addActionListener(new ActionListener() {//Website and Email
            @Override
            public void actionPerformed(ActionEvent e) {
                tableLabel.setText("Websites and Emails");
                Vector<String> columnNames = new Vector<>();
                columnNames.add("Title");
                columnNames.add("User Name");
                columnNames.add("Password");
                columnNames.add("Website");
                columnNames.add("Email");
                columnNames.add("Note");

                records = viewModel.getRecordsByCategory("Website and Email", activeUser);
                Vector<Vector<String>> rows = new Vector<>();
                records.forEach(record -> rows.add(record.asVector("Website and Email")));
                tableModel.setDataVector(rows, columnNames);
                formViewTable.setModel(tableModel);
            }
        });
        categoryButton5.addActionListener(new ActionListener() {//Online Shopping
            @Override
            public void actionPerformed(ActionEvent e) {
                tableLabel.setText("Online Shopping");
                Vector<String> columnNames = new Vector<>();
                columnNames.add("Title");
                columnNames.add("User Name");
                columnNames.add("Password");
                columnNames.add("Website");
                columnNames.add("Email");
                columnNames.add("Note");

                records = viewModel.getRecordsByCategory("Online Shopping", activeUser);
                Vector<Vector<String>> rows = new Vector<>();
                records.forEach(record -> rows.add(record.asVector("Online Shopping")));
                tableModel.setDataVector(rows, columnNames);
                formViewTable.setModel(tableModel);
            }
        });
        categoryButton6.addActionListener(new ActionListener() {//Note
            @Override
            public void actionPerformed(ActionEvent e) {
                tableLabel.setText("Notes");
                Vector<String> columnNames = new Vector<>();
                columnNames.add("Title");
                columnNames.add("Note");
                columnNamesToRefresh = columnNames;

                records = viewModel.getRecordsByCategory("Notes", activeUser);
                Vector<Vector<String>> rows = new Vector<>();
                records.forEach(record -> rows.add(record.asVector("Notes")));
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
     * The main go function that will be called after user has logged in or singed up to the system.
     * this function is running the main screen and making it visible.
     */
    public void go(User user, MainScreen mainscreen)
    {
        mainScreen=mainscreen;
        activeUser = user;
        mainFrame.setSize(1000,500);
        mainFrame.setContentPane(mainPanel);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }
}
