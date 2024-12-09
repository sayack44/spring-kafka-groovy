package com.ck.sample.spring_kafka_groovy.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class KafkaEvent {
    String content;
    String topicName;
}
