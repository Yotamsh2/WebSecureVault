package com.securevault.websecurevault;

/**Model class is used to implement the ModelInterface methods.
 * It implements three methods that responsible for the connection with the Derby Database.*/
public class ModelDerbyDB implements ModelInterface {

    /**getItem is returning the item we wish to get from the database.*/
    @Override
    public String[] getItems() {
        return new String[] {"clean room ","feed dog ","feed fish"};
        // TODO Auto-generated method stub

    }

    /**addItem is adding the item we wish to add to the database.
     * It has no return value*/
    @Override
    public void addItem(String text) throws ExceptionMVVM {
        // TODO Auto-generated method stub

    }

    /**deleteItem is deleting the item we wish to delete from the database.
     * It has no return value*/
    @Override
    public void deleteItem() throws ExceptionMVVM {
        // TODO Auto-generated method stub

    }

}
