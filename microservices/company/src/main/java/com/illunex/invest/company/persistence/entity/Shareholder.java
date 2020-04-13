package com.illunex.invest.company.persistence.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity
@Table(name = "shareholder")
@ToString(of = {"id", "title", "regDate", "updateDate", "signature", "rock", "password", "writer"})
public class Shareholder {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String title;
    LocalDateTime regDate;
    LocalDateTime updateDate;
    String signature;
    Boolean rock;
    String password;
    Long writer;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<ShareholderPerson> shareholderPeople = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    Company company;
}

