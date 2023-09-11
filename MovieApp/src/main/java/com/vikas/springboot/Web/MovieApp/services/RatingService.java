package com.vikas.springboot.Web.MovieApp.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class RatingService {

	
	String apiUrl = "http://www.omdbapi.com/?i=tt3896198&apikey=52e7b353&t=";
	
	public String getMovieRating(String title) {
		
		//to call extenal Api we use RestTemplate
		RestTemplate template = new RestTemplate();
		
		try {
			//RestTemplate gives the json Object as response known as ResponseEntity
			ResponseEntity<ObjectNode> response = template.getForEntity(apiUrl + title, ObjectNode.class);
			
			//we can get whole json body from ResponseEntity using getBody
			ObjectNode jsonObject = response.getBody();
			
			//After getBody of json we fetch the specific imdbRating as a path
			return jsonObject.path("imdbRating").asText();
			
		}catch(Exception e) {
				System.out.println("Sorry movie Rating not available"+e.getMessage());
				return null;
		}
	}
	

}
