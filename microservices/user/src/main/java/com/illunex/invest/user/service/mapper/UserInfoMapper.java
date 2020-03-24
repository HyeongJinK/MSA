package com.illunex.invest.user.service.mapper;

import com.illunex.invest.api.core.user.dto.RoleDTO;
import com.illunex.invest.api.core.user.dto.UserInfoDTO;
import com.illunex.invest.user.persistence.entity.Role;
import com.illunex.invest.user.persistence.entity.User;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface UserInfoMapper {
    UserInfoDTO entityToDto(User user);
    User dtoToEntity(UserInfoDTO userDTO);

    Set<RoleDTO> UserEntitySetToDtoSet(Set<Role> roles);
    Set<Role> UserDtoSetToEntitySet(Set<RoleDTO> roles);
}
