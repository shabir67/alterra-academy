package com.Configure.SwaggerApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.Configure.SwaggerApi")
public class SwaggerApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(SwaggerApiApplication.class, args);
	}
}
