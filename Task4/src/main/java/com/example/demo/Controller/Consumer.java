package com.example.demo.Controller;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.Entity.Container;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/task4")
public class Consumer {
    @ResponseBody
    @RequestMapping(value = "/consume", method = RequestMethod.GET)
    public JSONObject consume() {
        JSONObject result = new JSONObject();
        if (Container.isEmpty()) {
            result.put("msg", "consume an item fail, container is empty");
            result.put("container",null);
        } else {
            result.put("msg", "consume an item");
            result.put("container",Container.consume());
        }

        return result;
    }
}
