package com.securevault.websecurevault;

public interface ModelInterface {
    public String[] getItems() throws ExceptionMVVM;
    public void addItem(String text) throws ExceptionMVVM;
    public void deleteItem() throws ExceptionMVVM;

}
