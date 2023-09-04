package com.zjud;

import com.zjud.config.JacksonCustomizer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/8/27 13:46
 * @description
 */
@SpringBootApplication
@MapperScan("com.zjud.mapper")
@EnableScheduling
public class ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class);
    }

}
