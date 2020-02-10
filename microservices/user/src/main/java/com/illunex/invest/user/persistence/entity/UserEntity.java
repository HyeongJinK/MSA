package com.illunex.invest.user.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long userIdx;

    String id;
    String password;
    String name;
    String email;
    String profile;
    String vender;
}
