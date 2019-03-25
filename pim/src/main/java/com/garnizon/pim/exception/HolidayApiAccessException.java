package com.garnizon.pim.exception;

import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Custom application exception used to translate 
 * exception events between external and internal web services
 * 
 * @author jerzy.oleksa@gmail.com
 *
 */
public class HolidayApiAccessException extends RuntimeException {

	private static final Logger log = LoggerFactory.getLogger(HolidayApiAccessException.class);
	private static final long serialVersionUID = 1L;
	
	public HolidayApiAccessException() {}

    public HolidayApiAccessException(String responseBodyStr){
    	super(parse(responseBodyStr));
    }
    
    private static String parse(String body) {
        log.debug(body);
    	String errMessage = body;
    	try {
			ObjectMapper mapper = new ObjectMapper();
			HashMap<?, ?> respMap = mapper.readValue(body, HashMap.class);  
			errMessage = "[" + (Integer)respMap.get("status") + "] " + (String)respMap.get("error");
			
		} catch (Exception e) {
			log.error("Error parsing api response body: ", e);
		}
    	
    	return errMessage;
    }

}
