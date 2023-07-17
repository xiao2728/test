package com.example.springboot002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example"})
public class SpringBoot002Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot002Application.class, args);
    }
}
