package com.ketianya.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class loginController {
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login() {
        return "Hello World";
    }
}
