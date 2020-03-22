package com.illunex.invest.api.core.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class AuthorityDTO {
    private Long id;
    private String name;
    protected Set<RoleDTO> authorities = new HashSet<>();
    private String profileImg;
}
