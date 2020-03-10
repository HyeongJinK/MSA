package com.illunex.invest.ir.service;

import com.illunex.invest.api.core.ir.dto.ListDTO;
import com.illunex.invest.ir.persistence.entity.*;
import com.illunex.invest.ir.persistence.repository.HistoryRepository;
import com.illunex.invest.ir.persistence.repository.IRRepository;
import com.illunex.invest.ir.service.mapper.HistoryMapper;
import com.illunex.invest.api.core.ir.dto.HistoryDTO;
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
public class HistoryServiceImpl extends CommonIRListService<HistoryDTO> {
    private Log log = LogFactory.getLog(HistoryServiceImpl.class);
    private HistoryMapper historyMapper = Mappers.getMapper(HistoryMapper.class);

    @Autowired
    HistoryRepository historyRepository;

    @Override
    public ListDTO getList(Long irIdx) {
        List<HistoryEntity> historyEntities = historyRepository.findAllByIrIdx(irIdx);
        List<HistoryDTO> result = historyMapper.historyEntityListToDto(historyEntities);
        return ListDTO.builder().historyList(result).build();
    }

    @Override
    @Transactional
    public String editList(Long irIdx, List<HistoryDTO> infoList) {
        List<HistoryEntity> historyEntities = historyMapper.historyDtoListToEntity(infoList);
        IREntity ir = irRepository.findById(irIdx).orElse(null);

        return editTemplate(ir, () -> {
            editHistory(ir, historyEntities);
            historyRepository.saveAll(historyEntities);
        }, "Cannot edit History. Invalid IR Index."
        , "History edit success");
    }

    private void editHistory(IREntity irEntity, List<HistoryEntity> historyEntities) {
        historyRepository.deleteAllByIrIdx(irEntity.getIdx());
        for (HistoryEntity s: historyEntities){
            s.setIr(irEntity);
        }
    }
}
