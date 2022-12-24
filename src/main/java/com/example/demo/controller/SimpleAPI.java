package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

class Data{
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}

@Controller
public class SimpleAPI {
    @GetMapping("simple-api")
    @ResponseBody
    public String simpleAPI(@RequestParam("name") String name) {
        return "hello" + name;
    }

    @GetMapping("simple-json-api")
    @ResponseBody
    public Data simpleGetData(@RequestParam("data") String data) {
        Data d = new Data();
        d.setData(data);
        return d;
    }
}
