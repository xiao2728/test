package com.example.springboot002.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;
@Slf4j
@RestController
public class TestController {

    public TestController(){
        System.out.println("xxxx");
    }
    @GetMapping("/xxx")
    public void test(){
        System.out.println("操尼玛");
    }
}
