package com.ck.sample.spring_kafka_groovy.interceptor;

import com.ck.sample.spring_kafka_groovy.service.KafkaEventLoggerService;
import lombok.NoArgsConstructor;
import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@NoArgsConstructor
public class KafkaProducerInterceptor implements ProducerInterceptor<String, String> {

    private KafkaEventLoggerService eventLoggerService;

    @Autowired
    public KafkaProducerInterceptor(KafkaEventLoggerService eventLoggerService) {
        this.eventLoggerService = eventLoggerService;
    }

    @Override
    public ProducerRecord<String, String> onSend(ProducerRecord<String, String> record) {
        if (eventLoggerService != null) {
            eventLoggerService.logEvent(record.topic(), record.value());
        }
        return record;
    }

    @Override
    public void onAcknowledgement(RecordMetadata metadata, Exception exception) {
        // Optionally handle acknowledgements or exceptions
    }

    @Override
    public void close() {
        // Optionally clean up resources
    }

    @Override
    public void configure(Map<String, ?> configs) {
        // Not needed when using Spring's DI
    }
}
