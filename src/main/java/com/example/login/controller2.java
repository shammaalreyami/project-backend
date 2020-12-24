package com.example.login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class controller2 {

	public ArrayList<Movie> getAllmovies(){
		ArrayList<Movie> movies = new ArrayList<Movie>();
		
		try { 
			Connection con = DatabaseConnection.initializeDatabase();
			Statement stmt = con.createStatement();
			
			String sql = "SELECT * FROM movie";
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				String idmovie = rs.getString("Idmovie");
				String director = rs.getString("Director");
				String main = rs.getString("Main");
				String genre = rs.getString("Genre");
				String year = rs.getString("Year");
				String overview = rs.getString("Overview");
				String timing = rs.getString("Timing");
				
			Movie movie = new Movie(idmovie, director, main, genre, year, overview, timing);
			movies.add(movie);
			}
			con.close();
			
		}catch (Exception e ) { e.printStackTrace(); }
		return movies;
					
	}
	
	
	public boolean insertMovie(Movie movie) {
		boolean inserted = false; 
		
		System.out.println(movie.toString());
		
		try {
			Connection con = DatabaseConnection.initializeDatabase();
			Statement stmt = con.createStatement();
			String sql = String.format("INSERT INTO login VALUES('%s','%s','%s','%s','%s','%s','%s')", movie.getIdmovie(), movie.getDirector(), movie.getMain(), movie.getGenre(), movie.getYear(), movie.getOverview(), movie.getTiming());
			int result = stmt.executeUpdate(sql);
			
			if(result == 1) inserted = true; 
			con.close();
		} catch (Exception e) { e.printStackTrace(); }
		return inserted; 
			
		
	}

public Movie getMovie(String idmovie) {
	Movie movie = new Movie();
	
	try {
		
		Connection con = DatabaseConnection.initializeDatabase();	//
		Statement stmt = con.createStatement();	//
		
		String sql = String.format("SELECT * FROM movie WHERE idmovie = '%s' ", idmovie);
		ResultSet rs = stmt.executeQuery(sql);	//
		
		System.out.println("this is a sql "+ sql);
		
		while(rs.next()) {
			String IDMOVIE = rs.getString("Idmovie");
			String director = rs.getString("Director");
			String main = rs.getString("Main");
			String genre = rs.getString("Genre");
			String year = rs.getString("Year");
			String overview = rs.getString("Overview");
			String timing = rs.getString("Timing");
			
			movie.setIdmovie(IDMOVIE);
			movie.setDirector(director);
			movie.setMain(main);
			movie.setGenre(genre);
			movie.setYear(year);
			movie.setOverview(overview);
			movie.setTiming(timing);
		}
		
		con.close();
		
	}catch( Exception e) { e.printStackTrace();}
	
	return movie;
}

}