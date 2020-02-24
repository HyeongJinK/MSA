package com.illunex.invest.user.service.mapper;

import com.illunex.invest.api.core.user.dto.UserDTO;
import com.illunex.invest.user.persistence.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO entityToDto(UserEntity userEntity);
    UserEntity dtoToEntity(UserDTO userDTO);
}
