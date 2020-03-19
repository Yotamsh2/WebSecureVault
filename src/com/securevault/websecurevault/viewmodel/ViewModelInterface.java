package com.securevault.websecurevault.viewmodel;

import com.securevault.websecurevault.ObjectTypes.Record;
import com.securevault.websecurevault.ObjectTypes.User;
import com.securevault.websecurevault.model.ExceptionMVVM;

import java.util.Vector;

public interface ViewModelInterface {
    Vector<Record> getRecordsByCategory(String category);
    void insertNewRecord(Record record) throws ExceptionMVVM;
    User insertNewUser(User user);
    User getUser(User user);

}
