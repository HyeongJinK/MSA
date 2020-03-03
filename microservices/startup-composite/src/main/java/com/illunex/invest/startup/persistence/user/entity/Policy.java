package com.illunex.invest.startup.persistence.user.entity;


import java.time.LocalDateTime;

//@Entity
//@Table(name = "policy")
//@NoArgsConstructor
//@Getter @Setter
public class Policy {
    //@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idx;

    boolean servicePolicy;

    boolean privatePolicy;

    LocalDateTime regDate;
}
