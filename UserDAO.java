package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.Movie;
import com.model.User;
import com.util.DBConnection;

public class UserDAO {

	public static void registerUser(User user) {
        
        try {
            Connection conn = DBConnection.getConnection(); // method we’ll add
            
            
            PreparedStatement ps = conn.prepareStatement("insert into users (name,email,password) values(?,?,?)");
            
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            

            int rows = ps.executeUpdate();
            System.out.println(rows + " rows affected ");

            conn.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	
	public static User validateUser(String email, String password) {
	    User user = null;

	    try {
	        Connection conn = DBConnection.getConnection();

	        PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE email=? AND password=?");
	        ps.setString(1, email);
	        ps.setString(2, password);

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            user = new User();
	            user.setId(rs.getInt("id"));
	            user.setName(rs.getString("name"));
	            user.setEmail(rs.getString("email"));
	            user.setPassword(rs.getString("password"));
	            user.setRole(rs.getString("role"));

	        }

	        rs.close();
	        ps.close();
	        conn.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return user;
	}

	
	public static boolean updateUserCredentials(int userId, String newUsername, String newPassword) {
	    boolean success = false;
	    Connection conn = null;
	    PreparedStatement ps = null;

	    try {
	        conn = DBConnection.getConnection();
	        String query = "UPDATE users SET name = ?, password = ? WHERE id = ?";
	        ps = conn.prepareStatement(query);
	        ps.setString(1, newUsername);
	        ps.setString(2, newPassword);
	        ps.setInt(3, userId);

	        int rows = ps.executeUpdate();
	        success = rows > 0;
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (ps != null) ps.close();
	            if (conn != null) conn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    return success;
	}
}
