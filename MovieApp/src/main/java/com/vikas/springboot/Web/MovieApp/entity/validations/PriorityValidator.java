package com.vikas.springboot.Web.MovieApp.entity.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PriorityValidator implements ConstraintValidator<PriorityAnnotation, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		return value.trim().length() == 1 && "LHM".contains(value.trim());
	}

}
