package com.mhacard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ComponentScan("com.mhacard.*")
public class MhaCardApplication {

	public static void main(String[] args) {
		SpringApplication.run(MhaCardApplication.class, args);
	}
}
