package com.slope.recall.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.slope.recall.data.Hello;
import com.slope.recall.repository.HelloRepository;

@Configuration
public class InitDB {
    @Bean
    private CommandLineRunner initItems(HelloRepository repository) {
        return (args) -> {
            repository.save(Hello.builder().who("guardians of the galaxy").build());
            repository.save(Hello.builder().who("guardians of the galaxy vol. 2").build());
            repository.save(Hello.builder().who("guardians of the galaxy vol. 3").build());
        };
    }
}
