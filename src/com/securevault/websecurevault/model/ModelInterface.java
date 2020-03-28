package com.securevault.websecurevault.model;

import com.securevault.websecurevault.utilities.Record;
import com.securevault.websecurevault.utilities.User;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**ModelInterface is an interface which is implemented by model classes.
 * It has three methods that can be implemented for multiple databases*/

public interface ModelInterface {
    Vector<Record> getRecords(String category, User user) throws ExceptionMVVM, SQLException;
    void addRecord(Record record) throws ExceptionMVVM;
    void deleteRecord(int recordId) throws ExceptionMVVM;
    void insertUser(User user);
    boolean updateUserCredentials(User user);
    User checkCredentials(User user);
    void initialize (Statement statement);
}
