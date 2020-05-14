package com.illunex.invest.api.core.communication.model;

import com.illunex.invest.api.core.communication.dto.AlarmMessageDTO;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class AddAlarmRequest {
    AlarmMessageDTO alarmMessageDTO;
    List<Long> users;
}
