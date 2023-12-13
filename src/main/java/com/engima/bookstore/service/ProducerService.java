package com.engima.bookstore.service;

import com.engima.bookstore.entity.Purchase;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface ProducerService {
    public void sendMessage(Purchase purchase) throws JsonProcessingException;
}
