package com.illunex.invest.api.core.InvestorRelations.dto;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HistoryDTO {
    Long idx;
    Long irIdx;
    String content;
    String date;
}
