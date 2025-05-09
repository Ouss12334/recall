package com.slope.recall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slope.recall.data.KafkaMessage;
import com.slope.recall.interfaces.IKafkaCombinedService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired // best on ctor // kept for tests
    private IKafkaCombinedService kafkaProducerService;

    @PostMapping("/send")
    public void send(@RequestBody KafkaMessage message) {
        log.info("instance class {}", kafkaProducerService.getClass().toGenericString());
        kafkaProducerService.sendMessage(message.message());
    }
}
