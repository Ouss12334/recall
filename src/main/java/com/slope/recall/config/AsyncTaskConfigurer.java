package com.slope.recall.config;

import java.util.concurrent.Executor;
import org.springframework.boot.task.ThreadPoolTaskExecutorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AsyncTaskConfigurer {

    @Bean
    Executor executorConfiguration() { 
        return new ThreadPoolTaskExecutorBuilder()
            .threadNamePrefix("GitHubThread-")
            .corePoolSize(2)
            .maxPoolSize(2)
            .queueCapacity(100)
            .build();
    }
}
