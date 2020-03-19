package com.illunex.invest.user.service;

import com.illunex.invest.api.core.user.dto.AuthorityDTO;
import com.illunex.invest.api.core.user.model.AuthorityRequest;

import java.util.List;

public interface AuthorityService {
    List<AuthorityDTO> getMemberAuthorityList(Long companyIdx);
    String setMemberAuthorityList(AuthorityRequest request);

}
