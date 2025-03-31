package com.slope.recall;

import org.apache.kafka.clients.admin.AdminClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RecallApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecallApplication.class, args);
	}

}
