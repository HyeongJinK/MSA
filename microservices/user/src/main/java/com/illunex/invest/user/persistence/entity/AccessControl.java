package com.illunex.invest.user.persistence.entity;

import com.illunex.invest.user.persistence.entity.enumable.AccessType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "access_control")
@NoArgsConstructor
@Getter @Setter
public class AccessControl {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idx;
    @Enumerated(value = EnumType.STRING)
    AccessType accessType;

    int accessLevel;
}
