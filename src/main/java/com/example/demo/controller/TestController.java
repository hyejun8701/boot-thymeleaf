package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class TestController {
    @GetMapping("/{num}")
    public ModelAndView index(@PathVariable int num, ModelAndView mav) {
        mav.setViewName("index");

        mav.addObject("num", num);
        //mav.addObject("check", num % 2 == 0);

        if(num >= 0) {
            mav.addObject("check", "num >= list.size() ? 0 : num");
        } else {
            mav.addObject("check", "num*-1 >= list.size() ? 0 : num*-1");
        }

        mav.addObject("trueVal", "Evan number.");
        mav.addObject("falseVal", "Odd number.");

        ArrayList<Person> list = new ArrayList<Person>();
        list.add(new Person("kim", "kim@a.com"));
        list.add(new Person("lee", "lee@b.com"));
        list.add(new Person("park", "park@c.com"));
        mav.addObject("list", list);

        return mav;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("msg", "<h1>END</h1><br/><h2>END</h2>");
        DataObject data = new DataObject(123, "star");
        model.addAttribute("object", data);
        return "index";
    }

    class DataObject {
        public int id;
        public String name;

        public DataObject(int id, String name) {
            super();
            this.id = id;
            this.name = name;
        }
    }

    class Person {
        public String name;
        public String email;

        public Person(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }
}
