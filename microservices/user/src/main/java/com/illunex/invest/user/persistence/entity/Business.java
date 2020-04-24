package com.illunex.invest.user.persistence.entity;


import com.illunex.invest.api.core.user.enumable.BusinessStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity(name = "business")
public class Business {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long companyId;
    String imgUrl;
    LocalDateTime regDate;
    @Enumerated(value = EnumType.STRING)
    BusinessStatus status;
}
