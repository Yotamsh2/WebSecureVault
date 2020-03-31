package com.securevault.websecurevault.tests;

import com.securevault.websecurevault.model.ExceptionMVVM;
import com.securevault.websecurevault.utilities.Record;
import com.securevault.websecurevault.utilities.User;
import com.securevault.websecurevault.model.ModelDerbyDB;
import org.junit.*;
import static org.junit.Assert.*;

public class TestModelDerbyDB {
    ModelDerbyDB modelDerbyDB = new ModelDerbyDB();

    @Test
    public void testSuccesses_getRecords()
    {
        System.out.println("Successes test of the getRecords() method");
        User user = new User("master","Yuval","Nir","1234");
        assertFalse(modelDerbyDB.getRecords("Credit Cards", user).isEmpty());
    }

    @Test
    public void testFail_getRecords()
    {
        System.out.println("Fail test of the getRecords() method");
        User user = new User("none","what?","where?","1234");
        assertTrue(modelDerbyDB.getRecords("Credit Cards", user).isEmpty());
    }

    @Test
    public void testSuccesses_addRecord() throws ExceptionMVVM {
        System.out.println("Successes test of the addRecord() method");
        Record record = new Record("Test Note","Notes", "", "", 0, 0, "", "Some note...", 0, 0, "", "", "", 0, "master");
        assertTrue(modelDerbyDB.addRecord(record));
    }

    @Test
    public void testSuccesses_updateUserCredentials()
    {
        System.out.println("Successes test of the updateUserCredentials() method");
        User user = new User("master","Yuval","Nir","1234");
        assertTrue(modelDerbyDB.updateUserCredentials(user));
    }

    @Test
    public void testFail_updateUserCredentials()
    {
        System.out.println("Fail test of the updateUserCredentials() method");
        User user = new User("none","what?","where?","1234");
        assertFalse(modelDerbyDB.updateUserCredentials(user));
    }

    @Test
    public void testSuccesses_checkCredentials()
    {
        System.out.println("Successes test of the checkCredentials() method");
        User user = new User();
        user.setUser_id("master");
        user.setMaster_pass("1234");
        assertNotNull(modelDerbyDB.checkCredentials(user).getUser_id());
    }

    @Test
    public void testFail_checkCredentials()
    {
        System.out.println("Fail test of the checkCredentials() method");
        User user = new User();
        user.setUser_id("notMaster");
        user.setMaster_pass("1234");
        assertNull(modelDerbyDB.checkCredentials(user).getUser_id());
    }
}
