package com.securevault.websecurevault;

import java.sql.*;

public class DBConnection {

	public static String driver = "org.apache.derby.jdbc.EmbeddedDriver";
	public static String protocol = "jdbc:derby:svDB;create=true";
	 
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		
		try
		{
		 connection = null;
		//Instantiating the dirver class will indirectly register
		//this driver as an available driver for DriverManager
		 Class.forName(driver);
		//Getting a connection by calling getConnection
		connection = DriverManager.getConnection(protocol);
		statement = connection.createStatement();
		statement.execute("create table inventory(id int, fee double)");
		statement.executeUpdate("insert into inventory values (100212,2.5)");
		statement.executeUpdate("insert into inventory values (100213,1.2)");
		statement.executeUpdate("insert into inventory values (100214,4.2)");
		rs = statement.executeQuery(
				 "SELECT id,fee FROM inventory ORDER BY id");
		while(rs.next())
		{
				 System.out.println("id="+rs.getInt("id")+" fee="+rs.getDouble("fee"));
		}
				 
		statement.execute("DROP TABLE inventory");
		}
		catch(Exception e) { e.printStackTrace(); }
		finally
		{
				 if(statement!=null) try{statement.close();}catch(Exception e){}
				 if(connection!=null) try{connection.close();}catch(Exception e){}
				 if(rs!=null) try{rs.close();}catch(Exception e){}
		}
	}
}
