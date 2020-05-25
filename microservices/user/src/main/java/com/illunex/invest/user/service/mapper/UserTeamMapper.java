package com.illunex.invest.user.service.mapper;

import com.illunex.invest.api.core.user.dto.RoleDTO;
import com.illunex.invest.api.core.user.dto.UserTeamDTO;
import com.illunex.invest.user.persistence.entity.Role;
import com.illunex.invest.user.persistence.entity.User;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface UserTeamMapper {
    UserTeamDTO entityToDto(User user);
    User dtoToEntity(UserTeamDTO userDTO);

    List<UserTeamDTO> entityToDto( List<User> user);
    List<User> dtoToEntity( List<UserTeamDTO> userDTO);

    Set<RoleDTO> UserEntitySetToDtoSet(Set<Role> roles);
    Set<Role> UserDtoSetToEntitySet(Set<RoleDTO> roles);
}
