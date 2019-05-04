package com.example.demo.controller;
import com.example.demo.service.Line;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.calculate;

import java.util.HashMap;

@RestController
public class DirectController {
    private calculate c = new calculate();

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "Hello World";
    }

    @RequestMapping(value = "/bye", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN')")
    public String goodbye() {
        return "Good bye";
    }

    @RequestMapping("/403")
    public String error(){
        return "403";
    }

    @RequestMapping("/calculate/{line}")
    @PreAuthorize("hasRole('ADMIN')")
    public String calOnline(@PathVariable("line") String line) {
        return line + " = " + c.cal(line);
    }

    @RequestMapping("/calculate")
    public String calPost(@RequestParam("line") String line) {
        return line + " = " + c.cal(line);
    }

    @RequestMapping("/calculater")
    public String calPostman(@RequestBody Line line) {
        return line + " = " + c.cal(line.getLine());
    }
}