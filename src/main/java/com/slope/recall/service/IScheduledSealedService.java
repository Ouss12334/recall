package com.slope.recall.service;

// sealed must be in the same java package or module if using java modules (not spring boot)
// modules are for packaging as a seperate module
public sealed interface IScheduledSealedService permits KafkaScheduledSenderService {

    void reportBreakTime();

    void sendMessage();
}
