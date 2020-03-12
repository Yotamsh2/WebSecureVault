package com.securevault.websecurevault.model;

import com.securevault.websecurevault.ObjectTypes.Record;

import java.sql.ResultSet;
import java.util.ArrayList;

/**ModelInterface is an interface which is implemented by model classes.
 * It has three methods that can be implemented for multiple databases*/

public interface ModelInterface {
    public ArrayList<Record> getRecords(String category) throws ExceptionMVVM;
    public void addRecord(String text) throws ExceptionMVVM;
    public void deleteRecord(int recordId) throws ExceptionMVVM;

}
