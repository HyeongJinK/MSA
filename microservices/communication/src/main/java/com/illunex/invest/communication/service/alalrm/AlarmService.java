package com.illunex.invest.communication.service.alalrm;

import com.illunex.invest.communication.persistence.alarm.entity.AlarmMessage;
import com.illunex.invest.communication.persistence.alarm.entity.AlarmReceiver;

import java.util.List;

public interface AlarmService {
    //TODO 알람리스트 - 전체, 개인
    List<AlarmReceiver> getAllLists();
    List<AlarmReceiver> getLists(Long userId);
    //TODO 알람읽기
    AlarmReceiver get(Long id);
    //TODO 알람보내기
    void sender(AlarmMessage message, List<Long> users);
    //TODO 알람삭제
    void del(List<Long> ids);
    void allDel(Long id);
}
