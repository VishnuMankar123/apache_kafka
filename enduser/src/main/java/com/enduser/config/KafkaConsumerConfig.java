package com.enduser.config;

import com.enduser.constant.AppConstant;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Configuration
public class KafkaConsumerConfig {

    @KafkaListener(topics = AppConstant.LOCATION_UPDATE_TOPIC, groupId = AppConstant.GROUP_ID)
    public void updatedLocation(String location) {
        System.out.println("Received location update from Kafka: " + location);
    }
}
