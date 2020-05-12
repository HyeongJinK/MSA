package com.illunex.invest.user.persistence.repository.custom;

import com.illunex.invest.user.persistence.entity.User;

import java.util.List;

public interface UserRepositoryCustom {
    List<User> findByCompanyIdx(Long companyIdx);
    Long updateCertification(Long userIdx);
}
