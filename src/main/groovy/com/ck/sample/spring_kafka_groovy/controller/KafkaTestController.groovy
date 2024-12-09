package com.ck.sample.spring_kafka_groovy.controller

import com.ck.sample.spring_kafka_groovy.service.KafkaProducerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/kafka")
class KafkaTestController {

    @Autowired
    KafkaProducerService kafkaProducerService

    @PostMapping("/send")
    void sendMessage(@RequestParam("message") String message) {
        kafkaProducerService.sendMessage("my-topic", message)
    }
}
