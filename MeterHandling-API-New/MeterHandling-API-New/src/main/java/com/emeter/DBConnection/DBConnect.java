package com.emeter.DBConnection;


import java.sql.*;

public class DBConnect {
	
	public static Connection connect() {
		
	Connection con = null;
	
	try
	{
		
	Class.forName("com.mysql.cj.jdbc.Driver");
	con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3308/meter_handling_db","root", "malshika123");
	//For testing
	System.out.print("Successfully connected");
	}
	
	catch(Exception e)
	{
	e.printStackTrace();
	}
	
	return con;
}
}