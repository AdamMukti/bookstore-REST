package com.engima.bookstore.service;

import com.engima.bookstore.constant.ResponseMessage;
import com.engima.bookstore.entity.Book;
import com.engima.bookstore.entity.Member;
import com.engima.bookstore.entity.Purchase;
import com.engima.bookstore.entity.PurchaseDetail;
import com.engima.bookstore.exception.DataNotFoundException;
import com.engima.bookstore.repository.PurchaseRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    PurchaseRepository purchaseRepository;

    @Autowired
    PurchaseDetailService purchaseDetailService;

    @Autowired
    BookService bookService;

    @Autowired
    MemberService memberService;

    @Autowired
    ProducerService producerService;

    @Override
    public Purchase transaction(Purchase purchase) throws JsonProcessingException {
        Purchase pr = purchaseRepository.save(purchase);
        Member member = memberService.getMemberById(purchase.getMember().getId());
        pr.setMember(member);

        for (PurchaseDetail purchaseDetail : purchase.getPurchaseDetails()) {
            Book book = bookService.getBookById(purchaseDetail.getBook().getId());
            purchaseDetail.setPurchase(pr);

            if (book.getStock() == 0) {
                throw new DataNotFoundException("Book is out of stock");
            }
            if (book.getStock() < purchaseDetail.getQuantity()) {
                String message = String.format(ResponseMessage.BAD_REQUEST, book.getTitle(), book.getStock(), purchaseDetail.getQuantity());
                throw new DataNotFoundException(message);
            }

            book.setStock(book.getStock() - purchaseDetail.getQuantity());
            bookService.updateBook(book);
            purchaseDetail.setPriceSell((double) (book.getPrice() * purchaseDetail.getQuantity()));
            purchaseDetail.setBook(book);
            purchaseDetailService.savePurchaseDetail(purchaseDetail);

        }
        producerService.sendMessage(pr);
        return pr;
    }
}
