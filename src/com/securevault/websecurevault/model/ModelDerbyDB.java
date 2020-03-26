package com.securevault.websecurevault.model;

import com.securevault.websecurevault.Utilities.ColumnNames;
import com.securevault.websecurevault.Utilities.Record;
import com.securevault.websecurevault.Utilities.User;

import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**Model class is used to implement the ModelInterface methods.
 * It implements three methods that responsible for the connection with the Derby Database.*/
public class ModelDerbyDB implements ModelInterface {
    DBConnection dbConnection = new DBConnection();

    public ModelDerbyDB() {
    }

    /**getRecords is returning records from the database based on the category provided.*/
    @Override
    public Vector<Record> getRecords(String category, User user)  {
        Statement statement = dbConnection.getConnection();
        ResultSet rs = null;
        Vector<Record> recordsResult = new Vector<>();

        try {
        //Getting result set by executing query
        rs = statement.executeQuery("SELECT * FROM records WHERE " + ColumnNames.userId + " LIKE '" + user.getUser_id() + "' AND " + ColumnNames.category + " LIKE '" + category + "'");
            Logger.getGlobal().log(Level.FINE,"getRecords query executed successfully");

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

    } catch (Exception e) {
        e.printStackTrace();
        Logger.getGlobal().log(Level.SEVERE,"DB connection exception in getRecords method, couldn't execute query.");
    } finally {
            try {
                dbConnection.closeConnection(statement.getConnection(),statement,rs);
            } catch (SQLException e) {
                e.printStackTrace();
                Logger.getGlobal().log(Level.SEVERE,"DB connection exception in closeConnection method.");
            }
        }
        return recordsResult;
    }

    /**addRecord is adding the item we wish to add to the database.*/
    @Override
    public void addRecord(Record record) throws ExceptionMVVM {
        Statement statement = dbConnection.getConnection();
        ResultSet rs = null;

        try {
            //Query to execute
            statement.executeUpdate("insert into records (" + ColumnNames.userId + ", " + ColumnNames.userName + "," + ColumnNames.email + ", " + ColumnNames.website + "," +
                    " " + ColumnNames.password + ", " + ColumnNames.title + ", " + ColumnNames.note + ", " + ColumnNames.cardNumber + ", " + ColumnNames.cardExpiringDate + "," +
                    " " + ColumnNames.cvv + ", " + ColumnNames.accountNumber + ", " + ColumnNames.bankAddress + ", " + ColumnNames.bankNumber + ", " + ColumnNames.category + ") " +
                    "values ('" + record.getUser_id() + "', '" + record.getUser_name() + "', '" + record.getEmail() + "', '" + record.getWebsite() + "'," +
                    " '" + record.getPassword() + "', '" + record.getTitle() + "', '" + record.getNote() + "', " + record.getCard_number() + "," +
                    " '" + record.getExpiring_date() + "', " + record.getCvv() + ", " + record.getAccount_number() + ", '" + record.getBank_address() + "'," +
                    " " + record.getBank_number() + ", '" + record.getCategory() + "')");
            Logger.getGlobal().log(Level.FINE,"addRecord query executed successfully");
        } catch (Exception e) {
            e.printStackTrace();
            Logger.getGlobal().log(Level.SEVERE,"DB connection exception in addRecord method, couldn't execute query.");
        } finally {
            try {
                dbConnection.closeConnection(statement.getConnection(),statement,rs);
            } catch (SQLException e) {
                e.printStackTrace();
                Logger.getGlobal().log(Level.SEVERE,"DB connection exception in closeConnection method.");
            }
        }
    }

    /**deleteItem is deleting the item we wish to delete from the database by using it's record id.*/
    @Override
    public void deleteRecord(int recordId) throws ExceptionMVVM {
        Statement statement = dbConnection.getConnection();
        ResultSet rs = null;

        try {
            //Query to execute
            statement.executeUpdate("delete from records where "+ ColumnNames.recordId +" = "+recordId+"");
            Logger.getGlobal().log(Level.FINE,"deleteRecord query executed successfully");
        } catch (Exception e) {
            e.printStackTrace();
            Logger.getGlobal().log(Level.SEVERE,"DB connection exception in deleteRecord method, couldn't execute query.");
        } finally {
            try {
                dbConnection.closeConnection(statement.getConnection(),statement,rs);
            } catch (SQLException e) {
                e.printStackTrace();
                Logger.getGlobal().log(Level.SEVERE,"DB connection exception in closeConnection method.");
            }
        }
    }

    /**insertUser method is inserting a new user to the DB, a user who has signed up.*/
    @Override
    public void insertUser(User user) {
        Statement statement = dbConnection.getConnection();
        ResultSet rs = null;

        try {
            DatabaseMetaData dbm = statement.getConnection().getMetaData();

            // Check if "users" table is in the database, and if not creates the table
            ResultSet tables = dbm.getTables(null, null, "USERS", null);
            if (!tables.next()) {
                initialize(statement);
                Logger.getGlobal().log(Level.FINE,"initialize query executed successfully, DB has been created");
            }

            //Inserting new users to the table
            statement.executeUpdate("insert into users values ('" + user.getUser_id() + "', '" + user.getFirst_name() + "'," +
                    " '" + user.getLast_name() + "', '" + user.getMaster_pass() + "')");
            Logger.getGlobal().log(Level.FINE,"insertUser query executed successfully");
        } catch (Exception e) {
            e.printStackTrace();
            Logger.getGlobal().log(Level.SEVERE,"DB connection exception in insertUser method, couldn't execute query.");
        } finally {
            try {
                dbConnection.closeConnection(statement.getConnection(),statement,rs);
            } catch (SQLException e) {
                e.printStackTrace();
                Logger.getGlobal().log(Level.SEVERE,"DB connection exception in closeConnection method.");
            }
        }
    }

    /**updateUserCredentials method is updating the user information  used in the profile page.*/
    @Override
    public boolean updateUserCredentials(User user) {
        Statement statement = dbConnection.getConnection();
        ResultSet rs = null;

        try {
            //updating user in table
            statement.executeUpdate("update users set "+ColumnNames.userId+" = '" + user.getUser_id() + "', "+ColumnNames.firstName+" = '" + user.getFirst_name() + "'," +
                    " " +ColumnNames.lastName + " = '" + user.getLast_name() + "', "+ColumnNames.masterPass+" = '" + user.getMaster_pass() + "' " +
                    "where "+ColumnNames.userId+" like '" + user.getUser_id() + "' ");
            Logger.getGlobal().log(Level.FINE,"updateUserCredentials query executed successfully");
        } catch (Exception e) {
            e.printStackTrace();
            Logger.getGlobal().log(Level.SEVERE,"DB connection exception in updateUserCredentials method, couldn't execute query.");
            return false;
        } finally {
            try {
                dbConnection.closeConnection(statement.getConnection(),statement,rs);
            } catch (SQLException e) {
                e.printStackTrace();
                Logger.getGlobal().log(Level.SEVERE,"DB connection exception in closeConnection method.");
            }
        }
        return true;
    }

    /**checkCredentials method is for checking users login credentials,
     *it checks to see if the user is in the DB and if so log's him in to the system.*/
    @Override
    public User checkCredentials(User user) {
        Statement statement = dbConnection.getConnection();
        ResultSet rs = null;
        User userToReturn = new User();

        try {
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
            Logger.getGlobal().log(Level.SEVERE,"DB connection exception in checkCredentials method, couldn't execute query.");
        } finally {
            try {
                dbConnection.closeConnection(statement.getConnection(),statement,rs);
            } catch (SQLException e) {
                e.printStackTrace();
                Logger.getGlobal().log(Level.SEVERE,"DB connection exception in closeConnection method.");
            }
        }
        return userToReturn;
    }

    /**initialize method is used to initialize the DB and create the records and users tables in case its the first run of the system.*/
    @Override
    public void initialize (Statement statement){
        ResultSet rs = null;

        try {
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

            //Inserting master users to the table
            statement.executeUpdate("insert into users values ('master','Yuval','Nir','1234')");
            Logger.getGlobal().log(Level.FINE, "Data created in records and in users.");

        } catch (Exception e) {
            e.printStackTrace();
            Logger.getGlobal().log(Level.SEVERE,"DB connection exception in initialize method, couldn't execute query.");
        }
    }

}
