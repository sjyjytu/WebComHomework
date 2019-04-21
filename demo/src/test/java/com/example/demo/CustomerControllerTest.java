package com.example.demo;

import com.example.demo.service.calculate;
import static org.junit.Assert.*;
import com.example.demo.controller.DirectController;
import org.junit.Before;
import org.junit.Ignore;
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
        mvc = MockMvcBuilders.standaloneSetup(new DirectController()).build();
    }

    @Test
    public void getHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hello World"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void info() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/info").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hello World"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void getCalResultOnline() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/calculate/(1+1)*2-3").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("(1+1)*2-3 = 1.0000"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void getCalResultOnline2() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/calculate").accept(MediaType.APPLICATION_JSON).param("line","32*-13.6"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("32*-13.6 = -435.2000"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
    @Test
    public void getCalResultOnline3() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/calculate").accept(MediaType.APPLICATION_JSON).param("line","(18.2*3.34)/(2.4-3)+23.567*1.2"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("(18.2*3.34)/(2.4-3)+23.567*1.2 = -73.0330"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
}
