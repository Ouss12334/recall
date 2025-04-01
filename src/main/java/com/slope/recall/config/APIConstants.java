package com.slope.recall.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "external-apis")
@Data
public class APIConstants {
    // async git
    // @Value("${github-user-url}") // cannot autowire when used
    private String githubUserUrl;
}
