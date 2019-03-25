package com.garnizon.pim.holidays.dto;

import java.util.List;
import com.garnizon.pim.holidays.Holiday;

public class ApiResponseDTO {
	
	private String status;
	private List<Holiday> holidays;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<Holiday> getHolidays() {
		return holidays;
	}
	public void setHolidays(List<Holiday> holidays) {
		this.holidays = holidays;
	}
	
	
}
