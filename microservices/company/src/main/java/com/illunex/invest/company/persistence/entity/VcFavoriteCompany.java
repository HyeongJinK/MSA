package com.illunex.invest.company.persistence.entity;

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
public class VcFavoriteCompany {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idx;
    Long companyIdx;
    Long userIdx;
    LocalDateTime registrationDate;
}
