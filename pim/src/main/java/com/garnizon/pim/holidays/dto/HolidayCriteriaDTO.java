package com.garnizon.pim.holidays.dto;

import com.garnizon.pim.validator.CountryCodeConstraint;
import com.garnizon.pim.validator.DateFormatConstraint;

public class HolidayCriteriaDTO {
	
	@DateFormatConstraint(dateFormat="YYYY-MM-DD")
	private String date = null;
	
	@CountryCodeConstraint
	private String countryCode1 = null;
	
	@CountryCodeConstraint
	private String countryCode2 = null;
	
	public HolidayCriteriaDTO() {}

	public HolidayCriteriaDTO(String date, String countryCode1, String countryCode2) {
		super();
		this.date = date;
		this.countryCode1 = countryCode1;
		this.countryCode2 = countryCode2;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCountryCode1() {
		return countryCode1;
	}
	public void setCountryCode1(String countryCode1) {
		this.countryCode1 = countryCode1;
	}
	public String getCountryCode2() {
		return countryCode2;
	}
	public void setCountryCode2(String countryCode2) {
		this.countryCode2 = countryCode2;
	}
	
	
	
}
