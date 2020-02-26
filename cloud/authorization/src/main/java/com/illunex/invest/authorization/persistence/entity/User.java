package com.illunex.invest.authorization.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class User {
    private Long id;
    private String name;
    private String userName;
    private String password;

    private Set<Role> roles = new HashSet<>();
}
