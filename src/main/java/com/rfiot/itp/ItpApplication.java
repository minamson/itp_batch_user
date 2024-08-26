package com.rfiot.itp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ItpApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItpApplication.class, args);
    }

}
