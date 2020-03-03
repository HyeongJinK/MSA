package com.illunex.invest.startup.service.user;

import com.illunex.invest.api.core.user.dto.UserDTO;
import com.illunex.invest.startup.persistence.user.entity.User;
import com.illunex.invest.startup.persistence.user.repository.UserRepository;
import com.illunex.invest.startup.service.user.mapper.UserMapper;
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
