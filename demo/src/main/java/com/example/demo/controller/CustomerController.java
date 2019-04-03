package com.example.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.calculate;

import java.util.HashMap;

@RestController
public class CustomerController {
    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }

    @RequestMapping("/calculate/{line}")
    public String calOnline(@PathVariable("line") String line) {
        calculate c = new calculate();
        return line + " = " + c.cal(line);
    }
}