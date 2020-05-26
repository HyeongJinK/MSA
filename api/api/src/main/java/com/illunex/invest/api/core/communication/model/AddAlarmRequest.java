package com.illunex.invest.api.core.communication.model;

import com.illunex.invest.api.core.communication.dto.AlarmMessageDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddAlarmRequest {
    AlarmMessageDTO alarmMessageDTO;
    List<Long> users;
}
