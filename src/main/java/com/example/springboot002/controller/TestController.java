package com.example.springboot002.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestController {
    @GetMapping("/xxx")
    public String test(){
        System.out.println("操尼玛");
        return "DJJ";
    }
}
