package com.illunex.invest.InvestorRelations.service;

import com.illunex.invest.InvestorRelations.persistence.entity.IREntity;
import com.illunex.invest.InvestorRelations.persistence.entity.ShareholderEntity;
import com.illunex.invest.InvestorRelations.persistence.repository.IRRepository;
import com.illunex.invest.InvestorRelations.persistence.repository.ShareholderRepository;
import com.illunex.invest.InvestorRelations.service.mapper.ShareholderMapper;
import com.illunex.invest.api.core.InvestorRelations.dto.ShareholderDTO;
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
public class ShareholderServiceImpl implements CommonIRListService<ShareholderDTO> {
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
    public String editList(Long irIdx, List<ShareholderDTO> infoList) {
        List<ShareholderEntity> shareholderEntities = shareholderMapper.shareholderDtoListToEntity(infoList);

        if (irRepository.findById(irIdx).isEmpty()) {
            return "Cannot edit shareholder. Invalid IR Index.";
        } else {
            shareholderRepository.deleteAllByIrIdx(irIdx);
            IREntity irEntity = irRepository.findById(irIdx).get();

            for (ShareholderEntity s: shareholderEntities) {
                s.setIr(irEntity);
            }

            shareholderRepository.saveAll(shareholderEntities);

            IREntity ir = irRepository.findById(irIdx).get();
            Progress progress = new Progress();
            String res = progress.progressCalculate(ir);
            ir.setProgress(res);
            ir.setUpdateDate(LocalDateTime.now());
            irRepository.save(ir);

            return "shareholder edit complete";
        }

    }
}
