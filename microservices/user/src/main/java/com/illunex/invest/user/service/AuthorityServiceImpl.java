package com.illunex.invest.user.service;

import com.illunex.invest.api.core.user.dto.AuthorityDTO;
import com.illunex.invest.api.core.user.request.AuthorityRequest;
import com.illunex.invest.user.persistence.entity.User;
import com.illunex.invest.user.persistence.repository.RoleRepository;
import com.illunex.invest.user.persistence.repository.UserRepository;
import com.illunex.invest.user.service.mapper.AuthorityMapper;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthorityServiceImpl implements AuthorityService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    private AuthorityMapper mapper = Mappers.getMapper(AuthorityMapper.class);

    @Override
    @Transactional(readOnly = true)
    public List<AuthorityDTO> getMemberAuthorityList(Long companyIdx) {
        return mapper.entityToDto(userRepository.findByCompanyIdx(companyIdx));
    }

    @Override
    public String setMemberAuthorityList(AuthorityRequest request) {
        request.getData()
                .stream()
                .forEach((authorityItem -> {
                    User user = userRepository.findById(authorityItem.getId()).get();
                    user.setAuthorities(mapper.UserDtoSetToEntitySet(authorityItem.getAuthorities()));
                    userRepository.save(user);
                }));
        return "success";
    }
}
