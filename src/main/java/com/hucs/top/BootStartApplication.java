package com.hucs.top;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: huchuansai
 * @Date: 2022/8/8 4:02 PM
 * @Description:
 */
@SpringBootApplication
@MapperScan({"com.ctrod.cvoon.dao"})
public class BootStartApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootStartApplication.class, args);
    }
}
