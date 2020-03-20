package com.securevault.websecurevault.viewmodel;

import com.securevault.websecurevault.ObjectTypes.Record;
import com.securevault.websecurevault.ObjectTypes.User;
import com.securevault.websecurevault.model.ExceptionMVVM;
import com.securevault.websecurevault.model.ModelDerbyDB;

import java.util.ArrayList;
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
    public void insertNewUser(User user) {
        model.insertUser(user);
    }

    @Override
    public User getUser(User user) {
        // TODO: 19/03/2020 creat the getUserFromDB method
        //model.getUserFromDB(user);
        return null;
    }
}
