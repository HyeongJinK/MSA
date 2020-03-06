package com.illunex.invest.user.service;

import com.illunex.invest.api.core.user.dto.UserDTO;
import com.illunex.invest.user.exception.BadCredentialsException;
import com.illunex.invest.user.persistence.entity.User;
import com.illunex.invest.user.persistence.repository.UserRepository;
import com.illunex.invest.user.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChangePasswordServiceImpl extends UserService implements ChangePasswordService {
    private final UserRepository userRepository;
    private UserMapper mapper = Mappers.getMapper(UserMapper.class);

    @Override
    public UserDTO changePassword(String username, String prePassword, String password) {
        User user = userRepository.findByUsername(username);
        userNullCheck(user);

        passwordCheck(prePassword, user);

        user.setPassword(password);
        return mapper.entityToDto(user);
    }

    private void passwordCheck(String prePassword, User user) {
        if (!user.getPassword().equals(User.encodePassword(prePassword))) {
            throw new BadCredentialsException("비밀번호가 틀렸습니다.");
        }
    }
}
