package com.vikas.springboot.Web.MovieApp.entity;


import com.vikas.springboot.Web.MovieApp.entity.validations.PriorityAnnotation;
import com.vikas.springboot.Web.MovieApp.entity.validations.RatingAnnotation;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Entity
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotBlank(message = "Bhai yeh kya doglapan hai title kon delega !!")
	private String title;
	
	@RatingAnnotation
	private Float rating;
	
	@PriorityAnnotation
	private String priority;
	
	@Size(max = 50, min = 5 ,message = "Comment should be between 5 to 50 characters !!")
	private String comment;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Float getRating() {
		return rating;
	}
	public void setRating(Float rating) {
		this.rating = rating;
	}
	
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	

}
