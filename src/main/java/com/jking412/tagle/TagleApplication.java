package com.jking412.tagle;

import com.jking412.tagle.controller.TagleController;
import com.jking412.tagle.utils.ExcelUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

@SpringBootApplication
public class TagleApplication {

    public static void main(String[] args) {
        SpringApplication.run(TagleApplication.class, args);
        ExcelUtils.InitExcel("Tagle");
        TagleController.startTagle();
    }

}
