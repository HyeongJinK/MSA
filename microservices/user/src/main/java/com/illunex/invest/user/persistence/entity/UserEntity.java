package com.illunex.invest.user.persistence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "user")
@NoArgsConstructor
@Getter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    Long userIdx;
    @Column(nullable = false, unique = true)
    String username;
    @Column(nullable = false)
    String password;
    String name;
    @Column(nullable = false)
    private String role;
    String profile;
    String vender;
}
