package com.garnizon.pim.holidays;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.garnizon.pim.holidays.dto.HolidayCombinedDTO;
import com.garnizon.pim.holidays.dto.HolidayCriteriaDTO;

/**
 * Exposes Holiday business logic as a RESTful web service
 * @author jerzy.oleksa@gmail.com
 *
 */
@RestController
public class HolidayController {
	
	@Autowired
	private HolidayService holidayService;
	
    @RequestMapping("/holidays")
    public HolidayCombinedDTO holidays(@Valid HolidayCriteriaDTO criteria) {   	
        return holidayService.getByCountries(criteria);
    }

}
