package com.example.login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class controller {

	public ArrayList<User> getAllusers(){
		ArrayList<User> users = new ArrayList<User>();
		
		try { 
			Connection con = DatabaseConnection.initializeDatabase();
			Statement stmt = con.createStatement();
			
			String sql = "SELECT * FROM login";
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				String Username = rs.getString("Username");
				String Email = rs.getString("Email");
				String Password = rs.getString("Password");
				String Type = rs.getString("Type");
				
			User user = new User(Username, Email, Password, Type);
			users.add(user);
			}
			con.close();
			
		}catch (Exception e ) { e.printStackTrace(); }
		return users;
					
	}
	
	
	public boolean insertUser(User user ) {
		boolean inserted = false; 
		
		System.out.println(user.toString());
		
		try {
			Connection con = DatabaseConnection.initializeDatabase();
			Statement stmt = con.createStatement();
			String sql = String.format("INSERT INTO login VALUES('%s','%s','%s','%s')", user.getUsername(),user.getEmail(),user.getPassword(),user.getType());
			int result = stmt.executeUpdate(sql);
			
			if(result == 1) inserted = true; 
			con.close();
		} catch (Exception e) { e.printStackTrace(); }
		return inserted; 
			
		
	}

public User getUser(String username) {
	User user = new User();
	
	try {
		
		Connection con = DatabaseConnection.initializeDatabase();	//
		Statement stmt = con.createStatement();	//
		
		String sql = String.format("SELECT * FROM users WHERE username = '%s' ", username);
		ResultSet rs = stmt.executeQuery(sql);	//
		
		System.out.println("this is a sql "+ sql);
		
		while(rs.next()) {
			String uname = rs.getString("Username");
			String email = rs.getString("Email Address");
			String pass = rs.getString("Password");
			String type = rs.getString("Type");
			
			user.setUsername(uname);
			user.setEmail(email);
			user.setPassword(pass);
			user.setType(type);
		}
		
		con.close();
		
	}catch( Exception e) { e.printStackTrace();}
	
	return user;
}

}


