package com.illunex.invest.company.service;

import com.illunex.invest.api.core.company.dto.CompanyDTO;
import com.illunex.invest.company.builder.CompanyBuilder;
import com.illunex.invest.company.exception.NoneCompanyException;
import com.illunex.invest.company.persistence.entity.Company;
import com.illunex.invest.company.persistence.repository.CompanyRepository;
import com.illunex.invest.company.service.mapper.CompanyMapper;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private CompanyMapper mapper = Mappers.getMapper(CompanyMapper.class);
    private final CompanyRepository companyRepository;

    public CompanyDTO getCompanyByUserIdx(final Long userIdx) {
        Company company = companyRepository.findByUserIdx(userIdx).orElseGet(() -> {
            throw new NoneCompanyException(userIdx.toString());
        });
        return mapper.entityToDto(company);
    }

    @Override
    @Transactional
    public Long registerCompany(Long userIdx, String businessNumber) {
        return companyRepository.save(CompanyBuilder.getInstance()
                .userIdx(userIdx)
                .businessNumber(businessNumber)
                .entityBuild()).getCompanyIdx();
    }
}
