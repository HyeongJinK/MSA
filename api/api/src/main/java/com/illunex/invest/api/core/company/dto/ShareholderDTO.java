package com.illunex.invest.api.core.company.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString(of = {"id", "title", "regDate", "updateDate", "signature", "rock", "password"})
public class ShareholderDTO {
    Long id;
    String title;
    String regDate;
    LocalDateTime updateDate;
    String signature;
    Boolean rock;
    String password;

    public int getTotalStock() {
        return shareholderPeople
                .stream()
                .map(ShareholderPersonDTO::getStock)
                .mapToInt(value -> Integer.parseInt(value))
                .sum();
    }

    public int getTotalTotalValue() {
        return shareholderPeople
                .stream()
                .map(ShareholderPersonDTO::getTotalValue)
                .mapToInt(value -> Integer.parseInt(value))
                .sum();
    }

    List<ShareholderPersonDTO> shareholderPeople = new ArrayList<>();
    CompanyIdDTO company;
}
