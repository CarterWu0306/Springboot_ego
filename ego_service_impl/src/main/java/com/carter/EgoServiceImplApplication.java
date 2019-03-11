package com.carter;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.carter.mapper")
@EnableDubboConfig
public class EgoServiceImplApplication {

    public static void main(String[] args) {
        SpringApplication.run(EgoServiceImplApplication.class, args);
    }

}
