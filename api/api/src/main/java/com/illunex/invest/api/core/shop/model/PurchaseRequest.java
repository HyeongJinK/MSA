package com.illunex.invest.api.core.shop.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class PurchaseRequest {
    Long userIdx;
    List<BuyProduct> buyProducts = new ArrayList<>();
}
