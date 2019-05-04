package com.ketianya.cal.controller;

import com.ketianya.cal.service.calculate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
public class DirectController {
    private calculate c = new calculate();
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "Hello World";
    }
    @RequestMapping(value = "postCal", method = RequestMethod.POST)
    public String postCal(HttpServletRequest request) {
        String line = request.getParameter("line");
        System.out.println(line);
        String result = c.cal(line);
        return result;
    }
}
