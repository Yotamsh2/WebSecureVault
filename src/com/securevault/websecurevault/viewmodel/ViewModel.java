package com.securevault.websecurevault.viewmodel;

import com.securevault.websecurevault.ObjectTypes.Record;
import com.securevault.websecurevault.model.ModelDerbyDB;

import java.util.ArrayList;
import java.util.Vector;

public class ViewModel implements ViewModelInterface{

    public Vector<Record> getRecordsByCategory(String category){
        ModelDerbyDB model = new ModelDerbyDB();
        return model.getRecords(category);
    }
}
