package com.illunex.invest.investment.persistence.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "favorite_company")
public class FavoriteCompany {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idx;
    Long companyIdx;
    Long userIdx;
    LocalDateTime registrationDate;
}
