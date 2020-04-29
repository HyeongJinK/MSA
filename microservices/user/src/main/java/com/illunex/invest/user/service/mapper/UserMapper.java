package com.illunex.invest.user.service.mapper;

import com.illunex.invest.api.core.user.dto.RoleDTO;
import com.illunex.invest.api.core.user.dto.SnsDTO;
import com.illunex.invest.api.core.user.dto.UserDTO;
import com.illunex.invest.user.persistence.entity.Role;
import com.illunex.invest.user.persistence.entity.Sns;
import com.illunex.invest.user.persistence.entity.User;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO entityToDto(User user);
    User dtoToEntity(UserDTO userDTO);

    Set<RoleDTO> UserEntitySetToDtoSet(Set<Role> roles);
    Set<Role> UserDtoSetToEntitySet(Set<RoleDTO> roles);

    SnsDTO entityToDto(Sns sns);
    Sns dtoToEntity(SnsDTO snsDTO);
}
