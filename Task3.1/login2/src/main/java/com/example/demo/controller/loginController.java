package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class loginController {
    @RequestMapping(value = "/Hello", method = RequestMethod.GET)
    public String hello() {
        return "Hello";
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam String username,@RequestParam String password) {
        if (username.equals("yjy") && password.equals("good")) {
            return "ok";
        } else {
            return "fail";
        }
    }
}