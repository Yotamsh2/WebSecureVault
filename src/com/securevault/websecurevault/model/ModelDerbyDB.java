package com.securevault.websecurevault.model;

import com.securevault.websecurevault.ObjectTypes.Record;
import com.securevault.websecurevault.ObjectTypes.User;

import java.util.Vector;

/**Model class is used to implement the ModelInterface methods.
 * It implements three methods that responsible for the connection with the Derby Database.*/
public class ModelDerbyDB implements ModelInterface {
    DBConnection dbConnection = new DBConnection();

    public ModelDerbyDB() {
    }

    /**getRecords is returning the ResultSet we wish to get from the database.*/
    @Override
    public Vector<Record> getRecords(String category, User user) {
        return dbConnection.getRecordByCategory(category, user);
    }

    /**addRecord is adding the item we wish to add to the database.
     * It has no return value*/
    @Override
    public void addRecord(Record record) throws ExceptionMVVM {
        dbConnection.addRecordToDB(record);
    }

    /**deleteItem is deleting the item we wish to delete from the database.
     * It has no return value*/
    @Override
    public void deleteRecord(int recordId) throws ExceptionMVVM {
        // TODO Auto-generated method stub

    }

    @Override
    public void insertUser(User user) {
        dbConnection.insertNewUserToDB(user);
    }

    @Override
    public User getUser(User user) {
        return null;
    }

}
