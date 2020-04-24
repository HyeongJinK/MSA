package com.illunex.invest.company.service;

import com.illunex.invest.api.core.company.dto.CorporateSealDTO;
import com.illunex.invest.company.persistence.entity.CorporateSeal;
import com.illunex.invest.company.persistence.repository.CorporateSealRepository;
import com.illunex.invest.company.service.mapper.CorporateSealMapper;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CorporateSealServiceImpl implements CorporateSealService {
    private final CorporateSealRepository corporateSealRepository;

    private CorporateSealMapper mapper = Mappers.getMapper(CorporateSealMapper.class);

    @Override
    public List<CorporateSealDTO> corporateSeal(Long companyId) {
        return mapper.entityToDto(corporateSealRepository.findAllByCompanyCompanyIdx(companyId));
    }

    @Override
    @Transactional
    public CorporateSealDTO addCorporateSeal(CorporateSealDTO corporateSealDTO) {
        return mapper.entityToDto(corporateSealRepository.save(mapper.dtoToEntity(corporateSealDTO)));
    }

    @Override
    @Transactional
    public void toggleCorporateSeal(Long id) {
        CorporateSeal corporateSeal = corporateSealRepository.findById(id).get().toggleStatus();
        corporateSealRepository.save(corporateSeal);
    }

    @Override
    @Transactional
    public void delCorporateSeal(Long id) {
        corporateSealRepository.deleteById(id);
    }
}
