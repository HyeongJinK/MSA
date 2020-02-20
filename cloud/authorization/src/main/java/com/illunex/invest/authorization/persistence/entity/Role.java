package com.illunex.invest.authorization.persistence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class Role {
    private Long id;
    private String name;

    public Role(String name) {
        this.name = name;
    }
}
