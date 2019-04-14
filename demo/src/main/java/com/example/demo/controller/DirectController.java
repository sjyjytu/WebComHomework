package com.example.demo.controller;
import com.example.demo.service.Line;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.calculate;

import java.util.HashMap;

@RestController
public class DirectController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('JY')")
    public String index() {
        return "Hello World";
    }

    @RequestMapping("/calculate/{line}")
    public String calOnline(@PathVariable("line") String line) {
        calculate c = new calculate();
        return line + " = " + c.cal(line);
    }

    @RequestMapping("/calculate")
    public String calPost(@RequestParam("line") String line) {
        calculate c = new calculate();
        return line + " = " + c.cal(line);
    }

    @RequestMapping("/calculater")
    public String calPostman(@RequestBody Line line) {
        calculate c = new calculate();
        return line + " = " + c.cal(line.getLine());
    }
}