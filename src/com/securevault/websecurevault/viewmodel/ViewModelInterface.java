package com.securevault.websecurevault.viewmodel;

import com.securevault.websecurevault.ObjectTypes.Record;
import com.securevault.websecurevault.ObjectTypes.User;
import com.securevault.websecurevault.model.ExceptionMVVM;

import java.util.Vector;

public interface ViewModelInterface {
    Vector<Record> getRecordsByCategory(String category, User user);
    void insertNewRecord(Record record) throws ExceptionMVVM;
    void deleteRecord(int recordId) throws ExceptionMVVM;
    void insertNewUser(User user);
    boolean updateUser(User user);
    User checkCredentials(User user);

}
