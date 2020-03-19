package com.illunex.invest.user.persistence.repository.custom;

import com.illunex.invest.user.persistence.entity.User;

import java.util.List;

public interface UserCustomRepository {
    List<User> findByCompanyIdx(Long companyIdx);
}
