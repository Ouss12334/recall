package com.slope.recall.service;

public sealed interface IScheduledSealedService permits KafkaScheduledSenderService {

    void reportBreakTime();

    void sendMessage();
}
