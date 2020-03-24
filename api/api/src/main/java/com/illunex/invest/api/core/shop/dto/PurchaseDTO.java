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
    Boolean cancel;

    List<PurchaseDetailDTO> purchaseDetails = new ArrayList<>();
    List<Long> ids = new ArrayList<>();

    public PurchaseDTO(Long id) {
        this.id = id;
    }

    public PurchaseDTO(Long id, Long userId, Boolean cancel, List<PurchaseDetailDTO> purchaseDetails) {
        this.id = id;
        this.userId = userId;
        this.cancel = cancel;
        this.purchaseDetails = purchaseDetails;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }
}
