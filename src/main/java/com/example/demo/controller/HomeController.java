package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // 컨트롤러에서 /를 지정했으므로 static보다 우선선위로 잡힘
    @GetMapping("/")
    public String home() {
        return "home";
    }
}
