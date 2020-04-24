package com.illunex.invest.communication.service.alalrm.mapper;

import com.illunex.invest.api.core.communication.dto.AlarmMessageDTO;
import com.illunex.invest.api.core.communication.dto.AlarmReceiverDTO;
import com.illunex.invest.communication.persistence.alarm.entity.AlarmMessage;
import com.illunex.invest.communication.persistence.alarm.entity.AlarmReceiver;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AlarmMapper {
    AlarmReceiverDTO entityToDto(AlarmReceiver alarmReceiver);
    AlarmReceiver dtoToEntity(AlarmReceiverDTO alarmReceiverDTO);
    AlarmMessageDTO entityToDto(AlarmMessage alarmMessage);
    AlarmMessage dtoToEntity(AlarmMessageDTO alarmMessageDTO);

    List<AlarmReceiverDTO> entityToDto(List<AlarmReceiver> alarmReceiver);
    List<AlarmReceiver> dtoToEntity(List<AlarmReceiverDTO> alarmReceiverDTO);
}
