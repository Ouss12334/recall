package com.slope.recall.data;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.slope.recall.repository.HelloRepository;

@Component
public class InitDB {
    @Bean
    public CommandLineRunner initItems(HelloRepository repository) {
        return (args) -> {
            repository.save(Hello.builder().who("guardians of the galaxy").build());
            repository.save(Hello.builder().who("guardians of the galaxy vol. 2").build());
            repository.save(Hello.builder().who("guardians of the galaxy vol. 3").build());
        };
    }
}
