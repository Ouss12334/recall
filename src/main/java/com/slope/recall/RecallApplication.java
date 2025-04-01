package com.slope.recall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync // async for background tasks
@EnableScheduling
@SpringBootApplication
public class RecallApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecallApplication.class, args);
	}

}
