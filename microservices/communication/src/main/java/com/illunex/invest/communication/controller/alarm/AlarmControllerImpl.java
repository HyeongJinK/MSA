package com.illunex.invest.communication.controller.alarm;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.common.response.ResponseList;
import com.illunex.invest.api.core.communication.controller.AlarmController;
import com.illunex.invest.api.core.communication.dto.AlarmReceiverDTO;
import com.illunex.invest.api.core.communication.model.AddAlarmRequest;
import com.illunex.invest.communication.service.alalrm.AlarmService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AlarmControllerImpl implements AlarmController {
    private final AlarmService alarmService;


    @Override
    public ResponseEntity<ResponseList> getList(Long userId) {
        List<AlarmReceiverDTO> list = alarmService.getLists(userId);
        return ResponseEntity.ok(new ResponseList(0, "success", list));
    }

    @Override
    public ResponseEntity<ResponseData> sender(AddAlarmRequest request) {
        alarmService.sender(request.getAlarmMessageDTO(), request.getUsers());
        return ResponseEntity.ok(ResponseData.builder()
                .errorCode(0)
                .message("success")
                .build());
    }
}
