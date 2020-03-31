package com.securevault.websecurevault.viewmodel;

import com.securevault.websecurevault.utilities.Record;
import com.securevault.websecurevault.utilities.User;
import com.securevault.websecurevault.model.ExceptionMVVM;
import com.securevault.websecurevault.model.ModelDerbyDB;

import java.util.Vector;

/**ViewModel class is responsible for connecting the view and the model.*/
public class ViewModel implements ViewModelInterface{
    ModelDerbyDB model = new ModelDerbyDB();

    /**getRecordsByCategory method is responsible for calling the getRecords method from the model.*/
    @Override
    public Vector<Record> getRecordsByCategory(String category, User user){
        return model.getRecords(category, user);
    }

    /**insertNewRecord method is responsible for calling the addRecord method from the model.*/
    @Override
    public void insertNewRecord(Record record) throws ExceptionMVVM {
        model.addRecord(record);
    }

    /**deleteRecord method is responsible for calling the deleteRecord method from the model.*/
    @Override
    public void deleteRecord(int recordId) throws ExceptionMVVM {
        model.deleteRecord(recordId);
    }

    /**insertNewUser method is responsible for calling the insertUser method from the model.*/
    @Override
    public void insertNewUser(User user) {
        model.insertUser(user);
    }

    /**updateUser method is responsible for calling the updateUserCredentials method from the model.*/
    @Override
    public boolean updateUser(User user) {
        return model.updateUserCredentials(user);
    }

    /**checkCredentials method is responsible for calling the checkCredentials method from the model.*/
    @Override
    public User checkCredentials(User user) {
        return model.checkCredentials(user);
    }
}
