package com.slope.recall.data;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// eg https://api.github.com/users/ouss12334
@JsonIgnoreProperties(ignoreUnknown = true)
public record GitHubUser(String name, String avatarUrl, LocalDateTime createdAt, long followers, long publicRepos,
        boolean siteAdmin, String type) {
}
