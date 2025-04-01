package com.slope.recall.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.slope.recall.config.Constants;
import com.slope.recall.interfaces.IKafkaCombinedService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KafkaConsumerService implements IKafkaCombinedService {

    private static int MSG_COUNTER = 1;
    @KafkaListener(topics=Constants.RECALL_TOPIC_NAME)
    public void readMessage(String message) {
        log.info("received message number {} ,msg: '{}'", MSG_COUNTER++, message);
    }
}
