package com.illunex.invest.communication.persistence.alarm.repository.custom;

import java.util.List;

public interface AlarmMessageCustomRepository {
    void deleteAllById(List<Long> ids);
}
