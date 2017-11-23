package com.innsolv.resourceserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses = {ResourceServerApp.class})
public class ResourceServerApp {

    public static void main(String[] args) {
        SpringApplication.run(ResourceServerApp.class, args);
    }

}
