package com.illunex.invest.user.service;

import com.illunex.invest.api.core.user.dto.AuthRoleDTO;
import com.illunex.invest.api.core.user.dto.AuthorityDTO;
import com.illunex.invest.api.core.user.request.AuthorityRequest;
import com.illunex.invest.user.persistence.entity.Role;
import com.illunex.invest.user.persistence.entity.User;
import com.illunex.invest.user.persistence.repository.RoleRepository;
import com.illunex.invest.user.persistence.repository.UserRepository;
import com.illunex.invest.user.service.mapper.AuthorityMapper;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthorityServiceImpl implements AuthorityService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    private AuthorityMapper mapper = Mappers.getMapper(AuthorityMapper.class);

    @Override
    public List<AuthorityDTO> getMemberAuthorityList(Long companyIdx) {
        return mapper.entityToDto(userRepository.findByCompanyIdx(companyIdx));
    }

    @Override
    public AuthRoleDTO getIRAuthority(Long userIdx) {
        return mapper.entityAuthRoleToDto(userRepository.findById(userIdx).get());
    }

    @Override
    @Transactional
    public String setMemberAuthorityList(AuthorityRequest request) {
        User user = userRepository.findById(request.getUserId()).get();
        Set<Role> authorities = new HashSet<>();

        request.getData()
                .stream()
                .forEach((authorityItem -> {
                    authorities.addAll(mapper.UserDtoSetToEntitySet(authorityItem.getPluginRole()));
                }));
        authorities.addAll(user.getAuthorities()
                .stream()
                .filter(auth -> auth.getName().equals("ROLE_COMPANY_ADMIN"))
                .collect(Collectors.toList()));
        user.setAuthorities(authorities);
        userRepository.save(user);
        return "success";
    }
}
