package com.illunex.invest.communication.persistence.alarm.repository;

import com.illunex.invest.communication.persistence.alarm.entity.AlarmReceiver;
import com.illunex.invest.communication.persistence.alarm.repository.custom.AlarmReceiveCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlarmReceiverRepository extends JpaRepository<AlarmReceiver, Long>, AlarmReceiveCustomRepository {
    List<AlarmReceiver> findAllByUserId(Long userId);
    List<AlarmReceiver> findAllByReceiverId(Long receiverId);
}
