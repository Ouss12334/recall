package com.slope.recall.config;

import java.util.concurrent.CompletableFuture;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.slope.recall.data.GitHubUser;
import com.slope.recall.interfaces.IGitServiceWithGenerics;
import com.slope.recall.interfaces.PrefixGitName;

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

            // implementing and using functional interface
            PrefixGitName prefixer = (name) -> {
                return "github-".concat(name);
            };

            var gitMyUser = myUser.get();
            var gitSpringOrg = springOrg.get();
            var gitEmilk = randomPythonDev.get();
            // log response + transformation with functional interface
            log.info("Elapsed time {}", System.currentTimeMillis() - startTime);
            log.info("transformed name {}, {}", prefixer.transform(gitMyUser.name()), gitMyUser.toString());
            log.info("transformed name {}, {}", prefixer.transform(gitSpringOrg.name()), gitSpringOrg.toString());
            log.info("transformed name {}, {}", prefixer.transform(gitEmilk.name()), gitEmilk.toString());
        };
    }

}
