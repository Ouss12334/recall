package com.slope.recall.service;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import com.slope.recall.config.Constants;
import com.slope.recall.data.RandomWord;
import com.slope.recall.interfaces.IRandomCaller;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RandomCaller implements IRandomCaller {

    private DiscoveryClient discoveryClient;
    private RestClient restClient;

    // uses restclient.builder 
    public RandomCaller(DiscoveryClient discoveryClient, RestClient.Builder restBuilder) {
        this.discoveryClient = discoveryClient;
        this.restClient = restBuilder.build();
    }

    public RandomWord getRandomWord() {
        // only 1 instance up
        ServiceInstance activeInstance = discoveryClient.getInstances("randomizer").getFirst();
        log.info("querying instance {} ", activeInstance.toString());
        // query service
        return restClient.get()
        .uri(activeInstance.getUri() + Constants.WORD_RANDOMIZER_API_URL)
        .retrieve()
        .body(RandomWord.class);
    }

}
