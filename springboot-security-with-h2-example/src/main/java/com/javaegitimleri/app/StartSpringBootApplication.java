package com.javaegitimleri.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@EnableConfigurationProperties(value=PersonelProperties.class)
@ServletComponentScan
public class StartSpringBootApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(StartSpringBootApplication.class, args);
	}
}
