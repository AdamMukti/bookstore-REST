package com.engima.bookstore.service;

import com.engima.bookstore.config.KafkaConfig;
import com.engima.bookstore.entity.Purchase;
import com.engima.bookstore.model.EmailMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerServiceImpl implements ProducerService{

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public void sendMessage(Purchase purchase) throws JsonProcessingException {
        String emailMessage = objectMapper.writeValueAsString(purchase);
        this.kafkaTemplate.send(KafkaConfig.TOPIC, emailMessage);
    }
}
