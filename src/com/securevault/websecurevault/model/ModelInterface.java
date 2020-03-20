package com.securevault.websecurevault.model;

import com.securevault.websecurevault.ObjectTypes.Record;
import com.securevault.websecurevault.ObjectTypes.User;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

/**ModelInterface is an interface which is implemented by model classes.
 * It has three methods that can be implemented for multiple databases*/

public interface ModelInterface {
    public Vector<Record> getRecords(String category, User user) throws ExceptionMVVM;
    public void addRecord(Record record) throws ExceptionMVVM;
    public void deleteRecord(int recordId) throws ExceptionMVVM;
    public void insertUser(User user);
    public User getUser(User user);
}
