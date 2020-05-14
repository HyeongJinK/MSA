package com.illunex.invest.user.persistence.entity;

import com.illunex.invest.api.core.user.model.RoleInterface;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "role")
@Getter @Setter
@NoArgsConstructor
@ToString(of = {"name"})
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
        roles.add(new Role("ROLE_IR"));
        roles.add(new Role("ROLE_COMPANY"));
        roles.add(new Role("ROLE_PRODUCT"));
        roles.add(new Role("ROLE_TEAM"));
        roles.add(new Role("ROLE_INVEST"));
        return roles;
    }

    public static Set<Role> companyAdminRoles() {
        Set<Role> roles = new HashSet<>();
        roles.add(new Role("ROLE_USER"));
        roles.add(new Role("ROLE_IR", 15));
        roles.add(new Role("ROLE_COMPANY", 15));
        roles.add(new Role("ROLE_PRODUCT", 15));
        roles.add(new Role("ROLE_TEAM", 15));
        roles.add(new Role("ROLE_INVEST", 15));
        roles.add(new Role("ROLE_COMPANY_ADMIN", 15));
        return roles;
    }

    @Override
    public String getAuthority() {
        return name;
    }
}
