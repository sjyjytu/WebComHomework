package com.example.demo;

import com.example.demo.service.calculate;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {
    @Test
    public void getCalResult() throws Exception {
        calculate c = new calculate();
        assertEquals(c.cal("1+1/(1)"),"2.0000");
        assertEquals(c.cal("32*-13.6"),"-435.2000");
        assertEquals(c.cal("(18.2*3.34)/(2.4-3)+23.567*1.2"),"-73.0330");
        assertEquals(c.cal("2*3*4"),"24.0000");
        assertEquals(c.cal("1+(1+1)"),"3.0000");
        assertEquals(c.cal("12/6+2*8+1"),"19.0000");
    }
}