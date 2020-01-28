package com.securevault.websecurevault;

import java.sql.*;

/**DBConnection class creates connection with the database so we can add, delete or get data from it.
 * Also in case the derby database not created yet - it creates the DB and a table. */
public class DBConnection {

	/**Determine the requested driver and the jdbc protocol*/
	public static String driver = "org.apache.derby.jdbc.EmbeddedDriver";
	public static String protocol = "jdbc:derby:secureVaultDB;create=true";

	/**Constructor initialize the references of: connection, statement and
	 * resultSet(which hold the lines we ask to get from the DB) */
	public DBConnection() {
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;

		try
		{
		/**Instantiating the driver class will indirectly register this driver as an available driver for DriverManager*/
		 Class.forName(driver);

			//Getting a connection by calling getConnection
		connection = DriverManager.getConnection(protocol);
		statement = connection.createStatement();
		statement.execute("create table inventory(id int, fee double)");
		statement.executeUpdate("insert into inventory values (100215,2.5)");
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
