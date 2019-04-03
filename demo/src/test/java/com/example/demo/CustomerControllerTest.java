package com.example.demo;

import com.example.demo.service.calculate;
import static org.junit.Assert.*;
import com.example.demo.controller.CustomerController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
    @SpringBootTest
public class CustomerControllerTest {
    private MockMvc mvc;
    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new CustomerController()).build();
    }
    @Test
    public void getHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
    @Test
    public void getCalResultOnline() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/calculate?line=(1+1)*2-3").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
    @Test
    public void getCalResult() throws Exception {
        calculate c = new calculate();
        assertEquals(c.cal("1+1/(1)"),"2.0000");
        assertEquals(c.cal("32*-13.6"),"-435.2000");
        assertEquals(c.cal("(18.2*3.34)/(2.4-3)+23.567*1.2"),"-73.0330");
        assertEquals(c.cal("1+1"),"2.0000");
    }
}
