package com.illunex.invest.user.service;

import com.illunex.invest.api.core.user.dto.UserInfoDTO;
import com.illunex.invest.user.persistence.entity.User;
import com.illunex.invest.user.persistence.repository.UserRepository;
import com.illunex.invest.user.service.mapper.UserInfoMapper;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignUpServiceImpl extends UserService implements SignUpService {
    private final UserRepository userRepository;
    private UserInfoMapper mapper = Mappers.getMapper(UserInfoMapper.class);

    @Override
    public UserInfoDTO signUp(String username, String password, String name, String vender, Long companyIdx) {
        User user = userRepository.findByUsername(username);

        DuplicateUserCheck(user);

        return mapper.entityToDto(userRepository.save(
                User.createCompanyAdminUser(username
                        , password
                        , name
                        , vender
                        , GenerateToken.CreateToken()
                        , companyIdx
                )));
    }

    @Override
    public UserInfoDTO invite(String username, String password, String name, String vender, Long companyIdx) {
        User user = userRepository.findByUsername(username);

        DuplicateUserCheck(user);

        return mapper.entityToDto(userRepository.save(
                User.createUser(username
                        , password
                        , name
                        , vender
                        , GenerateToken.CreateToken()
                        , companyIdx)
        ));
    }
}
