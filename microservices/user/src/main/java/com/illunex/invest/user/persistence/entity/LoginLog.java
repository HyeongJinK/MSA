package com.illunex.invest.user.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "LoginLog")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoginLog {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    User user;

    LocalDateTime regDate;

    String ip;
}
