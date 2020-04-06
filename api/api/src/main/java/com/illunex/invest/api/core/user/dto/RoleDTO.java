package com.illunex.invest.api.core.user.dto;

import com.illunex.invest.api.core.user.model.RoleInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class RoleDTO implements RoleInterface {
    private Long id;
    private String name;
    private int detailedRights;

    @Override
    public String getAuthority() {
        return name;
    }

    public RoleDTO(String name) {
        this.name = name;
        this.detailedRights = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleDTO roleDTO = (RoleDTO) o;
        return Objects.equals(name, roleDTO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public boolean isRead() {
        return (this.detailedRights & 1) == 1;
    }
}
