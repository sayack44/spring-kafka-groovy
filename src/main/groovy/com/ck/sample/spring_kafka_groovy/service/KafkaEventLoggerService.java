package com.ck.sample.spring_kafka_groovy.service;

import com.ck.sample.spring_kafka_groovy.entity.Event;
import com.ck.sample.spring_kafka_groovy.repository.KafkaEventLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KafkaEventLoggerService {

    private final KafkaEventLogRepository kafkaEventLogRepository;

    @Autowired
    public KafkaEventLoggerService(KafkaEventLogRepository kafkaEventLogRepository) {
        this.kafkaEventLogRepository = kafkaEventLogRepository;
    }

    public void logEvent(String topic, String content) {
        Event eventLog = Event.builder().topicName(topic).content(content).build();
        kafkaEventLogRepository.save(eventLog);
    }
}
