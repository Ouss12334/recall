package com.slope.recall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.slope.recall.config.Constants;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
// @Qualifier("kafkaProducer")
public class KafkaProducerService implements IKafkaCombinedService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        log.info("sending message to recall topic");
        kafkaTemplate.send(Constants.RECALL_TOPIC_NAME, message);
    }
}
