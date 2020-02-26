package com.illunex.invest.InvestorRelations.service;

import com.illunex.invest.InvestorRelations.persistence.entity.BasicInfoEntity;
import com.illunex.invest.InvestorRelations.persistence.repository.AttractionRepository;
import com.illunex.invest.InvestorRelations.persistence.repository.BasicInfoRepository;
import com.illunex.invest.InvestorRelations.persistence.repository.IRRepository;
import com.illunex.invest.InvestorRelations.persistence.repository.SubsidyRepository;
import com.illunex.invest.InvestorRelations.service.mapper.BasicInfoMapper;
import com.illunex.invest.api.core.InvestorRelations.dto.BasicInfoDTO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class BasicInfoServiceImpl implements IRInfoService<BasicInfoDTO> {
    private Log log = LogFactory.getLog(BasicInfoServiceImpl.class);
    private BasicInfoMapper basicInfoMapper = Mappers.getMapper(BasicInfoMapper.class);

    @Autowired
    BasicInfoRepository basicInfoRepository;
    @Autowired
    IRRepository irRepository;
    @Autowired
    AttractionRepository attractionRepository;
    @Autowired
    SubsidyRepository subsidyRepository;

    @Override
    public BasicInfoDTO get(Long irIdx) {
        BasicInfoEntity basicInfo = basicInfoRepository.findByIrEntityIdx(irIdx);

        return basicInfoMapper.entityToDto(basicInfo);
    }

    @Override
    public BasicInfoDTO edit(BasicInfoDTO basicInfoDTO) {
        BasicInfoEntity basicInfoEntity = basicInfoMapper.dtoToEntity(basicInfoDTO);

        if (irRepository.findByBasicInfoEntityIdx(basicInfoDTO.getIdx()).isEmpty()) {
            return BasicInfoDTO.builder().name("unavailable").build();
        } else {
//            attractionRepository.deleteAll(attractionRepository.findAllByBasicInfoEntityIdx(basicInfoDTO.getIdx()));
            BasicInfoEntity result = basicInfoRepository.save(basicInfoEntity);
            return basicInfoMapper.entityToDto(result);
        }
    }
}
