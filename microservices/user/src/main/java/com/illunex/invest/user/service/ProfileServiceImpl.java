package com.illunex.invest.user.service;

import com.illunex.invest.api.core.user.dto.UserDTO;
import com.illunex.invest.user.persistence.repository.UserRepository;
import com.illunex.invest.user.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ProfileServiceImpl implements ProfileService {
    private UserMapper mapper = Mappers.getMapper(UserMapper.class);
    private final UserRepository userRepository;

    @Override
    public UserDTO getUser(Long userIdx) {
        return mapper.entityToDto(userRepository.findById(userIdx).get());
    }

    @Override
    public UserDTO editUser(UserDTO userDTO) {
        return mapper.entityToDto(userRepository.save(mapper.dtoToEntity(userDTO)));
    }
}
