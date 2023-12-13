package com.engima.bookstore.controller;

import com.engima.bookstore.entity.Purchase;
import com.engima.bookstore.service.PurchaseService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PurchaseController {

    @Autowired
    PurchaseService purchaseService;

    @PostMapping("/transaction")
    Purchase saveTransaction(@RequestBody Purchase purchase) throws JsonProcessingException {
        return purchaseService.transaction(purchase);
    }
}
