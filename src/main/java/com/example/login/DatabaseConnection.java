package com.example.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//import com.sun.jdi.connect.spi.Connection;

public class DatabaseConnection {

	protected static Connection initializeDatabase() throws SQLException, ClassNotFoundException 
	{
		String dbDriver = "com.mysql.cj.jdbc.Driver";
		String dbURL = "jdbc:mysql://localhost:3306/";
		String dbName = "users";
		String dbUsername = "root";
		String dbPassword = "12345678";
		
		Class.forName (dbDriver);
		Connection con = (Connection) DriverManager.getConnection(dbURL + dbName, dbUsername, dbPassword);
		
		return con;
		
	}
}
