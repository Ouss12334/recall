package com.slope.recall.service;

import java.net.URI;
import java.util.concurrent.CompletableFuture;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.slope.recall.config.APIConstants;
import com.slope.recall.data.GitHubUser;
import com.slope.recall.interfaces.IGitServiceWithGenerics;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class GitHubService implements IGitServiceWithGenerics {

    private final RestTemplate restTemplate;
    private APIConstants apiConstants;

    public GitHubService(RestTemplateBuilder builder, APIConstants apiConstants) {
        restTemplate = builder.build();
        this.apiConstants = apiConstants;
    }

    @SuppressWarnings("unchecked")
    public CompletableFuture<GitHubUser> findUser(String username) throws InterruptedException {
        log.info("fetching github user '{}' with 2s delay", username);
        var result = restTemplate.getForObject(URI.create(apiConstants.getGithubUserUrl().concat(username)),
                GitHubUser.class);
        Thread.sleep(2000L); // delay for proof of concept
        return CompletableFuture.completedFuture(result);
    }

    @Override // custom tostring method
    public String toString() {
        return "GitHubService [getClass()=" + getClass() + "]";
    }

}
