package com.engima.bookstore.service;

import com.engima.bookstore.entity.PurchaseDetail;
import org.springframework.stereotype.Service;

public interface PurchaseDetailService {
    PurchaseDetail savePurchaseDetail(PurchaseDetail purchaseDetail);
}
