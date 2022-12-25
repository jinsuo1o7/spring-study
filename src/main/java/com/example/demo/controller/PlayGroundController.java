package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

class SimpleJson {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

@Controller
public class PlayGroundController {
    @GetMapping("static-page")
    public String staticPage() {
        return "static-page";
    }

    @GetMapping("mvc-page")
    public String mvcPage(@RequestParam("data") String data, Model model) {
        model.addAttribute("data", data);
        return "mvc-page";
    }

    @GetMapping("api-request")
    @ResponseBody
    public SimpleJson jsonPage(@RequestParam("name") String name) {
        SimpleJson json = new SimpleJson();
        json.setName(name);
        return json;
    }
}
