package com.example.demo.controller;

import com.example.demo.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {

    @GetMapping("/test")
    public String getUser(Model model) {
        User user = new User("aa", "b", "web");
        model.addAttribute("user", user);

        String[] id =  {"hello", "world"};
        Map map = new HashMap();
        map.put("id", id);
        model.addAttribute("uparam", map);
        return "test";
    }
}
