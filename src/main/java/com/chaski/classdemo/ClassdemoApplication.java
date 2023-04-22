package com.chaski.classdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.chaski.classdemo")
@EnableJpaRepositories("com.chaski.classdemo")
public class ClassdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClassdemoApplication.class, args);
	}
}
