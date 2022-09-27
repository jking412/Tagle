package com.jking412.tagle;

import com.jking412.tagle.core.TagleContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class TagleApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(TagleApplication.class, args);
        TagleContext tagleContext = context.getBean(TagleContext.class);
        tagleContext.run();
    }

}
