package com.illunex.invest.api.core.ir.dto;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubsidyDTO {
    Long idx;
    String name;
    String value;
    String date;
}
