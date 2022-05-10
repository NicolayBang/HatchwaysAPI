package com.example.hatchwaysapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class HatchwaysApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(HatchwaysApiApplication.class, args);
    }

}
