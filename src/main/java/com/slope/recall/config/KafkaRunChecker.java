package com.slope.recall.config;

import java.nio.charset.Charset;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * check if connects to kafka on startup
 */
@Slf4j
@Component
public class KafkaRunChecker implements CommandLineRunner {

    @Autowired
    KafkaAdmin broker;

    public void run(String... args) throws Exception {
        log.info("checking kafka connection");
        log.info("cluster id {}", broker.clusterId());
        // log.info(broker.describeTopics("test-topic").toString());
        log.info("end checking cnx");
        upsertTopic();
    }

    private void upsertTopic() {
        NewTopic recallTopic = TopicBuilder.name(Constants.RECALL_TOPIC_NAME).build();
        broker.createOrModifyTopics(recallTopic);
        log.info("created/updated recall topic");
    }
}
