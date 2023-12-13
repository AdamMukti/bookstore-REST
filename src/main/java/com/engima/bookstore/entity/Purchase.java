package com.engima.bookstore.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "trx_purchase")
public class Purchase {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(
            name = "uuid2",
            strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "transaction_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date purchaseDate;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "purchase")
    @JsonIgnoreProperties("purchase")
    private List<PurchaseDetail> purchaseDetails = new ArrayList<>();

    private Double grandTotal;

    public Purchase() {
    }

    public Purchase(String id, Date purchaseDate, Member member, List<PurchaseDetail> purchaseDetails, Double grandTotal) {
        this.id = id;
        this.purchaseDate = purchaseDate;
        this.member = member;
        this.purchaseDetails = purchaseDetails;
        this.grandTotal = grandTotal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Member getMembers() {
        return member;
    }

    public void setMembers(Member members) {
        this.member = members;
    }

    public Double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(Double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public List<PurchaseDetail> getPurchaseDetails() {
        return purchaseDetails;
    }

    public void setPurchaseDetails(List<PurchaseDetail> purchaseDetails) {
        this.purchaseDetails = purchaseDetails;
    }
}
