package com.illunex.invest.company.service;

import com.illunex.invest.api.core.company.dto.CompanyDTO;
import com.illunex.invest.api.core.company.dto.LogoDTO;
import com.illunex.invest.company.exception.NoneCompanyException;
import com.illunex.invest.company.persistence.entity.Company;
import com.illunex.invest.company.persistence.repository.CompanyRepository;
import com.illunex.invest.company.service.mapper.CompanyMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Log
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private CompanyMapper mapper = Mappers.getMapper(CompanyMapper.class);
    private final CompanyRepository companyRepository;

    @Override
    public List<CompanyDTO> getAllList() {
        return mapper.entityListToDto(companyRepository.findAll());
    }

    @Override
    public CompanyDTO getCompanyById(final Long id) {
        Company company = companyRepository.findByCompanyIdx(id).orElseGet(() -> {
            throw new NoneCompanyException(id.toString());
        });
        //log.info(company.toString());
        return mapper.entityToDto(company);
    }

    @Override
    @Transactional
    public Long registerCompany(String businessNumber) {
        return companyRepository.save(Company.builder()
                .businessNumber(businessNumber)
                .build()).getCompanyIdx();
    }

    @Override
    @Transactional
    public CompanyDTO updateCompany(CompanyDTO companyDTO) {
        companyDTO.setUpdateDate(LocalDateTime.now());
        //log.info(companyDTO.toString());
        return mapper.entityToDto(companyRepository.save(mapper.dtoToEntity(companyDTO)));
    }

    @Override
    public LogoDTO getLogo(Long companyIdx) {
        return companyRepository.findLogoByCompanyIdx(companyIdx);
    }

    @Override
    @Transactional
    public void updateLogo(Long id, String squareLogo, String rectangleLogo) {
        companyRepository.updateLogo(id, squareLogo, rectangleLogo);
    }

}
