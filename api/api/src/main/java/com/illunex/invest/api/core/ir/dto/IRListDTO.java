package com.illunex.invest.api.core.ir.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IRListDTO {
    List<IRDTO> irList;
}
