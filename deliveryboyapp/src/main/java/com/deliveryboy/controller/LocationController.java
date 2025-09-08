package com.deliveryboy.controller;

import com.deliveryboy.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class LocationController {

    @Autowired
    private KafkaService kafkaService;


    @GetMapping("/")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Location Service is up and running");
    }


    @PostMapping("/update")
    public ResponseEntity<?> updateLocation() {
        for (int i = 0; i < 50; i++) { // 50 messages bhejenge
            // Random location generate
            String location = "(" + Math.round(Math.random() * 100) + "," + Math.round(Math.random() * 100) + ")";
            System.out.println("Generated random location: " + location);

            // Kafka service call
            boolean result = this.kafkaService.updateLocation(location);
            System.out.println("Kafka service update result: " + result);

            if (!result) {
                System.out.println("Response: Failed to update location at iteration " + i);
            }

            try {
                Thread.sleep(1000); // 1 second gap between messages
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Response build
        System.out.println("Response: Sent 50 location updates");
        return ResponseEntity.ok("Sent 50 location updates");
    }
}