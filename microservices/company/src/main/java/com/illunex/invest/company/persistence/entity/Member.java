package com.illunex.invest.company.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "member")
@Getter @Setter
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long companyMemberIdx;
    String name;
    String rank;
    String career;
    String imgUrl;
}
