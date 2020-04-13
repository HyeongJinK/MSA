package com.illunex.invest.investment.service;

import com.illunex.invest.api.core.investment.dto.*;
import com.illunex.invest.investment.persistence.entity.Judge;
import com.illunex.invest.investment.persistence.repository.*;
import com.illunex.invest.investment.service.mapper.InvestMentMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JudgeService {
    private Log log = LogFactory.getLog(JudgeService.class);

    @Autowired JudgeRepository judgeRepository;

    private InvestMentMapper mapper = Mappers.getMapper(InvestMentMapper.class);

    public ListDTO getJudgeList(Long companyIdx) {
        return ListDTO.builder().judgeList(mapper.judgeListEntityToDTO(judgeRepository.findAllByCompanyIdx(companyIdx))).build();
    }

    public JudgeDTO getJudge(Long judgeIdx) {
        return mapper.judgeEntityToDTO(judgeRepository.findById(judgeIdx).get());
    }

    @Transactional
    public String editJudge(EditDTO editDTO) {
        List<Judge> judgeList = mapper.judgeListDTOToEntity(editDTO.getJudgeList());
        judgeRepository.deleteAllByCompanyIdx(editDTO.getCompanyIdx());
        judgeRepository.saveAll(judgeList);
        return "Judge edit complete";
    }

    public String deleteJudge(JudgeDTO judgeDTO) {
        judgeRepository.deleteById(judgeDTO.getIdx());
        return "Judge delete complete";
    }

}
