package com.slope.recall.config;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.slope.recall.data.GitHubUser;
import com.slope.recall.interfaces.IGitServiceWithGenerics;

import lombok.extern.slf4j.Slf4j;

/**
 * test async with github
 */
@Slf4j
@Configuration
public class GitHubAsyncRunChecker {

    @Bean
    CommandLineRunner getUsers(IGitServiceWithGenerics githubService) {
        return (args) -> {
            long startTime = System.currentTimeMillis();

            CompletableFuture<GitHubUser> myUser = githubService.findUser("ouss12334");
            CompletableFuture<GitHubUser> springOrg = githubService.findUser("Spring-Projects");
            CompletableFuture<GitHubUser> randomPythonDev = githubService.findUser("emilk");
            // CompletableFuture<GitHubUser> notReal = githubService.findUser("shouldbe404");
            
            // wait all to be done
            CompletableFuture.allOf(myUser, springOrg, randomPythonDev/*, notReal*/).join();

            log.info("Elapsed time {}", System.currentTimeMillis() - startTime);
            log.info(myUser.get().toString());
            log.info(springOrg.get().toString());
            log.info(randomPythonDev.get().toString());
        };
    }

}
