package com.vikas.springboot.Web.MovieApp.entity.validations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;



@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PriorityValidator.class)
public @interface PriorityAnnotation {

	String message() default "Only L, H and M characters allowed";
	
	
	Class<?>[]groups() default{};
	Class<? extends Payload>[] payload() default{};
	
}
