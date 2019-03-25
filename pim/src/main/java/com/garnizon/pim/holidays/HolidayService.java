package com.garnizon.pim.holidays;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.garnizon.pim.holidays.dao.HolidayDAO;
import com.garnizon.pim.holidays.dto.HolidayCombinedDTO;
import com.garnizon.pim.holidays.dto.HolidayCriteriaDTO;;

/**
 * Contains business logic for processing holidays data into
 * required form
 * 
 * @author jerzy.oleksa@gmail.com
 *
 */
@Service
public class HolidayService { 
	
	@Autowired
	private HolidayDAO holidayDAO;	
	
	/**
	 * combines dao calls in order to satisfy the required holiday data set
	 * @param crit
	 * @return holidayCriteriaDTO
	 */
	public HolidayCombinedDTO getByCountries(HolidayCriteriaDTO crit) {
		List<Holiday> holidsCntry1 = holidayDAO.get(crit.getDate(), crit.getCountryCode1());		
		List<Holiday> holidsCntry2 = holidayDAO.get(crit.getDate(), crit.getCountryCode2());		
		
		String name1 = (holidsCntry1 != null && holidsCntry1.size() > 0) ? holidsCntry1.get(0).getName() : "";
		String name2 = (holidsCntry2 != null && holidsCntry2.size() > 0) ? holidsCntry1.get(0).getName() : "";
		
		return new HolidayCombinedDTO(crit.getDate(), name1, name2);
	}
	
}
