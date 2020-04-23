package com.illunex.invest.communication.persistence.alarm.entity;

import com.illunex.invest.api.core.communication.enumable.AlarmReadStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class AlarmReceiver {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long userId;
    LocalDateTime regDate;
    @ManyToOne
    AlarmMessage receiver;
    LocalDateTime readDate;
    @Enumerated(value = EnumType.STRING)
    AlarmReadStatus readStatus;
}
