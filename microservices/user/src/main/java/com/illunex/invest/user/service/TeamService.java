package com.illunex.invest.user.service;

import com.illunex.invest.api.core.user.dto.UserTeamDTO;

import java.util.List;

public interface TeamService {
    List<UserTeamDTO> findAllByCompanyIdx(Long companyIdx);
    void toggleActivation(Long id);
    void deleteUser(Long id);
}
