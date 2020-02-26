package com.illunex.invest.company.service;

import com.illunex.invest.api.core.company.dto.CompanyDTO;
import com.illunex.invest.company.exception.NoneCompanyException;
import com.illunex.invest.company.persistence.entity.CompanyEntity;
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
        CompanyEntity companyEntity = companyRepository.findByUserIdx(userIdx).orElseGet(() -> {
            throw new NoneCompanyException(userIdx.toString());
        });
        return mapper.entityToDto(companyEntity);
    }
}
