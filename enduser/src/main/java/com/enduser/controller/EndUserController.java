package com.enduser.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EndUserController {


    @GetMapping("/")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("End User Service is up and running");
    }


}
