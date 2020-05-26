package com.illunex.invest.communication.persistence.alarm.repository;

import com.illunex.invest.communication.persistence.alarm.entity.AlarmMessage;
import com.illunex.invest.communication.persistence.alarm.repository.custom.AlarmMessageRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlarmMessageRepository extends JpaRepository<AlarmMessage, Long> {
}
