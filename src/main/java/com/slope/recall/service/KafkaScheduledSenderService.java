package com.slope.recall.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.slope.recall.interfaces.IKafkaCombinedService;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
// final class restricts inheritence
public final class KafkaScheduledSenderService implements IScheduledSealedService {

    private IKafkaCombinedService kafkaProducerService;
    
    // @Autowired
    // not required if 1 ctor
    public KafkaScheduledSenderService(IKafkaCombinedService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @PostConstruct
    void logPostConstruct() {
        log.debug("kafka scheduler service started");
    }

    @Scheduled(cron = "${scheduled.cron.break-time}")
    public void reportBreakTime() {
        log.info("time to take a break !!!!");
    }

    @Scheduled(cron = "${scheduled.cron.message}")
    public void sendMessage() {
        kafkaProducerService.sendMessage("hello from scheduled task");
    }

}
