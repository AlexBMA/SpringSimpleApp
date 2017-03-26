package com.luv2.code.springdemo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraitalidator implements ConstraintValidator<CourseCode, String> {

	private String coursePrefix;

	@Override
	public void initialize(CourseCode theCourseCoude) {
		coursePrefix = theCourseCoude.value();

	}

	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext context) {

		boolean result;
		if (theCode != null) {
			result = theCode.startsWith(coursePrefix);
		} else {
			result = true;
		}

		return result;
	}

}
