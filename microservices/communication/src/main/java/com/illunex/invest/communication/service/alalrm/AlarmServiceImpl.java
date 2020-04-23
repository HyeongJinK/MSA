package com.illunex.invest.communication.service.alalrm;

import com.illunex.invest.api.core.communication.enumable.AlarmReadStatus;
import com.illunex.invest.communication.persistence.alarm.entity.AlarmMessage;
import com.illunex.invest.communication.persistence.alarm.entity.AlarmReceiver;
import com.illunex.invest.communication.persistence.alarm.repository.AlarmMessageRepository;
import com.illunex.invest.communication.persistence.alarm.repository.AlarmReceiverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AlarmServiceImpl implements AlarmService {
    private final AlarmMessageRepository alarmMessageRepository;
    private final AlarmReceiverRepository alarmReceiverRepository;

    @Override
    public List<AlarmReceiver> getAllLists() {
        return alarmReceiverRepository.findAll();
    }

    @Override
    public List<AlarmReceiver> getLists(Long userId) {
        return alarmReceiverRepository.findAllByUserId(userId);
    }

    @Override
    public AlarmReceiver get(Long id) {
        return alarmReceiverRepository.findById(id).get();
    }

    @Override
    @Transactional
    public void sender(AlarmMessage message, List<Long> users) {
        AlarmMessage alarmMessage = alarmMessageRepository.save(message);

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

    }

    @Override
    @Transactional
    public void allDel(Long id) {
        alarmReceiverRepository.deleteAll(alarmReceiverRepository.findAllByReceiverId(id));
        alarmMessageRepository.deleteById(id);
    }
}
