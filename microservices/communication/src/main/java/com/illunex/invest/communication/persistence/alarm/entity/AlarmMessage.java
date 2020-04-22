package com.illunex.invest.communication.persistence.alarm.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AlarmMessage {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String kind;
    String title;
    String content;
    LocalDateTime regDate;
}
