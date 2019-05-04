package com.example.demo.controller;

import com.example.demo.service.calculate;
import com.example.demo.service.loginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
@RefreshScope
public class DirectController {
    private calculate c = new calculate();
    @Autowired
    private loginService login;
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "Hello World";
    }
    @RequestMapping(value = "postCal", method = RequestMethod.POST)
    public String postCal(HttpServletRequest request) {
        String line = request.getParameter("line");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String loginInfo = login.login(username, password);
        String result;
        if (loginInfo.equals("ok")) {
            result = c.cal(line);
        } else {
            result = "login failed";
        }
        return result;
    }
}
