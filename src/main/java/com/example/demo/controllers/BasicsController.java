package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BasicsController {

    @RequestMapping("/")
    public String goHome() {
        return "home";
    }
}