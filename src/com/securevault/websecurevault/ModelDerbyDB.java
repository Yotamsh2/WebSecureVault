package com.securevault.websecurevault;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.securevault.websecurevault.DBConnection.*;

/**Model class is used to implement the ModelInterface methods.
 * It implements three methods that responsible for the connection with the Derby Database.*/
public class ModelDerbyDB implements ModelInterface {

    public ModelDerbyDB() {

    }

    /**getRecords is returning the ResultSet we wish to get from the database.*/
    @Override
    public ResultSet getRecords(String category) {
        DBConnection dbConnection = new DBConnection();
        return dbConnection.getResultSetByCategory(category);
    }

    /**addRecord is adding the item we wish to add to the database.
     * It has no return value*/
    @Override
    public void addRecord(String text) throws ExceptionMVVM {
        // TODO Auto-generated method stub

    }

    /**deleteItem is deleting the item we wish to delete from the database.
     * It has no return value*/
    @Override
    public void deleteRecord(int recordId) throws ExceptionMVVM {
        // TODO Auto-generated method stub

    }

}
