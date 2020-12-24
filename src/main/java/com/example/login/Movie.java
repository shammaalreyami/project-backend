package com.example.login;

public class Movie{


	private String idmovie;
	private String director;
	private String main;
	private String genre;
	private String year;
	private String overview;
	private String timing;



	public Movie(String idmovie, String director, String main, String genre, String year, String overview,
			String timing) {
		super();
		this.idmovie = idmovie;
		this.director = director;
		this.main = main;
		this.genre = genre;
		this.year = year;
		this.overview = overview;
		this.timing = timing;
	}

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getIdmovie() {
		return idmovie;
	}

	public void setIdmovie(String idmovie) {
		this.idmovie = idmovie;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getMain() {
		return main;
	}

	public void setMain(String main) {
		this.main = main;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}
	
	public String getTiming() {
		return timing;
	}

	public void setTiming(String timing) {
		this.timing = timing;
	}


	@Override
	public String toString() {
		return "movie [idmovie=" + idmovie + ", director=" + director + ", main=" + main + ", genre=" + genre + "year=" + year + "overview=" + overview + "timing=" + timing + "]";
	}
	
	
	
}
