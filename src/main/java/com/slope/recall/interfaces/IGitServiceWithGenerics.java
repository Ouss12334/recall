package com.slope.recall.interfaces;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;

public interface IGitServiceWithGenerics {

    @Async
    <T extends Object> CompletableFuture<T> findUser(String username) throws InterruptedException;
    
}
