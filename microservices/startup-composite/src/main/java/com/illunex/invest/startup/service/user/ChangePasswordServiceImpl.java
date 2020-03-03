package com.illunex.invest.startup.service.user;

import com.illunex.invest.api.core.user.dto.UserDTO;

import com.illunex.invest.startup.persistence.user.entity.User;
import com.illunex.invest.startup.persistence.user.repository.UserRepository;
import com.illunex.invest.startup.service.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.security.authentication.BadCredentialsException;
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
