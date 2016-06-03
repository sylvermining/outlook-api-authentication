package com.avantica.brainy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * Created by max.macalupu on 31/05/2016.
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer{

    public static void main(String [] args){
        SpringApplication.run(Application.class,args);
    }
}