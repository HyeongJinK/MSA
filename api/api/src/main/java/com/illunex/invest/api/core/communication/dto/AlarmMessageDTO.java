package com.illunex.invest.api.core.communication.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlarmMessageDTO {
    Long id;
    String kind;
    String title;
    String content;
    LocalDateTime regDate;
}
