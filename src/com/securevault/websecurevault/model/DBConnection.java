package com.securevault.websecurevault.model;

import com.securevault.websecurevault.Utilities.ColumnNames;
import com.securevault.websecurevault.Utilities.Record;
import com.securevault.websecurevault.Utilities.User;

import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**DBConnection class creates connection with the database so we can add, delete or get data from it.
 * Also in case the derby database not created yet - it creates the DB and a table.*/
public class DBConnection {

    /**Determine the requested driver and the jdbc protocol*/
    public static String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    public static String protocol = "jdbc:derby:secureVaultDB;create=true";

    /**Constructor initialize the references of: connection, statement and resultSet(which hold the lines we ask to get from the DB).*/
    public DBConnection() {
    }

    public Vector<Record> getRecordByCategory(String category, User user) {
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        Vector<Record> recordsResult = new Vector<>();
        Logger.getGlobal().log(Level.FINE, "Connection, Statement and ResultSet initialized to null.");

        try {
            //Instantiating the driver class will indirectly register this driver as an available driver for DriverManager
            Class.forName(driver);
            //Getting a connection by calling getConnection
            connection = DriverManager.getConnection(protocol);
            Logger.getGlobal().log(Level.FINE, "Connection was made successfully.");
            DatabaseMetaData dbm = connection.getMetaData();

            //Creating statement
            statement = connection.createStatement();
            Logger.getGlobal().log(Level.FINE, "Statement created.");

            //Getting result set by executing query
            rs = statement.executeQuery("SELECT * FROM records WHERE " + ColumnNames.userId + " LIKE '" + user.getUser_id() + "' AND " + ColumnNames.category + " LIKE '" + category + "'");

            //Scan the resultSet data and print it
            while (rs.next()) {
                //System.out.println("RecordID=" + rs.getInt("record_id") + " , UserID=" + rs.getString("user_id"));
                String title = rs.getString("title");
                String cat = rs.getString("category");
                String user_name  = rs.getString("user_name");
                String password = rs.getString("password");
                int account_number = rs.getInt("account_number");
                int bank_number = rs.getInt("bank_number");
                String bank_address= rs.getString("bank_address");
                String note = rs.getString("note");
                int card_number = rs.getInt("card_number");
                int cvv = rs.getInt("cvv");
                String expiring_date= rs.getString("expiring_date");
                String website = rs.getString("website");
                String email = rs.getString("email");
                int record_id = rs.getInt("record_id");
                String user_id = rs.getString("user_id");

                Record r = new Record(title,cat,user_name,password,account_number,bank_number,bank_address,note,card_number,cvv,expiring_date,
                        website,email,record_id,user_id);
                recordsResult.add(r);
            }
            //check printing all records in DB
            rs = statement.executeQuery("SELECT * FROM records");
            while (rs.next()) {

                String title = rs.getString("title");
                String cat = rs.getString("category");
                String user_name  = rs.getString("user_name");
                String password = rs.getString("password");
                int account_number = rs.getInt("account_number");
                int bank_number = rs.getInt("bank_number");
                String bank_address= rs.getString("bank_address");
                String note = rs.getString("note");
                int card_number = rs.getInt("card_number");
                int cvv = rs.getInt("cvv");
                String expiring_date= rs.getString("expiring_date");
                String website = rs.getString("website");
                String email = rs.getString("email");
                int record_id = rs.getInt("record_id");
                String user_id = rs.getString("user_id");

                Record r = new Record(title,cat,user_name,password,account_number,bank_number,bank_address,note,card_number,cvv,expiring_date,
                        website,email,record_id,user_id);
                System.out.println(r.toString());
            }
/*
		//Deleting the table after the check
		statement.execute("DROP TABLE records");
*/
        } catch (Exception e) {
            e.printStackTrace();
            Logger.getGlobal().log(Level.SEVERE,"DB connection exception.");
        } finally {
            closeConnection(connection,statement,rs);
        }
        return recordsResult;
    }

    public void addRecordToDB(Record record){
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        Logger.getGlobal().log(Level.FINE, "Connection, Statement and ResultSet initialized to null.");

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(protocol);
            Logger.getGlobal().log(Level.FINE, "Connection was made successfully.");
            DatabaseMetaData dbm = connection.getMetaData();

            //Creating statement
            statement = connection.createStatement();
            Logger.getGlobal().log(Level.FINE, "Statement created.");

            //Query to execute
            statement.executeUpdate("insert into records (" + ColumnNames.userId + ", " + ColumnNames.userName + "," + ColumnNames.email + ", " + ColumnNames.website + "," +
                    " " + ColumnNames.password + ", " + ColumnNames.title + ", " + ColumnNames.note + ", " + ColumnNames.cardNumber + ", " + ColumnNames.cardExpiringDate + "," +
                    " " + ColumnNames.cvv + ", " + ColumnNames.accountNumber + ", " + ColumnNames.bankAddress + ", " + ColumnNames.bankNumber + ", " + ColumnNames.category + ") " +
                    "values ('" + record.getUser_id() + "', '" + record.getUser_name() + "', '" + record.getEmail() + "', '" + record.getWebsite() + "'," +
                    " '" + record.getPassword() + "', '" + record.getTitle() + "', '" + record.getNote() + "', " + record.getCard_number() + "," +
                    " '" + record.getExpiring_date() + "', " + record.getCvv() + ", " + record.getAccount_number() + ", '" + record.getBank_address() + "'," +
                    " " + record.getBank_number() + ", '" + record.getCategory() + "')");

        } catch (Exception e) {
            e.printStackTrace();
            Logger.getGlobal().log(Level.SEVERE,"DB connection exception. Couldn't execute query");
        } finally {
            closeConnection(connection,statement,rs);
        }
    }

    public void deleteRecordFromDB(int recordId){
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        Logger.getGlobal().log(Level.FINE, "Connection, Statement and ResultSet initialized to null.");

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(protocol);
            Logger.getGlobal().log(Level.FINE, "Connection was made successfully.");
            DatabaseMetaData dbm = connection.getMetaData();

            //Creating statement
            statement = connection.createStatement();
            Logger.getGlobal().log(Level.FINE, "Statement created.");

            //Query to execute
            statement.executeUpdate("delete from records where "+ ColumnNames.recordId +" = "+recordId+"");
            Logger.getGlobal().log(Level.SEVERE,"Record deleted from DB.");
        } catch (Exception e) {
            e.printStackTrace();
            Logger.getGlobal().log(Level.SEVERE,"DB connection exception. Couldn't execute query");
        } finally {
            closeConnection(connection,statement,rs);
        }
    }

    public void insertNewUserToDB(User user){
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        Logger.getGlobal().log(Level.FINE, "Connection, Statement and ResultSet initialized to null.");

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(protocol);
            Logger.getGlobal().log(Level.FINE, "Connection was made successfully.");
            DatabaseMetaData dbm = connection.getMetaData();

            // Check if "users" table is in the database, and if not creates the table
            ResultSet tables = dbm.getTables(null, null, "USERS", null);
            if (!tables.next()) {
                initialize(connection);
            }

            //Creating statement
            statement = connection.createStatement();
            Logger.getGlobal().log(Level.FINE, "Statement created.");

            //Inserting new users to the table
            statement.executeUpdate("insert into users values ('" + user.getUser_id() + "', '" + user.getFirst_name() + "'," +
                    " '" + user.getLast_name() + "', '" + user.getMaster_pass() + "')");

        } catch (Exception e) {
            e.printStackTrace();
            Logger.getGlobal().log(Level.SEVERE,"DB connection exception. Couldn't execute query");
        } finally {
            closeConnection(connection,statement,rs);
        }
    }

    public boolean updateUserCredentials(User user){
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        Logger.getGlobal().log(Level.FINE, "Connection, Statement and ResultSet initialized to null.");

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(protocol);
            Logger.getGlobal().log(Level.FINE, "Connection was made successfully.");
            DatabaseMetaData dbm = connection.getMetaData();

            //Creating statement
            statement = connection.createStatement();
            Logger.getGlobal().log(Level.FINE, "Statement created.");

            //updating user in table
            statement.executeUpdate("update users set "+ColumnNames.userId+" = '" + user.getUser_id() + "', "+ColumnNames.firstName+" = '" + user.getFirst_name() + "'," +
                    " " +ColumnNames.lastName + " = '" + user.getLast_name() + "', "+ColumnNames.masterPass+" = '" + user.getMaster_pass() + "' " +
                    "where "+ColumnNames.userId+" like '" + user.getUser_id() + "' ");
        } catch (Exception e) {
            e.printStackTrace();
            Logger.getGlobal().log(Level.SEVERE,"DB connection exception. Couldn't execute query");
            return false;
        } finally {
            closeConnection(connection,statement,rs);
        }
        return true;
    }

    public User checkUserCredentials(User user){
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        User userToReturn = new User();
        Logger.getGlobal().log(Level.FINE, "Connection, Statement and ResultSet initialized to null.");

        try {
            //Instantiating the driver class will indirectly register this driver as an available driver for DriverManager
            Class.forName(driver);
            //Getting a connection by calling getConnection
            connection = DriverManager.getConnection(protocol);
            Logger.getGlobal().log(Level.FINE, "Connection was made successfully.");

            DatabaseMetaData dbm = connection.getMetaData();

            //Creating statement
            statement = connection.createStatement();
            Logger.getGlobal().log(Level.FINE, "Statement created.");

            //checks for a match of user_id and password in the DB
            rs = statement.executeQuery(
                    "SELECT * FROM users WHERE "+ColumnNames.userId+" LIKE '" + user.getUser_id() + "' AND "+ColumnNames.masterPass+" LIKE '" + user.getMaster_pass() + "' ");

            if (rs.next()) {
                userToReturn.setUser_id(rs.getString("user_id"));
                userToReturn.setFirst_name(rs.getString("first_name"));
                userToReturn.setLast_name(rs.getString("last_name"));
                userToReturn.setMaster_pass(rs.getString("master_pass"));
                Logger.getGlobal().log(Level.FINE, "User correctly authenticated in the DB!.");
                //printing the user for debugging
                System.out.println("UserID=" + rs.getString("user_id") + " , FirstName=" + rs.getString("first_name") +
                        " , LastName=" + rs.getString("last_name") + " , Password=" + rs.getString("master_pass"));
            } else {
                userToReturn.setUser_id(null);
                Logger.getGlobal().log(Level.FINE, "rs came back NULL, no user was found.");
                System.out.println("rs is NULL, no user was found");
            }

        } catch (Exception e) {
            e.printStackTrace();
            Logger.getGlobal().log(Level.SEVERE,"DB connection exception.");
        } finally {
            closeConnection(connection,statement,rs);
        }
        return userToReturn;
    }

    private void closeConnection (Connection connection, Statement statement, ResultSet rs){

        if (rs != null) try {
            //rs.close();
        } catch (Exception e) {
        }
        if (statement != null) try {
            statement.close();
        } catch (Exception e) {
        }
        if (connection != null) try {
            connection.close();
        } catch (Exception e) {
        }
    }

    public void initialize (Connection connection){
        Statement statement = null;
        ResultSet rs = null;

        try {
            //Creating statement
            statement = connection.createStatement();
            Logger.getGlobal().log(Level.FINE, "Statement created.");

            //Creating "records" table and 15 columns
            statement.execute("create table records(" + ColumnNames.recordId + " INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," + ColumnNames.userId + " varchar(255)," + ColumnNames.userName + " varchar(255)," +
                    ColumnNames.email + " varchar(255)," + ColumnNames.website + " varchar(255)," + ColumnNames.password + " varchar(255)," + ColumnNames.title + " varchar(255)," +
                    ColumnNames.note + " varchar(255)," + ColumnNames.cardNumber + " int," + ColumnNames.cardExpiringDate + " varchar(255) ," + ColumnNames.cvv + " int," +
                    ColumnNames.accountNumber + " int," + ColumnNames.bankAddress + " varchar(255)," + ColumnNames.bankNumber + " int," + ColumnNames.category + " varchar(255)" + " )");
            Logger.getGlobal().log(Level.FINE, "Table records created.");

            //Creating "users" table and 4 columns
            statement.execute("create table users(" + ColumnNames.userId + " varchar(255)," + ColumnNames.firstName + " varchar(255)," +
                    ColumnNames.lastName + " varchar(255)," + ColumnNames.masterPass + " varchar(255)" + " )");
            Logger.getGlobal().log(Level.FINE, "Table users created.");


            //Inserting new records with values to the table

            //Inserting new users to the table
            statement.executeUpdate("insert into users values ('master','Yuval','Nir','1234')");
            Logger.getGlobal().log(Level.FINE, "Data created in records and in users.");

            //Getting result set by executing query
            rs = statement.executeQuery(
                    "SELECT " + ColumnNames.recordId + ",user_id FROM records ORDER BY record_id");
            //Scan the resultSet data and print it
            while (rs.next()) {
                System.out.println("id=" + rs.getInt("record_id") + " , UserID=" + rs.getString("user_id"));
            }
            //Getting result set by executing query
            rs = statement.executeQuery(
                    "SELECT " + ColumnNames.userId + "," + ColumnNames.firstName + "," + ColumnNames.lastName + "," + ColumnNames.masterPass + " FROM users ORDER BY user_id");
            //Scan the resultSet data and print it
            while (rs.next()) {
                System.out.println("UserId=" + rs.getString("user_id"));
            }
/*
		//Deleting the table after the check
		statement.execute("DROP TABLE records");
*/
        } catch (Exception e) {
            e.printStackTrace();
            Logger.getGlobal().log(Level.SEVERE,"DB connection exception.");
        }
    }
}
