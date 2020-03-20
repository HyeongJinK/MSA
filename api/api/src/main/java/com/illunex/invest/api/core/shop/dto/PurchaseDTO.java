package com.illunex.invest.api.core.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseDTO {
    private Long id;
    Long userId;
    LocalDateTime regDate;
    Boolean cancel;
    LocalDateTime cancelDate;
    List<PurchaseDetailDTO> purchaseDetails = new ArrayList<>();

    public PurchaseDTO(Long id, LocalDateTime regDate) {
        this.id = id;
        this.regDate = regDate;
    }
}
