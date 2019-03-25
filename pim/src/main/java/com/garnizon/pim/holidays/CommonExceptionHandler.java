package com.garnizon.pim.holidays;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.garnizon.pim.exception.HolidayApiAccessException;
import com.garnizon.pim.holidays.dto.ErrorDTO;

/**
 * Provides the exception handling across the controllers layer
 * 
 * @author jerzy.oleksa@gmail.com
 *
 */
@ControllerAdvice
public class CommonExceptionHandler {

	@ExceptionHandler({BindException.class})
	@ResponseStatus(BAD_REQUEST)
    @ResponseBody
    public ErrorDTO handleException(BindException ex) {
	   List<String> errors = ex.getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());	
       return new ErrorDTO(BAD_REQUEST.toString(), errors);
    }
	
	@ExceptionHandler({HolidayApiAccessException.class})
	@ResponseStatus(BAD_REQUEST)
    @ResponseBody
    public ErrorDTO handleException(HolidayApiAccessException ex) {
	   return new ErrorDTO(ex.getMessage(), new ArrayList<String>());
    }
	
	@ExceptionHandler({Exception.class})
	@ResponseStatus(INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorDTO handleException(Exception ex) {
	   return new ErrorDTO(ex.getMessage(), new ArrayList<String>());
    }
}