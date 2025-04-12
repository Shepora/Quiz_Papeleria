package com.example.QuizArq21;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "Model")
@EnableJpaRepositories(basePackages = "Repository")
@ComponentScan(basePackages = {
		"Controller",
		"Service",
		"Repository",
		"Model"
})

public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
