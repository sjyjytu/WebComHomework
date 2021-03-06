package com.example.demo.controller;

import com.example.demo.service.calculate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
public class GUIController {
    private calculate c = new calculate();

    @RequestMapping("/gui")
    public String helloHtml(HashMap<String, Object> map) {
        map.put("result", "结果：");
        return "/calGUI";
    }

    @RequestMapping(value = "guiCal", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ADMIN')")
    public String guiCal(HttpServletRequest request, HashMap<String, Object> map) {
        String line = request.getParameter("line");
        System.out.println(line);
        String result = c.cal(line);
        map.put("result", "结果：" + result);
        return "/calGUI";
    }

    @RequestMapping("/login")
    public String login() {
        return "/login";
    }

}