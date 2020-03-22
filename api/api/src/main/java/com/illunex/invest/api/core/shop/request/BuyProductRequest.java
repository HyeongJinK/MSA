package com.illunex.invest.api.core.shop.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BuyProductRequest {
    Long productId;
    int count;
}
