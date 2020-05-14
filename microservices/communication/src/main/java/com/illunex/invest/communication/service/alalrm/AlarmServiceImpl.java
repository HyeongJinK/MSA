package com.illunex.invest.communication.service.alalrm;

import com.illunex.invest.api.core.communication.dto.AlarmMessageDTO;
import com.illunex.invest.api.core.communication.dto.AlarmReceiverDTO;
import com.illunex.invest.api.core.communication.enumable.AlarmReadStatus;
import com.illunex.invest.communication.persistence.alarm.entity.AlarmMessage;
import com.illunex.invest.communication.persistence.alarm.entity.AlarmReceiver;
import com.illunex.invest.communication.persistence.alarm.repository.AlarmMessageRepository;
import com.illunex.invest.communication.persistence.alarm.repository.AlarmReceiverRepository;
import com.illunex.invest.communication.service.alalrm.mapper.AlarmMapper;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AlarmServiceImpl implements AlarmService {
    private AlarmMapper mapper = Mappers.getMapper(AlarmMapper.class);
    private final AlarmMessageRepository alarmMessageRepository;
    private final AlarmReceiverRepository alarmReceiverRepository;

    @Override
    public List<AlarmReceiverDTO> getAllLists() {
        return mapper.entityToDto(alarmReceiverRepository.findAll());
    }

    @Override
    public List<AlarmReceiverDTO> getLists(Long userId) {
        return mapper.entityToDto(alarmReceiverRepository.findAllByUserId(userId));
    }

    @Override
    public AlarmReceiver get(Long id) {
        return alarmReceiverRepository.findById(id).get();
    }

    @Override
    @Transactional
    public void sender(AlarmMessageDTO message, List<Long> users) {
        AlarmMessage alarmMessage = alarmMessageRepository.save(mapper.dtoToEntity(message));

        alarmReceiverRepository.saveAll(
            users.stream()
                    .map(userId -> AlarmReceiver.builder()
                            .userId(userId)
                            .regDate(LocalDateTime.now())
                            .receiver(alarmMessage)
                            .readDate(LocalDateTime.now())
                            .readStatus(AlarmReadStatus.wait)
                            .build())
                    .collect(Collectors.toList())
        );
    }

    @Override
    @Transactional
    public void del(List<Long> ids) {
        // TODO
    }

    @Override
    @Transactional
    public void allDel(Long id) {
        alarmReceiverRepository.deleteAll(alarmReceiverRepository.findAllByReceiverId(id));
        alarmMessageRepository.deleteById(id);
    }
}
