package com.garnizon.pim.holidays;

import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import com.garnizon.pim.holidays.dao.HolidayDAO;

@TestPropertySource(locations="classpath:test.properties")
@RunWith(SpringRunner.class)
@SpringBootTest
public class HolidaysDAOTest {
   
    @Autowired
    private HolidayDAO dao;

    @Test
    public void testGet() throws Exception {
    	List<Holiday> list = dao.get("2016-03-08","FR");   	
    	assertTrue(list != null && list.size() > 0);
    	assertTrue(list.get(0).getName().equals("Wielkanoc"));
    }

}