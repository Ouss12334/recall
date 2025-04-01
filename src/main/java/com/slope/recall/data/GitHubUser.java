package com.slope.recall.data;

import java.time.LocalDateTime;

// eg https://api.github.com/users/ouss12334
public record GitHubUser(String name, String avatarUrl, LocalDateTime createdAt, long followers, long publicRepos, boolean siteAdmin, String type) {

}
