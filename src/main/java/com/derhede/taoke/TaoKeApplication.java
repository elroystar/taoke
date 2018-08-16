package com.derhede.taoke;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

//@EnableScheduling
@SpringBootApplication
@MapperScan(basePackages = "com.derhede.taoke.dao") // 扫描Dao文件
public class TaoKeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaoKeApplication.class, args);
	}
}
