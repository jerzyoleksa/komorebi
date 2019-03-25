package com.garnizon.pim.holidays.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.garnizon.pim.holidays.Holiday;

/**
 * Holiday DAO interface
 * 
 * @author jerzy.oleksa@gmail.com
 *
 */
@Repository
public interface HolidayDAO {

	public List<Holiday> get(String date, String country);
	
}
