package com.illunex.invest.communication.persistence.alarm.repository;

import com.illunex.invest.communication.persistence.alarm.entity.AlarmReceiver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlarmReceiverRepository extends JpaRepository<AlarmReceiver, Long> {
    List<AlarmReceiver> findAllByUserId(Long userId);
    List<AlarmReceiver> findAllByReceiverId(Long receiverId);
}
