package com.slope.recall.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class KafkaProducer implements CommandLineRunner {

    @Autowired
    KafkaAdmin broker;

    @Override
    public void run(String... args) throws Exception {
        log.info("checking kafka connection");
        log.info("cluster id {}", broker.clusterId());
        // log.info(broker.describeTopics("test-topic").toString());
        log.info("end checking cnx");
    }
}
