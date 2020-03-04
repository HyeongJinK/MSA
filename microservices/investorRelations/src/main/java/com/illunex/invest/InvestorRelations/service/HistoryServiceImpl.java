package com.illunex.invest.InvestorRelations.service;

import com.illunex.invest.InvestorRelations.persistence.entity.*;
import com.illunex.invest.InvestorRelations.persistence.repository.HistoryRepository;
import com.illunex.invest.InvestorRelations.persistence.repository.IRRepository;
import com.illunex.invest.InvestorRelations.service.mapper.HistoryMapper;
import com.illunex.invest.api.core.InvestorRelations.dto.HistoryDTO;
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
public class HistoryServiceImpl implements CommonIRListService<HistoryDTO> {
    private Log log = LogFactory.getLog(HistoryServiceImpl.class);
    private HistoryMapper historyMapper = Mappers.getMapper(HistoryMapper.class);

    @Autowired
    HistoryRepository historyRepository;
    @Autowired
    IRRepository irRepository;

    @Override
    public List<HistoryDTO> getList(Long irIdx) {
        List<HistoryEntity> historyEntities = historyRepository.findAllByIrIdx(irIdx);

        return historyMapper.historyEntityListToDto(historyEntities);
    }

    @Override
    @Transactional
    public List<HistoryDTO> editList(List<HistoryDTO> infoList) {
        List<HistoryEntity> historyEntities = historyMapper.historyDtoListToEntity(infoList);

        if (irRepository.findById(infoList.get(0).getIrIdx()).isEmpty()) {
            List<HistoryEntity> historyEntityList = new ArrayList<>();
            historyEntityList.add(HistoryEntity.builder().content("unavailable").build());

            return historyMapper.historyEntityListToDto(historyEntityList);
        } else {
            Long irIdx = infoList.get(0).getIrIdx();

            historyRepository.deleteAllByIrIdx(irIdx);
            IREntity irEntity = irRepository.findById(irIdx).get();

            for (HistoryEntity h: historyEntities) {
                h.setIr(irEntity);
            }

            List<HistoryEntity> result = historyRepository.saveAll(historyEntities);

            IREntity ir = irRepository.findById(irIdx).get();
            Progress progress = new Progress();
            String res = progress.progressCalculate(ir);
            ir.setProgress(res);
            ir.setUpdateDate(LocalDateTime.now());
            irRepository.save(ir);

            return historyMapper.historyEntityListToDto(result);
        }

    }
}
