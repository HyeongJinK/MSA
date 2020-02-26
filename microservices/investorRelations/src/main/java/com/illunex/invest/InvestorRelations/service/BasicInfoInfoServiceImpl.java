package com.illunex.invest.InvestorRelations.service;

import com.illunex.invest.InvestorRelations.persistence.entity.BasicInfoEntity;
import com.illunex.invest.InvestorRelations.persistence.entity.IREntity;
import com.illunex.invest.InvestorRelations.persistence.repository.BasicInfoRepository;
import com.illunex.invest.InvestorRelations.persistence.repository.IRRepository;
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
public class BasicInfoInfoServiceImpl implements IRInfoService<BasicInfoDTO> {
    private Log log = LogFactory.getLog(BasicInfoInfoServiceImpl.class);
    private BasicInfoMapper basicInfoMapper = Mappers.getMapper(BasicInfoMapper.class);

    @Autowired
    BasicInfoRepository basicInfoRepository;

    private final IRRepository irRepository;


    @Override
    public BasicInfoDTO get(Long irIdx) {
//        BasicInfoEntity basicInfo = basicInfoRepository.findByIrEntityIrIdx(irIdx);
        IREntity irEntity = irRepository.findById(irIdx).get();

        return basicInfoMapper.entityToDto(irEntity.getBasicInfo());
    }

    @Override
    public BasicInfoDTO edit(BasicInfoDTO basicInfoDTO) {
        BasicInfoEntity basicInfoEntity = basicInfoMapper.dtoToEntity(basicInfoDTO);
        BasicInfoEntity result = basicInfoRepository.save(basicInfoEntity);

        return basicInfoMapper.entityToDto(result);
    }
}
