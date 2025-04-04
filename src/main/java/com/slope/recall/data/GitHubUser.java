package com.slope.recall.data;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.slope.recall.annotations.ValidGitURL;

// eg https://api.github.com/users/ouss12334
// eg 404 https://api.github.com/users/shouldbe404
@JsonIgnoreProperties(ignoreUnknown = true)
public record GitHubUser(String name
    ,@JsonProperty("avatar_url") @ValidGitURL String avatarUrl
    ,@JsonProperty("created_at") LocalDateTime createdAt
    ,long followers
    ,@JsonProperty("public_repos") long publicRepos
    ,@JsonProperty("site_admin") boolean siteAdmin
    ,String type
) {}
