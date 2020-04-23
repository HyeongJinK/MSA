package com.illunex.invest.company.service;

import com.illunex.invest.api.core.company.dto.BusinessDTO;
import com.illunex.invest.company.persistence.repository.BusinessRepository;
import com.illunex.invest.company.service.mapper.BusinessMapper;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BusinessServiceImpl implements BusinessService {
    private BusinessMapper mapper = Mappers.getMapper(BusinessMapper.class);
    private final BusinessRepository businessRepository;

    @Override
    public BusinessDTO getBusiness(Long companyId) {
        return mapper.entityToDto(businessRepository.findByCompanyCompanyIdx(companyId));
    }

    @Override
    public BusinessDTO editBusiness(BusinessDTO businessDTO) {
        return mapper.entityToDto(businessRepository.save(mapper.dtoToEntity(businessDTO)));
    }
}
