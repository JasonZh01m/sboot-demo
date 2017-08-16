package com.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JasonZh on 2017/8/16.
 */
@Controller
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

    @RequestMapping("/")
    public String index(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("host", "http://blog.didispace.com");
        // return模板文件的名称，对应src/main/resources/templates/index.html
        return "index";
    }

    @RequestMapping("/showerrors")
    public String hello() throws Exception {
        throw new Exception("发生错误");
    }

}
