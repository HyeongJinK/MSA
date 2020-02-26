package com.illunex.invest.user.persistence.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

//@Entity
//@Table(name = "policy")
//@NoArgsConstructor
//@Getter @Setter
public class Policy {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idx;

    boolean servicePolicy;

    boolean privatePolicy;

    LocalDateTime regDate;
}
