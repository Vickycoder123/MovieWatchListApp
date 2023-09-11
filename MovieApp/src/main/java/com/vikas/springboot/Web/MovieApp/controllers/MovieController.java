package com.vikas.springboot.Web.MovieApp.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.vikas.springboot.Web.MovieApp.entity.Movie;
import com.vikas.springboot.Web.MovieApp.services.DatabaseService;
import jakarta.validation.Valid;

@RestController
public class MovieController {
	
	@Autowired
	DatabaseService databaseService;
	


	@GetMapping("/watchListItemForm")
	public ModelAndView showWatchListForm(@RequestParam(required = false) Integer id) {
		
		String viewName = "watchListItemForm";
		
		Map<String, Object> model = new HashMap<>();
		
		if(id == null) {
			model.put("watchListItem", new Movie());
		}else {
			model.put("watchListItem", databaseService.getMovieById(id));
		}
		
		return new ModelAndView(viewName,model);
	}
	
//	@GetMapping("/watchListItemForm")
//	public ModelAndView showWatchListForm(@RequestParam(required = false) Integer id) {
//	    String viewName = "watchListItemForm";
//	    
//	    Movie movie = (id != null) ? databaseService.getMovieById(id) : new Movie();
//	    
//	    return new ModelAndView(viewName, "movie", movie); 
//	}
//

	
	@PostMapping("/watchListItemForm")
	public ModelAndView submitWatchListForm(@Valid @ModelAttribute("watchListItem") Movie movie , BindingResult bindingResult) {
		
		
		if(bindingResult.hasErrors()) {
			return new ModelAndView("watchListItemForm");
		}
	
		Integer id = movie.getId();
		
		if(id == null) {
			databaseService.create(movie);
		}else {
			databaseService.updateMovie(movie,id);
		}
		
	
		RedirectView rd = new RedirectView();
		rd.setUrl("/watchlist");
		
		return new ModelAndView(rd);
	}
	
	
	
	@GetMapping("/watchlist")
	public ModelAndView getWatchList() {
		
		String viewName = "watchList";
		
		Map<String, Object> model = new HashMap<>();
		List<Movie> movieList = databaseService.getAllMovies();
		model.put("watchListRows", movieList);
		model.put("noOfMovies", movieList.size());

		return new ModelAndView(viewName, model);	
	}
}
