package com.miller.datastructure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class DataStructureApplication {


    public static void main(String[] args) {
        SpringApplication.run(DataStructureApplication.class, args);

        try {
            LocalDateTime localDateTime3 = LocalDateTime.now();
            localDateTime3.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            System.out.println(localDateTime3.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        LocalDateTime now = LocalDateTime.now(ZoneOffset.UTC);
        System.out.println(now);
    }





}
