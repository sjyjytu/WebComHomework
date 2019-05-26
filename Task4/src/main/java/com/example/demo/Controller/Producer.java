package com.example.demo.Controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.Entity.Container;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/task4")
public class Producer {
    @ResponseBody
    @RequestMapping(value = "/produce", method = RequestMethod.GET)
    public JSONObject prodece() {
        JSONObject result = new JSONObject();
        result.put("msg", "produce an item");
        result.put("container",Container.produce());
        return result;
    }
}
