package com.ck.sample.spring_kafka_groovy.config;

import com.ck.sample.spring_kafka_groovy.interceptor.KafkaProducerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class KafkaConfig {

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate(ProducerFactory<String, String> pf, KafkaProducerInterceptor kafkaProducerInterceptor) {
        KafkaTemplate<String, String> kafkaTemplate = new KafkaTemplate<>(pf);
        kafkaTemplate.setProducerInterceptor(kafkaProducerInterceptor);
        return kafkaTemplate;
    }
}
