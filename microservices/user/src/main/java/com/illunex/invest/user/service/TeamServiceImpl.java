package com.illunex.invest.user.service;

import com.illunex.invest.api.core.user.dto.UserTeamDTO;
import com.illunex.invest.user.persistence.repository.UserRepository;
import com.illunex.invest.user.service.mapper.UserTeamMapper;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {
    private final UserRepository userRepository;
    private UserTeamMapper mapper = Mappers.getMapper(UserTeamMapper.class);

    @Override
    public List<UserTeamDTO> findAllByCompanyIdx(Long companyIdx) {
        return mapper.entityToDto(userRepository.findAllByCompanyIdx(companyIdx));
    }

    @Override
    public void toggleActivation(Long id) {

    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
