package com.illunex.invest.ir.service;

import com.illunex.invest.api.core.ir.dto.ListDTO;
import com.illunex.invest.ir.persistence.entity.HistoryEntity;
import com.illunex.invest.ir.persistence.entity.IREntity;
import com.illunex.invest.ir.persistence.entity.ShareholderEntity;
import com.illunex.invest.ir.persistence.repository.IRRepository;
import com.illunex.invest.ir.persistence.repository.ShareholderRepository;
import com.illunex.invest.ir.service.mapper.ShareholderMapper;
import com.illunex.invest.api.core.ir.dto.ShareholderDTO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ShareholderServiceImpl extends CommonIRListService<ShareholderDTO> {
    private Log log = LogFactory.getLog(ShareholderServiceImpl.class);
    private ShareholderMapper shareholderMapper = Mappers.getMapper(ShareholderMapper.class);

    @Autowired
    ShareholderRepository shareholderRepository;

    @Override
    public ListDTO getList(Long irIdx) {
        List<ShareholderEntity> shareholderEntities = shareholderRepository.findAllByIrIdx(irIdx);
        List<ShareholderDTO> result = shareholderMapper.shareholderEntityListToDto(shareholderEntities);
        return ListDTO.builder().shareholderList(result).build();
    }

    @Override
    @Transactional
    public String editList(Long irIdx, List<ShareholderDTO> infoList) {
        List<ShareholderEntity> shareholderEntities = shareholderMapper.shareholderDtoListToEntity(infoList);
        IREntity ir = irRepository.findById(irIdx).orElse(null);

        return editTemplate(ir, () -> {
            editShareholder(ir, shareholderEntities);
            shareholderRepository.saveAll(shareholderEntities);
        }, "Cannot edit Shareholder. Invalid IR Index."
        , "Shareholder edit success");
    }

    private void editShareholder(IREntity irEntity, List<ShareholderEntity> shareholderEntities) {
        shareholderRepository.deleteAllByIrIdx(irEntity.getIdx());
        for (ShareholderEntity s: shareholderEntities){
            s.setIr(irEntity);
        }
    }
}
