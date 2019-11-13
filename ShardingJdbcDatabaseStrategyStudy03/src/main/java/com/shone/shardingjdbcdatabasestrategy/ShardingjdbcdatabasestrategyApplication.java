package com.shone.shardingjdbcdatabasestrategy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.shone.shardingjdbcdatabasestrategy.mapper")
@SpringBootApplication
public class ShardingjdbcdatabasestrategyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingjdbcdatabasestrategyApplication.class, args);
    }

}
