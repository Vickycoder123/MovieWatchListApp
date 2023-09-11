package com.vikas.springboot.Web.MovieApp.entity.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RatingValidator implements ConstraintValidator<RatingAnnotation, Float>{

	@Override
	public boolean isValid( Float value, ConstraintValidatorContext context) {
	
		if (value == null) {
            return false; 
        }
        
        return value > 2 && value <= 10;
	}

}
