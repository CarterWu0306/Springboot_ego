package com.carter;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@DubboComponentScan
public class EgoManagerApplication extends ServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(EgoManagerApplication.class, args);
    }

}
