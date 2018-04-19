package com.rafael.cr.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.rafael.cr.swagger.configuration.EnableSwagger2Configuration;

@EnableSwagger2Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@SpringBootApplication
@ComponentScan("com.rafael.cr")
public class AopApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopApplication.class, args);
	}
}
