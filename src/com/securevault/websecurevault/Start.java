package com.securevault.websecurevault;

import com.securevault.websecurevault.view.LogIn;

/**Start class runs the main method of the app.
 * It's connecting to the DB and running the main screen of the app.*/
public class Start {

    public static void main(String[] args) {
        LogIn logIn = new LogIn();
        logIn.go();

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
