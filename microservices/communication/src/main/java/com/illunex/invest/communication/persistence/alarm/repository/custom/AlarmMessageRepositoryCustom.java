package com.illunex.invest.communication.persistence.alarm.repository.custom;

import java.util.List;

public interface AlarmMessageRepositoryCustom {
    void deleteAllById(List<Long> ids);
}
