package com.engima.bookstore.service;

import com.engima.bookstore.entity.PurchaseDetail;
import com.engima.bookstore.repository.PurchaseDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseDetailServiceImpl implements PurchaseDetailService {

    @Autowired
    PurchaseDetailRepository purchaseDetailRepository;

    @Override
    public PurchaseDetail savePurchaseDetail(PurchaseDetail purchaseDetailServiceImpl) {
        return purchaseDetailRepository.save(purchaseDetailServiceImpl);
    }
}
