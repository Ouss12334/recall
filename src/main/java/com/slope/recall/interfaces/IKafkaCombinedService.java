package com.slope.recall.interfaces;

// acts as producer and consumer (for testing purposes)

// implemented by producer and consumer and autowired in controller without using @Qualifier but by letting 
// spring automatically map the name based on the implementing class name (KafkaConsumerService,KafkaProducerService)
public interface IKafkaCombinedService {
    default void readMessage(String message) {
        // do nothing here
    }

    default void sendMessage(String message) {
        // do nothing here
    }
}
