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
public class resthandler {
	
	@GetMapping("/users")
	public ArrayList<User> returnAllusers(){
		controller ctrl = new controller();
		return ctrl.getAllusers();
}
	@PostMapping(value="/users/register", consumes="application/json", produces ="application/json")
	public Map<String,String> InsertUser(@RequestBody User user) {
		
		Map<String,String> map = new HashMap();
		controller ctrl = new controller();
		boolean added = ctrl.insertUser(user);
		if(added) map.put("message", "User Was Added Successfully");
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
	
	@GetMapping("/user/{Username}")
	public User returnUser(@PathVariable("Username") String username) {
	controller ctrl = new controller();
		return ctrl.getUser(username);
	}

}


