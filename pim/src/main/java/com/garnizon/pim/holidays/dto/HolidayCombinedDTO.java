package com.garnizon.pim.holidays.dto;

public class HolidayCombinedDTO {

	private String date = null;
	private String name1 = null;
	private String name2 = null;

	public HolidayCombinedDTO() {}

	public HolidayCombinedDTO(String date, String name1, String name2) {
		super();
		this.date = date;
		this.name1 = name1;
		this.name2 = name2;
	}

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getName1() {
		return name1;
	}
	public void setName1(String name1) {
		this.name1 = name1;
	}
	public String getName2() {
		return name2;
	}
	public void setName2(String name2) {
		this.name2 = name2;
	}

	@Override
	public String toString() {
		return "Holidays [date=" + date + ", name1=" + name1 + ", name2=" + name2 + "]";
	}


}




