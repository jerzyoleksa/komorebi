package com.garnizon.pim.validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DateFormatValidator implements ConstraintValidator<DateFormatConstraint, String> {

	private String dateFormat;
	
	@Override
	public void initialize(DateFormatConstraint constraint) {
		dateFormat = constraint.dateFormat();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext cxt) {		
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		try {
			sdf.parse(value);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}

}

