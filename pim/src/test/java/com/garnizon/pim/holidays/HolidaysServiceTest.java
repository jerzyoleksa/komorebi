package com.garnizon.pim.holidays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.garnizon.pim.holidays.dto.HolidayCombinedDTO;
import com.garnizon.pim.holidays.dto.HolidayCriteriaDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HolidaysServiceTest {
   
    @Autowired
    private HolidayService hs;

    @Test
    public void testGetByCountries() throws Exception {
    	HolidayCriteriaDTO criteria = new HolidayCriteriaDTO("2016-03-08","FR","PL");
    	HolidayCombinedDTO holidayComDto = hs.getByCountries(criteria);
    	assertThat(holidayComDto.getDate()).isEqualTo("2016-03-08");
    	assertNotNull(holidayComDto.getName1());
    	assertNotNull(holidayComDto.getName2());
    }

}