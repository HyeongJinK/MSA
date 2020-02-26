package com.illunex.invest.user.service.mapper;

import com.illunex.invest.api.core.user.dto.UserDTO;
import com.illunex.invest.user.persistence.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO entityToDto(User user);
    User dtoToEntity(UserDTO userDTO);
}
