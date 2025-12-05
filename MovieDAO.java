package com.dao;

import com.model.Movie;
import com.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO {

    // Method to fetch all movies from the database
	public static List<Movie> getAllMovies() {
	    List<Movie> movies = new ArrayList<>();

	    try {
	        Connection conn = DBConnection.getConnection();
	        PreparedStatement ps = conn.prepareStatement("SELECT * FROM movies");
	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {
	            Movie movie = new Movie();
	            movie.setId(rs.getInt("id"));
	            movie.setTitle(rs.getString("title"));
	            movie.setImageUrl(rs.getString("image_url"));
	            movie.setLanguage(rs.getString("language"));
	            movie.setGenre(rs.getString("genre"));
	            movie.setStatus(rs.getString("status"));
	            movie.setDescription(rs.getString("description"));

	            movies.add(movie);
	        }

	        rs.close();
	        ps.close();
	        conn.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return movies;
	}



    // Method to fetch a movie by its ID
	public static Movie getMovieById(int movieId) {
	    Movie movie = null;
	    try {
	        Connection conn = DBConnection.getConnection();
	        String query = "SELECT * FROM movies WHERE id=?";
	        PreparedStatement ps = conn.prepareStatement(query);
	        ps.setInt(1, movieId);
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            movie = new Movie();
	            movie.setId(rs.getInt("id"));
	            movie.setTitle(rs.getString("title"));
	            movie.setImageUrl(rs.getString("image_url"));
	            movie.setLanguage(rs.getString("language"));
	            movie.setGenre(rs.getString("genre"));
	            movie.setStatus(rs.getString("status"));
	            movie.setDescription(rs.getString("description"));
	        }

	        rs.close();
	        ps.close();
	        conn.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return movie;
	}


    // Method to add a new movie (for Admin use)
	public static boolean addMovie(Movie movie) {
	    boolean success = false;
	    try {
	        Connection conn = DBConnection.getConnection();
	        String query = "INSERT INTO movies (title, image_url, language, genre, status,description) VALUES (?, ?, ?, ?, ?,?)";
	        PreparedStatement ps = conn.prepareStatement(query);
	        ps.setString(1, movie.getTitle());
	        ps.setString(2, movie.getImageUrl());
	        ps.setString(3, movie.getLanguage());
	        ps.setString(4, movie.getGenre());
	        ps.setString(5, movie.getStatus());
	        ps.setString(6, movie.getDescription());

	        int rows = ps.executeUpdate();
	        success = rows > 0;

	        ps.close();
	        conn.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return success;
	}


    // Method to update a movie's details (for Admin use)
	public static boolean updateMovie(Movie movie) {
	    boolean success = false;
	    try {
	        Connection conn = DBConnection.getConnection();
	        String query = "UPDATE movies SET title=?, image_url=?, language=?, genre=?, status=?, description=? WHERE id=?";
	        PreparedStatement ps = conn.prepareStatement(query);
	        ps.setString(1, movie.getTitle());
	        ps.setString(2, movie.getImageUrl());
	        ps.setString(3, movie.getLanguage());
	        ps.setString(4, movie.getGenre());
	        ps.setString(5, movie.getStatus());
	        ps.setString(6, movie.getDescription());
	        ps.setInt(7, movie.getId());

	        int rows = ps.executeUpdate();
	        success = rows > 0;

	        ps.close();
	        conn.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return success;
	}
	
	
	// Method to fetch movies by status (e.g., "now_showing", "upcoming")
	public static List<Movie> getUpcomingMovies() {
	    List<Movie> list = new ArrayList<>();
	    try {
	        Connection conn = DBConnection.getConnection();
	        String query = "SELECT * FROM movies WHERE status = ?";
	        PreparedStatement ps = conn.prepareStatement(query);
	        ps.setString(1, "upcoming");  // use lowercase consistently
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            Movie m = new Movie();
	            m.setId(rs.getInt("id"));
	            m.setTitle(rs.getString("title"));
	            m.setImageUrl(rs.getString("image_url"));
	            m.setLanguage(rs.getString("language"));
	            m.setGenre(rs.getString("genre"));
	            m.setStatus(rs.getString("status"));
	            m.setDescription(rs.getString("description"));
	            list.add(m);
	        }
	        rs.close();
	        ps.close();
	        conn.close();
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return list;
	}





    // Method to delete a movie (for Admin use)
    public static boolean deleteMovie(int movieId) {
        boolean success = false;
        try {
            Connection conn = DBConnection.getConnection();
            String query = "DELETE FROM movies WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, movieId);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                success = true;
            }

            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }
    
    
}
