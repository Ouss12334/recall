package com.slope.recall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
// final class restricts inheritence
public final class KafkaScheduledSenderService implements IScheduledSealedService {

    @Autowired
    private IKafkaCombinedService kafkaProducerService;

    @PostConstruct
    void logPostConstruct() {
        log.debug("kafka scheduler service started");
    }

    @Scheduled(cron = "0 0 12-19 * * MON-FRI")
    public void reportBreakTime() {
        log.info("time to take a break !!!!");
    }

    @Scheduled(cron = "0 */10 9-12,14-18 * * MON-FRI")
    public void sendMessage() {
        kafkaProducerService.sendMessage("hello from scheduled task");
    }

}
