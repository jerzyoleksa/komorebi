package com.garnizon.pim.holidays;

/**
 * Represents the Holiday API domain object returned by the service,
 * reduced by insignificant properties
 * 
 * @author jerzy.oleksa@gmail.com
 *
 */
public class Holiday {

	private String date = null;
	private String name = null;
	
	public Holiday() {}
	
	public Holiday(String date, String name) {
		super();
		this.date = date;
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Holiday [date=" + date + ", name=" + name + "]";
	}
	

	
	
}
