package com.vikas.springboot.Web.MovieApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vikas.springboot.Web.MovieApp.entity.Movie;
import com.vikas.springboot.Web.MovieApp.respository.MovieRepo;

@Service
public class DatabaseService {

	@Autowired
	MovieRepo movierepo;
	
	@Autowired
	RatingService ratingService;
	
	@Autowired
	PriorityService priorityService;
	

	public void create(Movie movie) {
	    String rating = ratingService.getMovieRating(movie.getTitle());

	    if (rating != null) {
	        try {
	            float parsedRating = Float.parseFloat(rating);
	            if (parsedRating > 2 && parsedRating <= 10) {
	                movie.setRating(parsedRating);
	                priorityService.setPriorityBasedOnRating(movie);
	            }
	        } catch (Exception e) {
	        	System.out.println("Error occured: "+e.getMessage());
	        }
	    }

	    movierepo.save(movie);
	}


	public List<Movie> getAllMovies() {
		
		return movierepo.findAll();
	}
	
	
	public Movie getMovieById(Integer id) {
		return movierepo.findById(id).get();
	}


	public void updateMovie(Movie movie, Integer id) {
		
		Movie toBeUpdated = getMovieById(id);
		
		toBeUpdated.setTitle(movie.getTitle());
		toBeUpdated.setComment(movie.getComment());
		ratingService.getMovieRating(movie.getTitle());
		priorityService.setPriorityBasedOnRating(movie);
		
		
		movierepo.save(toBeUpdated);
	}
}
