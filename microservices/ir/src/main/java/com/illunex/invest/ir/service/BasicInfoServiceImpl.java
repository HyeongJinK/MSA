package com.illunex.invest.ir.service;

import com.illunex.invest.ir.persistence.entity.AttractionEntity;
import com.illunex.invest.ir.persistence.entity.BasicInfoEntity;
import com.illunex.invest.ir.persistence.entity.IREntity;
import com.illunex.invest.ir.persistence.entity.SubsidyEntity;
import com.illunex.invest.ir.persistence.repository.AttractionRepository;
import com.illunex.invest.ir.persistence.repository.BasicInfoRepository;
import com.illunex.invest.ir.persistence.repository.IRRepository;
import com.illunex.invest.ir.persistence.repository.SubsidyRepository;
import com.illunex.invest.ir.service.mapper.BasicInfoMapper;
import com.illunex.invest.api.core.ir.dto.BasicInfoDTO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;


@Service
@RequiredArgsConstructor
public class BasicInfoServiceImpl implements CommonIRService<BasicInfoDTO> {
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
        BasicInfoEntity basicInfo = basicInfoRepository.findByIrIdx(irIdx);

        return basicInfoMapper.entityToDto(basicInfo);
    }

    @Override
    @Transactional
    public String edit(BasicInfoDTO basicInfoDTO) {
        BasicInfoEntity basicInfoEntity = basicInfoMapper.dtoToEntity(basicInfoDTO);

        if (irRepository.findById(basicInfoDTO.getIrIdx()).isEmpty()) {
            return "Cannot edit BasicInfo. Invalid IR Index.";
        } else {
            Long irIdx = basicInfoDTO.getIrIdx();
            basicInfoEntity.setIdx(irRepository.findById(irIdx).get().getBasicInfo().getIdx());

            attractionRepository.deleteAllByBasicInfoIdx(basicInfoEntity.getIdx());
            subsidyRepository.deleteAllByBasicInfoIdx(basicInfoEntity.getIdx());

            List<AttractionEntity> attractionEntities = basicInfoEntity.getAttraction();
            List<SubsidyEntity> subsidyEntities = basicInfoEntity.getSubsidy();

            for (AttractionEntity a: attractionEntities) {
                a.setBasicInfo(basicInfoEntity);
            }

            for (SubsidyEntity s: subsidyEntities){
                s.setBasicInfo(basicInfoEntity);
            }

            basicInfoRepository.save(basicInfoEntity);

            IREntity ir = irRepository.findById(irIdx).get();
            Progress progress = new Progress();
            String res = progress.progressCalculate(ir);
            ir.setProgress(res);
            ir.setUpdateDate(LocalDateTime.now());
            irRepository.save(ir);

            return "BasicInfo edit success";
        }
    }
}
