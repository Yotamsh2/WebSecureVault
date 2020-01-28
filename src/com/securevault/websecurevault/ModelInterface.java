package com.securevault.websecurevault;

/**ModelInterface is an interface which is implements by model classes.
 * It has three methods that can be implement for multiple databases*/

public interface ModelInterface {
    public String[] getItems() throws ExceptionMVVM;
    public void addItem(String text) throws ExceptionMVVM;
    public void deleteItem() throws ExceptionMVVM;

}
