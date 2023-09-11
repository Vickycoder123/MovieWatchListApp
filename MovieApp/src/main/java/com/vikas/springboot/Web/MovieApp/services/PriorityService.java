package com.vikas.springboot.Web.MovieApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vikas.springboot.Web.MovieApp.entity.Movie;

@Service
public class PriorityService {
    // Your service methods
	
	
	@Autowired
	RatingService ratingService;

    public void setPriorityBasedOnRating(Movie movie) {
        Float rating = Float.parseFloat(ratingService.getMovieRating(movie.getTitle()));
        
        if (rating > 2.0 && rating <= 4.0) {
           movie.setPriority("L");
        } else if (rating >= 4.1 && rating <= 7.5) {
            movie.setPriority("M");
        } else{
            movie.setPriority("H");
        } 	
    }
}
