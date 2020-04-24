package com.illunex.invest.api.core.communication.dto;

import com.illunex.invest.api.core.communication.enumable.AlarmReadStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class AlarmReceiverDTO {
    Long id;
    Long userId;
    LocalDateTime regDate;
    AlarmMessageDTO receiver;
    LocalDateTime readDate;
    AlarmReadStatus readStatus;
}
