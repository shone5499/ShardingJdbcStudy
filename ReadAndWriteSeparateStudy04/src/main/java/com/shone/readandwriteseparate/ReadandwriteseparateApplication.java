package com.shone.readandwriteseparate;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.shone.readandwriteseparate.mapper")
@SpringBootApplication
public class ReadandwriteseparateApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReadandwriteseparateApplication.class, args);
    }

}
