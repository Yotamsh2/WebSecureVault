package com.securevault.websecurevault;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/**Start class runs the main method of the app.
 * It is connecting to the DB and run the main screen of the app.*/
public class Start {

    public static void main(String[] args) {
        DBConnection dbConnection = new DBConnection();  //TODO: make the DBConnection a SingleTon design pattern
        Logger.getGlobal().log(Level.INFO,"Test INFO"+dbConnection.toString());
        Logger.getGlobal().log(Level.ALL,"Test ALL");
        Logger.getGlobal().log(Level.CONFIG,"Test CONFIG");
        Logger.getGlobal().log(Level.FINE,"Test FINE");
        Logger.getGlobal().log(Level.FINER,"Test FINER");
        Logger.getGlobal().log(Level.FINEST,"Test FINEST");
        Logger.getGlobal().log(Level.SEVERE,"Test SEVERE");
        Logger.getGlobal().log(Level.WARNING,"Test WARNING");
        Logger.getGlobal().log(Level.OFF,"Test OFF");
        System.out.println("Logger Name= "+Logger.GLOBAL_LOGGER_NAME);

//        View_MainScreen mainScreen = new View_MainScreen(); //TODO create view class of the main screen
    }

}
