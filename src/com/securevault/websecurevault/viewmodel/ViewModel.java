package com.securevault.websecurevault.viewmodel;

import com.securevault.websecurevault.Utilities.Record;
import com.securevault.websecurevault.Utilities.User;
import com.securevault.websecurevault.model.ExceptionMVVM;
import com.securevault.websecurevault.model.ModelDerbyDB;

import java.util.Vector;

public class ViewModel implements ViewModelInterface{
    ModelDerbyDB model = new ModelDerbyDB();

    @Override
    public Vector<Record> getRecordsByCategory(String category, User user){
        return model.getRecords(category, user);
    }

    @Override
    public void insertNewRecord(Record record) throws ExceptionMVVM {
        model.addRecord(record);
    }

    @Override
    public void deleteRecord(int recordId) throws ExceptionMVVM {
        model.deleteRecord(recordId);
    }

    @Override
    public void insertNewUser(User user) {
        model.insertUser(user);
    }

    @Override
    public boolean updateUser(User user) {
        return model.updateUserCredentials(user);
    }

    @Override
    public User checkCredentials(User user) {
        return model.checkCredentials(user);
    }
}
