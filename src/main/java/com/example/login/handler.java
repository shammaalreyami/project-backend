package com.example.login;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@RestController
public class handler {
	
	@GetMapping("/movies")
	public ArrayList<Movie> returnAllmovies(){
		controller2 ctrl = new controller2();
		return ctrl.getAllmovies();
}
	@PostMapping(value="/movies/showingnow", consumes="application/json", produces ="application/json")
	public Map<String,String> Insertmovies(@RequestBody Movie movie) {
		
		Map<String,String> map = new HashMap();
		controller2 ctrl = new controller2();
		boolean added = ctrl.insertMovie(movie);
		if(added) map.put("message", "Movie Was Added Successfully");
		else map.put("message", "Error");
		return map;
		
	}
	
	@SuppressWarnings("deprecation")
	@Bean
		public WebMvcConfigurer corsConfigurer() {
			return new WebMvcConfigurerAdapter() {
				@Override
				public void addCorsMappings(CorsRegistry registry) {
					registry.addMapping("/**").allowedOrigins("*");
				}
			};
		}
	
	@GetMapping("/movie/{Idmovie}")
	public Movie returnMovie(@PathVariable("Idmovie") String movie) {
	controller2 ctrl = new controller2();
		return ctrl.getMovie(movie);
	}

}


