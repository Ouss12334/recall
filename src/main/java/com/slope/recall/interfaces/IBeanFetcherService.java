package com.slope.recall.interfaces;

import java.util.concurrent.ExecutionException;

public interface IBeanFetcherService {

    void getBeanFromContext() throws InterruptedException, ExecutionException ;
}
