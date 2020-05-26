package com.illunex.invest.communication.service.alalrm;

import com.illunex.invest.api.core.communication.dto.AlarmMessageDTO;
import com.illunex.invest.api.core.communication.dto.AlarmReceiverDTO;
import com.illunex.invest.communication.persistence.alarm.entity.AlarmMessage;
import com.illunex.invest.communication.persistence.alarm.entity.AlarmReceiver;

import java.util.List;

public interface AlarmService {
    // 알람리스트 - 전체, 개인
    List<AlarmReceiverDTO> getAllLists();
    List<AlarmReceiverDTO> getLists(Long userId);
    // 알람읽기
    AlarmReceiver get(Long id);
    // 전체 읽기
    AlarmReceiver reads(Long userId);
    // 알람보내기
    void sender(AlarmMessageDTO message, List<Long> users);
    // 알람삭제
    void del(List<Long> ids);
    void allDel(Long id);
}
