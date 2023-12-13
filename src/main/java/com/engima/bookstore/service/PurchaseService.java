package com.engima.bookstore.service;

import com.engima.bookstore.entity.Purchase;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

public interface PurchaseService {
    Purchase transaction(Purchase purchase) throws JsonProcessingException;
}
