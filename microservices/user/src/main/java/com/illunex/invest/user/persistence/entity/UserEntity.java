package com.illunex.invest.user.persistence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@NoArgsConstructor
@Getter @Setter
public class UserEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    Long companyIdx;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<AccessControlEntity> accessControlEntityList = new ArrayList<>();
}
