package com.illunex.invest.api.core.communication.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlarmMessageDTO {
    Long id;
    String kind;
    String title;
    String content;
    LocalDateTime regDate;
}
