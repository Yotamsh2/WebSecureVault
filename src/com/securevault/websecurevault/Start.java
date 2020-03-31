package com.securevault.websecurevault;

import com.securevault.websecurevault.view.LogIn;

/**Start class runs the main method of the app.
 * It connects to the DB and runs the main screen of the app.*/
public class Start {

    public static void main(String[] args) {
        LogIn logIn = new LogIn();
        logIn.go();
    }
}
