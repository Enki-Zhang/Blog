package com.enki;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Enki
 * @ClassName Application
 * @Description: TODO
 * @Date 2023/9/20 13:57
 * @Version 1.0
 */
@SpringBootApplication
@MapperScan("com.enki.mapper")
@EnableScheduling
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}