package com.luv2.code.springdemo.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CourseCodeConstraitalidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention( RetentionPolicy.RUNTIME ) 
public @interface CourseCode {

	
	
	
	// define default course code
	public String value() default "CS";
	
	
	//define default error message
	public String message() default "must start with CS";
	
	//define default groups
	public Class<?>[] groups()  default{};
	
	//define default Payload
	public Class<? extends  Payload>[] payload() default{};
}
