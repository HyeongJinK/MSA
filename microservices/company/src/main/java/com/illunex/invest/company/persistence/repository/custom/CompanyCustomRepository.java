package com.illunex.invest.company.persistence.repository.custom;

import com.illunex.invest.company.persistence.entity.Company;

import java.util.Optional;

public interface CompanyCustomRepository {
    Optional<Company> findByCompanyIdx(Long idx);
    void updateLogo(Long idx, String squareLogo, String rectangleLogo);
}
