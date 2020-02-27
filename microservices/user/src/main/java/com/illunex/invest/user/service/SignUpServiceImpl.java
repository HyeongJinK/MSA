package com.illunex.invest.user.service;

import com.illunex.invest.api.core.user.dto.UserDTO;
import com.illunex.invest.user.persistence.entity.User;
import com.illunex.invest.user.persistence.repository.UserRepository;
import com.illunex.invest.user.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignUpServiceImpl extends UserService implements SignUpService {
    private final UserRepository userRepository;
    private UserMapper mapper = Mappers.getMapper(UserMapper.class);

    @Override
    public UserDTO signUp(String username, String password, String name) {
        User user = userRepository.findByUsername(username);

        DuplicateUserCheck(user);

        return mapper.entityToDto(userRepository.save(User.createUser(username, password, name, "illunex")));
    }


}
