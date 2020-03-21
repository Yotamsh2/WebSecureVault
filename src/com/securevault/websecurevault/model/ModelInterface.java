package com.securevault.websecurevault.model;

import com.securevault.websecurevault.ObjectTypes.Record;
import com.securevault.websecurevault.ObjectTypes.User;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

/**ModelInterface is an interface which is implemented by model classes.
 * It has three methods that can be implemented for multiple databases*/

public interface ModelInterface {
    Vector<Record> getRecords(String category, User user) throws ExceptionMVVM;
    void addRecord(Record record) throws ExceptionMVVM;
    void deleteRecord(int recordId) throws ExceptionMVVM;
    void insertUser(User user);
    User getUser(User user);
    User checkCredentials(User user);
}
