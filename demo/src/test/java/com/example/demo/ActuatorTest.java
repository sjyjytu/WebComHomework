package com.example.demo;

import com.example.demo.service.calculate;
import static org.junit.Assert.*;
import com.example.demo.controller.DirectController;
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
public class ActuatorTest {
    private MockMvc mvc;
    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new DirectController()).build();
    }
    @Test
    public void info() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/actuator/info").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hello World"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void health() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/actuator/health").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hello World"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void conditions() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/actuator/conditions").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hello World"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void beans() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/actuator/beans").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hello World"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
}
