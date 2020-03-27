package com.securevault.websecurevault.Tests;

import com.securevault.websecurevault.Utilities.User;
import com.securevault.websecurevault.model.ModelDerbyDB;
import org.junit.*;
import static org.junit.Assert.*;

public class TestModelDerbyDB {

    @Test
    public void test_getRecords()
    {
        System.out.println("test the getRecords() method");

    }

    @Test
    public void test_addRecord()
    {
        System.out.println("test the addRecord() method");

    }

    @Test
    public void test_deleteRecord()
    {
        System.out.println("test the deleteRecord() method");

    }

    @Test
    public void test_insertUser()
    {
        System.out.println("test the insertUser() method");

    }

    @Test
    public void test_updateUserCredentials()
    {
        System.out.println("test the updateUserCredentials() method");

    }

    @Test
    public void testSuccesses_checkCredentials()
    {
        System.out.println("Successes test of the checkCredentials() method");
        ModelDerbyDB modelDerbyDB = new ModelDerbyDB();
        User user = new User();
        user.setUser_id("master");
        user.setMaster_pass("1234");
        assertNotNull(modelDerbyDB.checkCredentials(user).getUser_id());
    }

    @Test
    public void testFail_checkCredentials()
    {
        System.out.println("Fail test of the checkCredentials() method");
        ModelDerbyDB modelDerbyDB = new ModelDerbyDB();
        User user = new User();
        user.setUser_id("notMaster");
        user.setMaster_pass("1234");
        assertNull(modelDerbyDB.checkCredentials(user).getUser_id());
    }

    @Test
    public void test_initialize()
    {
        System.out.println("test the initialize() method");

    }
}
