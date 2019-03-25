package com.garnizon.pim.holidays.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.garnizon.pim.exception.HolidayApiAccessException;
import com.garnizon.pim.holidays.Holiday;
import com.garnizon.pim.holidays.dto.ApiResponseDTO;

/**
 * Calls Holiday API web service, active when 
 * holidays.api.mock flag is set to false
 * 
 * @author jerzy.oleksa@gmail.com
 *
 */
@Repository("holidayDAO")
@ConditionalOnProperty(name = "holidays.api.mock", havingValue = "false")
public class HolidayDAORestImpl implements HolidayDAO {
    
	@Value("${holidays.api.key}")
	private String apiKey;
	
	@Value("${holidays.api.url}")
	private String url;
	
	@Autowired
	private RestTemplate restTemplate;	
	
	public List<Holiday> get(String date, String country) {
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
				.queryParam("day", date.split("-")[2])
				.queryParam("month", date.split("-")[1])
				.queryParam("year", date.split("-")[0])
				.queryParam("country", country)
				.queryParam("upcoming", true)
				.queryParam("key", apiKey);		
		
		ApiResponseDTO respDTO = null;
		
		//need to translate the exception, 
		//to promote the Holiday API error message to top
		try {
			
			respDTO = restTemplate.getForObject(builder.toUriString(), ApiResponseDTO.class);
		
		} catch (HttpClientErrorException e) {			
			throw new HolidayApiAccessException(e.getResponseBodyAsString());
		}
		
		return respDTO.getHolidays();
	}
	
	
}
