package com.securevault.websecurevault.model;

import com.securevault.websecurevault.ObjectTypes.Record;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * DBConnection class creates connection with the database so we can add, delete or get data from it.
 * Also in case the derby database not created yet - it creates the DB and a table.
 */
public class DBConnection {
    //Initiate the names of the records columns
    public static final String COL_TITLE = "title";
    public static final String COL_CATEGORY = "category";
    public static final String COL_USERNAME = "user_name";
    public static final String COL_PASSWORD = "password";
    public static final String COL_ACCOUNT_NUMBER = "account_number";
    public static final String COL_BANK_NUMBER = "bank_number";
    public static final String COL_BANK_ADDRESS = "bank_address";
    public static final String COL_NOTE = "note";
    public static final String COL_CARD_NUMBER = "card_number";
    public static final String COL_CVV = "cvv";
    public static final String COL_CARD_EXPIRING_DATE = "expiring_date";
    public static final String COL_WEBSITE = "website";
    public static final String COL_EMAIL = "email";
    public static final String COL_RECORD_ID = "record_id";  // AutoGenerated
    public static final String COL_USER_ID = "user_id"; //For both tables (Records and Users)
    // Initiate the names of the users columns
    public static final String COL_FIRST_NAME = "first_name";
    public static final String COL_LAST_NAME = "last_name";
    public static final String COL_MASTER_PASS = "master_pass";


    /**
     * Determine the requested driver and the jdbc protocol
     */
    public static String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    public static String protocol = "jdbc:derby:secureVaultDB;create=true";

    /**
     * Constructor initialize the references of: connection, statement and resultSet(which hold the lines we ask to get from the DB).
     */
    public DBConnection() {
    }

    public ArrayList<Record> getResultSetByCategory (String category) {
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        ArrayList<Record> recordsResult = new ArrayList<>();
        Logger.getGlobal().log(Level.FINE, "Connection, Statement and ResultSet initialized to null.");

        try {
            //Instantiating the driver class will indirectly register this driver as an available driver for DriverManager
            Class.forName(driver);
            //Getting a connection by calling getConnection
            connection = DriverManager.getConnection(protocol);
            Logger.getGlobal().log(Level.FINE, "Connection was made successfully.");

            DatabaseMetaData dbm = connection.getMetaData();
            // Check if "records" table is in the database
            ResultSet tables = dbm.getTables(null, null, "RECORDS", null);
            if (tables.next()) {

            }
            else {
                initialize(connection);
                closeConnection(connection,statement,rs);
                return null;
            }


            //Creating statement
            statement = connection.createStatement();
            Logger.getGlobal().log(Level.FINE, "Statement created.");

            //Getting result set by executing query
            rs = statement.executeQuery(
                    "SELECT * FROM records WHERE "+COL_CATEGORY+" LIKE '"+category+"' ORDER BY record_id");
            //Scan the resultSet data and print it
            while (rs.next()) {
                System.out.println("RecordID=" + rs.getInt("record_id") + " , UserID=" + rs.getString("user_id"));
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
            statement.execute("create table records(" + COL_RECORD_ID + " int," + COL_USER_ID + " varchar(255)," + COL_USERNAME + " varchar(255)," +
                    COL_EMAIL + " varchar(255)," + COL_WEBSITE + " varchar(255)," + COL_PASSWORD + " varchar(255)," + COL_TITLE + " varchar(255)," +
                    COL_NOTE + " varchar(255)," + COL_CARD_NUMBER + " int," + COL_CARD_EXPIRING_DATE + " varchar(255) ," + COL_CVV + " int," +
                    COL_ACCOUNT_NUMBER + " int," + COL_BANK_ADDRESS + " varchar(255)," + COL_BANK_NUMBER + " int," + COL_CATEGORY + " varchar(255)" + " )");
            Logger.getGlobal().log(Level.FINE, "Table records created.");
            //Creating "users" table and 4 columns
            statement.execute("create table users(" + COL_USER_ID + " varchar(255)," + COL_FIRST_NAME + " varchar(255)," +
                    COL_LAST_NAME + " varchar(255)," + COL_MASTER_PASS + " varchar(255)" + " )");
            Logger.getGlobal().log(Level.FINE, "Table users created.");


            //Inserting new records with values to the table
            statement.executeUpdate("insert into records values (100215, 'yotamsh2@gmail.com','userName','Email','','','','',9,'',10,11,'',12,'Website')");
            statement.executeUpdate("insert into records values (100214, 'yuval@gmail.com','userName','Email','','','','',9,'',10,11,'',12,'Social Media')");
            statement.executeUpdate("insert into records values (100213, 'yuval@gmail.com','userName','Email','','','','',9,'',10,11,'',12,'Website')");
            //Inserting new users to the table
            statement.executeUpdate("insert into users values ('yotamsh2@gmail.com','Yotam','Shoval','*******')");
            statement.executeUpdate("insert into users values ('yuval@gmail.com','Yuval','Nir','**********')");
            Logger.getGlobal().log(Level.FINE, "Data created in records and in users.");

            //Getting result set by executing query
            rs = statement.executeQuery(
                    "SELECT " + COL_RECORD_ID + ",user_id FROM records ORDER BY record_id");
            //Scan the resultSet data and print it
            while (rs.next()) {
                System.out.println("id=" + rs.getInt("record_id") + " , UserID=" + rs.getString("user_id"));
            }
            //Getting result set by executing query
            rs = statement.executeQuery(
                    "SELECT " + COL_USER_ID + "," + COL_FIRST_NAME + "," + COL_LAST_NAME + "," + COL_MASTER_PASS + " FROM users ORDER BY user_id");
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
        } finally {
            if (statement != null) try {
                statement.close();
            } catch (Exception e) {
            }
            if (connection != null) try {
                connection.close();
            } catch (Exception e) {
            }
            if (rs != null) try {
                rs.close();
            } catch (Exception e) {
            }
        }

    }


}
