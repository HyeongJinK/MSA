package com.illunex.invest.api.core.company.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class ShareholderDTO {
    Long id;
    String title;
    LocalDateTime regDate;
    LocalDateTime updateDate;
    String signature;

    List<ShareholderPersonDTO> shareholderPeople = new ArrayList<>();
    CompanyIdDTO company;
}
