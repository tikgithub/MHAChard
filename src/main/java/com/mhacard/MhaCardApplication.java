package com.mhacard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ComponentScan("com.mhacard.*")
@ServletComponentScan
public class MhaCardApplication {

	public static void main(String[] args) {
		SpringApplication.run(MhaCardApplication.class, args);
	}
}
