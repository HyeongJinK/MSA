package com.illunex.invest.ir.service;

import com.illunex.invest.api.core.ir.dto.BasicInfoDTO;
import com.illunex.invest.ir.persistence.entity.AttractionEntity;
import com.illunex.invest.ir.persistence.entity.BasicInfoEntity;
import com.illunex.invest.ir.persistence.entity.IREntity;
import com.illunex.invest.ir.persistence.entity.SubsidyEntity;
import com.illunex.invest.ir.persistence.repository.AttractionRepository;
import com.illunex.invest.ir.persistence.repository.BasicInfoRepository;
import com.illunex.invest.ir.persistence.repository.SubsidyRepository;
import com.illunex.invest.ir.service.mapper.BasicInfoMapper;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class BasicInfoServiceImpl extends CommonIRService<BasicInfoDTO> {
    private Log log = LogFactory.getLog(BasicInfoServiceImpl.class);
    private BasicInfoMapper basicInfoMapper = Mappers.getMapper(BasicInfoMapper.class);

    @Autowired
    BasicInfoRepository basicInfoRepository;
    @Autowired
    AttractionRepository attractionRepository;
    @Autowired
    SubsidyRepository subsidyRepository;

    @Override
    public BasicInfoDTO get(Long irIdx) {
        log.debug("===========================================");
        log.debug(basicInfoRepository);
        BasicInfoEntity basicInfo = basicInfoRepository.findByIrIdx(irIdx);

        return basicInfoMapper.entityToDto(basicInfo);
    }

    @Override
    @Transactional
    public String edit(BasicInfoDTO basicInfoDTO) {
        BasicInfoEntity basicInfoEntity = basicInfoMapper.dtoToEntity(basicInfoDTO);
        IREntity ir = irRepository.findById(basicInfoDTO.getIrIdx()).orElse(null);

        return editTemplate(ir, () -> {
            basicInfoEntity.setIdx(ir.getBasicInfo().getIdx());
            editAttraction(basicInfoEntity);
            editSubsidy(basicInfoEntity);
            basicInfoRepository.save(basicInfoEntity);
        }, "Cannot edit BasicInfo. Invalid IR Index."
        , "BasicInfo edit success");
    }

    private void editSubsidy(BasicInfoEntity basicInfoEntity) {
        subsidyRepository.deleteAllByBasicInfoIdx(basicInfoEntity.getIdx());
        for (SubsidyEntity s: basicInfoEntity.getSubsidy()){
            s.setBasicInfo(basicInfoEntity);
        }
    }

    private void editAttraction(BasicInfoEntity basicInfoEntity) {
        attractionRepository.deleteAllByBasicInfoIdx(basicInfoEntity.getIdx());
        for (AttractionEntity a: basicInfoEntity.getAttraction()) {
            a.setBasicInfo(basicInfoEntity);
        }
    }
}
