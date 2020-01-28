package com.illunex.invest.license.entity;

import com.illunex.invest.license.enumable.RefundStatus;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long purchaseIdx;
    Long userIdx;
    @OneToOne
    Product product;
    Date purchaseDate;
    RefundStatus refundStatus;
}
