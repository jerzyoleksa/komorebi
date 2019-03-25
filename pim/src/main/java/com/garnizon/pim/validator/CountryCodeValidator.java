package com.garnizon.pim.validator;

import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Value;

public class CountryCodeValidator implements ConstraintValidator<CountryCodeConstraint, String> {
	
	@Value("#{'${holidays.api.codes}'.split(',')}") 
	private List<String> allowedCountryCodes;

	@Override
	public boolean isValid(String value, ConstraintValidatorContext cxt) {	
		if (allowedCountryCodes.contains(value)) return true;
		return false;
	}

}

