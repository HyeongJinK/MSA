package com.illunex.invest.user.persistence.entity;

import com.illunex.invest.api.core.user.model.RoleInterface;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "role")
@Getter @Setter
@NoArgsConstructor
public class Role implements RoleInterface {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @ManyToMany(mappedBy = "authorities", cascade = CascadeType.DETACH)
    private Set<User> users = new HashSet<>();

    private int detailedRights;

    public Role(String name) {
        this.name = name;
    }
    public Role(String name, int detailedRights) {
        this.name = name;
        this.detailedRights = detailedRights;
    }

    public static Set<Role> initRoles() {
        Set<Role> roles = new HashSet<>();
        roles.add(new Role("ROLE_USER"));
        return roles;
    }

    public static Set<Role> companyAdminRoles() {
        Set<Role> roles = new HashSet<>();
        roles.add(new Role("ROLE_USER"));
        roles.add(new Role("ROLE_COMPANY", 15));
        return roles;
    }

    @Override
    public String getAuthority() {
        return name;
    }
}
