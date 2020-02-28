package com.illunex.invest.InvestorRelations.service;

import com.illunex.invest.InvestorRelations.persistence.entity.HistoryEntity;
import com.illunex.invest.InvestorRelations.persistence.entity.IREntity;
import com.illunex.invest.InvestorRelations.persistence.entity.ShareholderEntity;
import com.illunex.invest.InvestorRelations.persistence.repository.HistoryRepository;
import com.illunex.invest.InvestorRelations.persistence.repository.IRRepository;
import com.illunex.invest.InvestorRelations.persistence.repository.ShareholderRepository;
import com.illunex.invest.InvestorRelations.service.mapper.HistoryMapper;
import com.illunex.invest.InvestorRelations.service.mapper.ShareholderMapper;
import com.illunex.invest.api.core.InvestorRelations.dto.HistoryDTO;
import com.illunex.invest.api.core.InvestorRelations.dto.ShareholderDTO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ShareholderServiceImpl implements IRInfoService<ShareholderDTO> {
    private Log log = LogFactory.getLog(ShareholderServiceImpl.class);
    private ShareholderMapper shareholderMapper = Mappers.getMapper(ShareholderMapper.class);

    @Autowired
    ShareholderRepository shareholderRepository;
    @Autowired
    IRRepository irRepository;

    @Override
    public List<ShareholderDTO> getList(Long irIdx) {
        List<ShareholderEntity> shareholderEntities = shareholderRepository.findAllByIrIdx(irIdx);

        return shareholderMapper.shareholderEntityListToDto(shareholderEntities);
    }

    @Override
    @Transactional
    public List<ShareholderDTO> editList(List<ShareholderDTO> infoList) {
        List<ShareholderEntity> shareholderEntities = shareholderMapper.shareholderDtoListToEntity(infoList);

        if (irRepository.findById(infoList.get(0).getIrIdx()).isEmpty()) {
            List<ShareholderEntity> shareholderEntityList = new ArrayList<>();
            shareholderEntityList.add(ShareholderEntity.builder().name("unavailable").build());

            return shareholderMapper.shareholderEntityListToDto(shareholderEntityList);
        } else {
            Long irIdx = infoList.get(0).getIrIdx();

            shareholderRepository.deleteAllByIrIdx(irIdx);
            IREntity irEntity = irRepository.findById(irIdx).get();

            for (ShareholderEntity s: shareholderEntities) {
                s.setIr(irEntity);
            }

            List<ShareholderEntity> result = shareholderRepository.saveAll(shareholderEntities);

            return shareholderMapper.shareholderEntityListToDto(result);
        }

    }
}
