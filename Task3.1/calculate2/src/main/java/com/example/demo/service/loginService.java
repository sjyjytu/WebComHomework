package com.example.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "LOGIN-SERVICE",url = "http://47.103.0.246:1314")
public interface loginService {
    @RequestMapping(value="/login",method = RequestMethod.GET)
    public String login(@RequestParam String username,@RequestParam String password);
}
