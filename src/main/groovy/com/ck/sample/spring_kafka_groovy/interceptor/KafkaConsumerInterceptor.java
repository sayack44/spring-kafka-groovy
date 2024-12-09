package com.ck.sample.spring_kafka_groovy.interceptor;

import com.ck.sample.spring_kafka_groovy.service.KafkaEventLoggerService;
import lombok.NoArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerInterceptor;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@NoArgsConstructor
public class KafkaConsumerInterceptor implements ConsumerInterceptor<String, String> {

    private KafkaEventLoggerService eventLoggerService;

    @Autowired
    public KafkaConsumerInterceptor(KafkaEventLoggerService eventLoggerService) {
        this.eventLoggerService = eventLoggerService;
    }

    @Override
    public ConsumerRecords<String, String> onConsume(ConsumerRecords<String, String> records) {
        records.forEach(record -> {
            if (eventLoggerService != null) {
                eventLoggerService.logEvent(record.topic(), record.value());
            }
        });
        return records;
    }

    @Override
    public void close() {}

    @Override
    public void onCommit(Map<TopicPartition, OffsetAndMetadata> offsets) {}

    @Override
    public void configure(Map<String, ?> configs) {
        this.eventLoggerService = (KafkaEventLoggerService) configs.get("eventLoggerService");
    }
}

