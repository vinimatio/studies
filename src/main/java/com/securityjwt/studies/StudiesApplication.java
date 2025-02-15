package com.securityjwt.studies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.securityjwt.studies.config.JwtProperties;

@SpringBootApplication
@EnableConfigurationProperties(JwtProperties.class)
public class StudiesApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudiesApplication.class, args);

	}

}
