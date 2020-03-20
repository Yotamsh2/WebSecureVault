package com.securevault.websecurevault;

import com.securevault.websecurevault.ObjectTypes.Record;
import com.securevault.websecurevault.model.ExceptionMVVM;
import com.securevault.websecurevault.model.ModelDerbyDB;
import com.securevault.websecurevault.view.LogIn;
import com.securevault.websecurevault.view.MainScreen;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**Start class runs the main method of the app.
 * It's connecting to the DB and running the main screen of the app.*/
public class Start {

    public static void main(String[] args) {
        //MainScreen mainScreen = new MainScreen();
        //mainScreen.go(mainScreen); //Create And Show Main Screen
        LogIn logIn = new LogIn();
        logIn.go();

        //ModelDerbyDB mdDB = new ModelDerbyDB();
        //added a new Credit Card record to db
        /*Record record1 = new Record("Credit Card Hapoalim","Credit Card","user_name","1234",
                1234,1234,"","note...",12345678,123 , "1.1.2020",
                "" , "",100216,"yuval@gmail.com");
        try {
            mdDB.addRecord(record1);
        } catch (ExceptionMVVM exceptionMVVM) {
            exceptionMVVM.printStackTrace();
        }*/

        /*Vector<Record> records = mdDB.getRecords("Social Media");
        if (records == null)
            Logger.getGlobal().log(Level.SEVERE,"rs is NULL");
        else {
            records.forEach(record -> System.out.println(""+ record.toString()));
        }*/

        //System.out.println("rs: "+ rs.toString());

/*
        try {
            while (rs.next()) {
                System.out.println("Record ID = " + rs.getInt("record_id") + ", Category = " + rs.getString("category") +
                        "User ID = " + rs.getString("user_id") + ", Title = " + rs.getString("title") +
                        "Website = " + rs.getString("website") + ", Email = " + rs.getString("email"));
            rs.close();
            }
        }
        catch (Exception e) {
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
