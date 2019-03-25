package com.garnizon.pim.holidays;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HolidaysControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testCreationOfANewProjectSucceeds() throws Exception {  	
    	this.mockMvc.perform(get("/holidays?date=2016-05-01&countryCode1=PL&countryCode2=FR")).andDo(print())
    	.andExpect(status().isOk())
    	.andExpect(content().string(containsString("date")))
        .andExpect(content().string(containsString("name1")))
        .andExpect(content().string(containsString("name2")));
    }
    
    @Test
    public void testInvalidDate() throws Exception {  	
    	this.mockMvc.perform(get("/holidays?date=2016-CC-01&countryCode1=PL&countryCode2=FR")).andDo(print())
    	.andExpect(status().isBadRequest());
    }
    
    @Test
    public void testInvalidCountryCode() throws Exception {  	
    	this.mockMvc.perform(get("/holidays?date=2016-05-01&countryCode1=XX&countryCode2=FR")).andDo(print())
    	.andExpect(status().isBadRequest());
    }

}