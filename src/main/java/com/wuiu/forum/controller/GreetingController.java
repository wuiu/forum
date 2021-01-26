package com.wuiu.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @GetMapping("/hello")
    public String greeting(@RequestParam(name = "username",required = false,defaultValue = "hello") String username, Model model){
        model.addAttribute("username",username);
        return "index";
    }
    @GetMapping("/")
    public String index(){
        return "index";
    }
}

