package com.illunex.invest.company.service;

import com.illunex.invest.api.core.company.dto.InvestSettingDTO;
import com.illunex.invest.company.persistence.entity.InvestSetting;
import com.illunex.invest.company.persistence.repository.CompanyRepository;
import com.illunex.invest.company.persistence.repository.InvestSettingRepository;
import com.illunex.invest.company.service.mapper.InvestSettingMapper;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class InvestSettingServiceImpl implements InvestSettingService {
    private final InvestSettingRepository investSettingRepository;
    private final CompanyRepository companyRepository;

    private InvestSettingMapper mapper = Mappers.getMapper(InvestSettingMapper.class);

    @Override
    public InvestSettingDTO findByInvestSetting(Long companyIdx) {
        return mapper.entityToDto(investSettingRepository.findByCompanyCompanyIdx(companyIdx));
    }

    @Override
    public void save(InvestSettingDTO investSettingDTO) {
        InvestSetting investSetting = mapper.dtoToEntity(investSettingDTO);
        investSetting.setCompany(companyRepository.findByCompanyIdx(investSettingDTO.getCompany().getCompanyIdx()).get());
        investSettingRepository.save(investSetting);
    }
}
