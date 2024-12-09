package com.ck.sample.spring_kafka_groovy.repository;

import com.ck.sample.spring_kafka_groovy.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KafkaEventLogRepository extends JpaRepository<Event, Long> {
}

