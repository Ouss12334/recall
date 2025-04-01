package com.slope.recall.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.Name;
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
