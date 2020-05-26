package com.illunex.invest.api.core.communication.dto;

import com.illunex.invest.api.core.communication.enumable.AlarmReadStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    public String getParseRegDate() {
        if (regDate != null) {
            return regDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        } else {
            return "";
        }
    }
}
