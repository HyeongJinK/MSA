package com.illunex.invest.user.persistence.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "role")
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Role {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @ManyToMany(mappedBy = "roles", cascade = CascadeType.DETACH)
    private Set<User> users = new HashSet<>();

    public Role(String name) {
        this.name = name;
    }

    public static Set<Role> initRoles() {
        Set<Role> roles = new HashSet<>();
        roles.add(new Role("ROLE_USER"));
        return roles;
    }
}
