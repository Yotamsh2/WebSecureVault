package com.securevault.websecurevault.model;

import com.securevault.websecurevault.Utilities.Record;
import com.securevault.websecurevault.Utilities.User;

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

    /**deleteItem is deleting the item we wish to delete from the database by using it's id.
     * It has no return value*/
    @Override
    public void deleteRecord(int recordId) throws ExceptionMVVM {
        dbConnection.deleteRecordFromDB(recordId);
    }

    /**insertUser method is inserting a new user to the DB, a user who has signed up.*/
    @Override
    public void insertUser(User user) {
        dbConnection.insertNewUserToDB(user);
    }

    /**updateUserCredentials method is updating the user information  used in the profile page.*/
    @Override
    public boolean updateUserCredentials(User user) {
        return dbConnection.updateUserCredentials(user);
    }

    /**checkCredentials method is for checking users login credentials,
     *it checks to see if the user is in the DB and if so log's him in to the system.*/
    @Override
    public User checkCredentials(User user) {
        return dbConnection.checkUserCredentials(user);
    }

}
