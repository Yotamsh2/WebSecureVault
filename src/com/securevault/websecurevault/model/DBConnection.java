package com.securevault.websecurevault.model;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**DBConnection class creates connection with the database so we can add, delete or get data from it.
 * Also in case the derby database not created yet - it creates the DB and a table.*/
public class DBConnection {

    /**Determine the requested driver and the jdbc protocol.*/
    public static String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    public static String protocol = "jdbc:derby:secureVaultDB;create=true";

    public DBConnection() {
    }

    /**Responsible for the connection to the DB.*/
    public Statement getConnection() {
        Connection connection;
        Statement statement = null;

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
        } catch (Exception e) {
            e.printStackTrace();
            Logger.getGlobal().log(Level.SEVERE,"DB connection exception in getConnection method.");
        }
        return statement;
    }

    /**Responsible for closing the Connection to the DB.*/
    public void closeConnection (Connection connection, Statement statement, ResultSet rs){

        if (rs != null) try {
            rs.close();
            Logger.getGlobal().log(Level.FINE,"rs.close() executed successfully");
        } catch (Exception e) {
            Logger.getGlobal().log(Level.SEVERE,"DB connection exception in closeConnection - rs.close method.");
        }
        if (statement != null) try {
            statement.close();
            Logger.getGlobal().log(Level.FINE,"statement.close() executed successfully");
        } catch (Exception e) {
            Logger.getGlobal().log(Level.SEVERE,"DB connection exception in closeConnection - statement.close method.");
        }
        if (connection != null) try {
            connection.close();
            Logger.getGlobal().log(Level.FINE,"connection.close() executed successfully");
        } catch (Exception e) {
            Logger.getGlobal().log(Level.SEVERE,"DB connection exception in closeConnection - connection.close method.");
        }
    }
}
