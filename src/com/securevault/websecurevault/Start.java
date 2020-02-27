package com.securevault.websecurevault;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/**Start class runs the main method of the app.
 * It is connecting to the DB and run the main screen of the app.*/
public class Start {

    public static void main(String[] args) {
        ModelDerbyDB mdDB = new ModelDerbyDB();
        ResultSet rs = mdDB.getRecords("Website");
        //System.out.println("rs: "+ rs.toString());
/*


        try {
            while (rs.next()) {
                System.out.println("Record ID = " + rs.getInt("record_id") + ", Category = " + rs.getString("category") +
                        "User ID = " + rs.getString("user_id") + ", Title = " + rs.getString("title") +
                        "Website = " + rs.getString("website") + ", Email = " + rs.getString("email"));
            rs.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
*/


//        View_MainScreen mainScreen = new View_MainScreen(); //TODO create view class of the main screen


        //TODO Examples - delete if don't need
        /*
        //Log for general information - anything that we want to know when looking at the log files
        Logger.getGlobal().log(Level.INFO,"Test INFO"+dbConnection.toString());

        //Log for successful processes
        Logger.getGlobal().log(Level.FINE,"Test FINE");

        //Log for message that might warn us of potential problems.
        Logger.getGlobal().log(Level.WARNING,"Test WARNING");

        //Log for any error/exception that is or might be critical.
        Logger.getGlobal().log(Level.SEVERE,"Test SEVERE");

        System.out.println("Logger Name= "+Logger.GLOBAL_LOGGER_NAME);
*/

    }
}
