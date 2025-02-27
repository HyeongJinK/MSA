package com.illunex.invest.api.core.user.dto;

import com.illunex.invest.api.core.user.model.UserInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class UserDTO implements UserInterface {
    private Long id;
    private String username;
    private String password;
    private String name;
    private String rank;
    private Set<RoleDTO> authorities = new HashSet<>();
    private String profileImg;
    private String vender;
    private Long companyIdx;
    private Boolean certification;
    private String dept;
    private String token;
    private SnsDTO sns;
    private boolean marketing;

    @Override
    public Collection<RoleDTO> getAuthorities() {
        return authorities;
    }

    public boolean isAdmin() {
        return authorities.stream().filter(auth -> auth.getName().equals("ROLE_COMPANY_ADMIN")).count() == 1l;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
