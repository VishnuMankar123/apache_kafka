package com.deliveryboy.service;

import com.deliveryboy.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public boolean updateLocation(String location) {
        System.out.println("Sending location update to Kafka: " + location);
        this.kafkaTemplate.send(AppConstant.LOCATION_UPDATE_TOPIC, location);
        return true; // Assume the message was sent successfully
    }


}
