package com.illunex.invest.api.core.shop.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseRequest {
    Long userIdx;
    List<BuyProductRequest> buyProducts = new ArrayList<>();
}
