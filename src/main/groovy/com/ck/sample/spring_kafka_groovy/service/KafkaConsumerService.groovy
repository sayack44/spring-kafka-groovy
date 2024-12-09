package com.ck.sample.spring_kafka_groovy.service


import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class KafkaConsumerService {

    @KafkaListener(topics = "my-topic", groupId = "my-group")
    void listen(String message) {
        println "Message saved to database"  + message
    }
}
