package com.example.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JasonZh on 2017/8/16.
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }

    @RequestMapping(value = "/userinfo", method = RequestMethod.GET)
    public Map<String, String> getmap() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("id", "zhouxh");
        map.put("name", "周兴怀");
        map.put("mail", "zhouxh@digiwin.com");
        return map;
    }

}
