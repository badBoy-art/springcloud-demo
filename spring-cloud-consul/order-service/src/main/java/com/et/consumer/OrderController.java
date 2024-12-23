package com.et.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/createOrder")
    public String createOrder() {
        // invoke Payment Service
        String paymentResponse = restTemplate.getForObject("http://payment-service/pay", String.class);
        return "Order created and " + paymentResponse;
    }
}