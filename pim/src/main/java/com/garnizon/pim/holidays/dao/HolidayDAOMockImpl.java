package com.garnizon.pim.holidays.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;
import com.garnizon.pim.holidays.Holiday;

/**
 * Mock DAO returning dummy data without calling the API service,
 * activated when holidays.api.mock is set to true
 * 
 * @author jerzy.oleksa@gmail.com
 *
 */
@Repository("holidayDAO")
@ConditionalOnProperty(name = "holidays.api.mock", havingValue = "true")
public class HolidayDAOMockImpl implements HolidayDAO {
	
	@Override
	@SuppressWarnings("serial")
	public List<Holiday> get(String date, String country) {
		return new ArrayList<Holiday>() {{add(new Holiday("2019-04-21", "Wielkanoc"));}};
	}
	
}
