package com.illunex.invest.user.service;

import com.illunex.invest.api.core.user.dto.UserDTO;
import com.illunex.invest.user.persistence.entity.User;
import com.illunex.invest.user.persistence.repository.UserRepository;
import com.illunex.invest.user.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class SignInServiceImpl extends UserService implements SignInService {
    private final UserRepository userRepository;
    private UserMapper mapper = Mappers.getMapper(UserMapper.class);

    @Override
    public UserDTO findByUsername(String username) {
        usernameParameterCheck(username);
        User currentUser = userRepository.findByUsername(username);
        userNullCheck(currentUser);

        return mapper.entityToDto(currentUser);
    }
}
