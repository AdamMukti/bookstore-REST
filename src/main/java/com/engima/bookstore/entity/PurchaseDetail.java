package com.engima.bookstore.entity;

import com.engima.bookstore.repository.PurchaseRepository;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "trx_purchase_detail")
public class PurchaseDetail {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private Double priceSell;
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "purchase_id")
    private Purchase purchase;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public PurchaseDetail() {
    }

    public PurchaseDetail(String id, Double priceSell, Integer quantity, Purchase purchase, Book book) {
        this.id = id;
        this.priceSell = priceSell;
        this.quantity = quantity;
        this.purchase = purchase;
        this.book = book;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getPriceSell() {
        return priceSell;
    }

    public void setPriceSell(Double priceSell) {
        this.priceSell = priceSell;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
