package com.slope.recall.service;

import java.util.concurrent.ExecutionException;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

import com.slope.recall.interfaces.IBeanFetcherService;
import com.slope.recall.interfaces.IGitServiceWithGenerics;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * fetches beans from context
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class BeanFetcherService implements IBeanFetcherService {

    private final ConfigurableApplicationContext context;

    @PostConstruct // must be in service
    public void getBeanFromContext() throws InterruptedException, ExecutionException { 
        // not ok if using implementing class GitHubService, must use the interface (bean 'gitHubService' could not be injected because it is a JDK dynamic proxy)
        var githubBean = context.getBean(IGitServiceWithGenerics.class);
        log.info("fetched github bean/instance {}", githubBean);
        log.info("using method from fetched bean: {}", githubBean.findUser("nexus").get());
    }
}
