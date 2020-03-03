package com.illunex.invest.startup.service.user.mapper;

import com.illunex.invest.api.core.user.dto.RoleDTO;
import com.illunex.invest.api.core.user.dto.UserDTO;
import com.illunex.invest.startup.persistence.user.entity.Role;
import com.illunex.invest.startup.persistence.user.entity.User;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO entityToDto(User user);
    User dtoToEntity(UserDTO userDTO);

    Set<RoleDTO> UserEntitySetToDtoSet(Set<Role> roles);
    Set<Role> UserDtoSetToEntitySet(Set<RoleDTO> roles);
}
