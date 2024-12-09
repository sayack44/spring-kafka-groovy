package com.ck.sample.spring_kafka_groovy.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class KafkaProducerService {
    @Autowired
    KafkaTemplate<String, String> kafkaTemplate

    void sendMessage(String topic, String message) {
        kafkaTemplate.send(topic, message)
    }
}
