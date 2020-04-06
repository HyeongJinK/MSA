package com.illunex.invest.api.composite.startup.menu.dto;

import com.illunex.invest.api.core.user.dto.RoleDTO;
import com.illunex.invest.api.core.user.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MenuDto {
    List<Menu> list = new ArrayList<>();
    List<Menu> myPage = new ArrayList<>();
}
