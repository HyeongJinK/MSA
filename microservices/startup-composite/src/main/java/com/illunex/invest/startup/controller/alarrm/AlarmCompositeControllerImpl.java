package com.illunex.invest.startup.controller.alarrm;

import com.illunex.invest.api.common.response.ResponseList;
import com.illunex.invest.api.composite.startup.communication.controller.AlarmCompositeController;
import com.illunex.invest.startup.service.alarm.AlarmCompositeIntegration;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AlarmCompositeControllerImpl implements AlarmCompositeController {
    private final AlarmCompositeIntegration alarmCompositeIntegration;
    @Override
    public ResponseEntity<ResponseList> getAlarmList() {
        return alarmCompositeIntegration.getList();
    }
}
