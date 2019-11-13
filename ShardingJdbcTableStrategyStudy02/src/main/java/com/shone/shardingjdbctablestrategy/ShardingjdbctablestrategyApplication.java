package com.shone.shardingjdbctablestrategy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.shone.shardingjdbctablestrategy.mapper")
@SpringBootApplication
public class ShardingjdbctablestrategyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingjdbctablestrategyApplication.class, args);
    }

}
