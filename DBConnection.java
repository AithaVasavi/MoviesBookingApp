package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	public static Connection getConnection() { 
		String url="jdbc:mysql://localhost:3306/movie_booking";
		String username="root";
		String password="Vasavi@111";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn=DriverManager.getConnection(url,username,password);
			
			System.out.println("Connection Established");
			return conn;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
