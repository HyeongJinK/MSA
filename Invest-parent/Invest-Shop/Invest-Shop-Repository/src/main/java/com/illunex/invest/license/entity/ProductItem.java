package com.illunex.invest.license.entity;

import com.illunex.invest.license.enumable.ItemType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProductItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long productItemIdx;
    Long itemIdx;
    ItemType itemType;
}
