package com.garnizon.pim.holidays.dto;

import java.util.List;

public class ErrorDTO {
	
	private String message;
	private List<String> errors;

	public ErrorDTO(String message, List<String> errors) {
		this.message = message;
		this.errors = errors;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
	
}
