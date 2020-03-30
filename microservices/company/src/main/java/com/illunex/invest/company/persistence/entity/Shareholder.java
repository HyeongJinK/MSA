package com.illunex.invest.company.persistence.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "shareholder")
public class Shareholder {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String title;
    LocalDateTime regDate;
    LocalDateTime updateDate;
    String signature;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<ShareholderPerson> shareholderPeople = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    Company company;
}

