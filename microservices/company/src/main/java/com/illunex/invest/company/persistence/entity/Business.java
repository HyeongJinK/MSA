package com.illunex.invest.company.persistence.entity;

import com.illunex.invest.api.core.company.enumable.BusinessStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity(name = "business")
public class Business {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @OneToOne(fetch = FetchType.LAZY)
    Company company;
    String imgUrl;
    LocalDateTime regDate;
    @Enumerated(value = EnumType.STRING)
    BusinessStatus status;
}
