package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {
    @GetMapping("demo")
    public String demo(Model model) {
        model.addAttribute("data", "Demo!!");
        return "demo";//demo.html 실행시켜라

    }

    @GetMapping("demo-mvc")
    public String demoMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "demo-template";
    }


    @GetMapping("demo-string")
    @ResponseBody
    public String demoString(@RequestParam("name") String name) {
        return "demo :" + name;
    }

    @GetMapping("demo-api")
    @ResponseBody
    public Demo demoApi(@RequestParam("name") String name){
        Demo demo = new Demo();
        demo.setName(name);
        return demo;
    }

    static class Demo {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


}
