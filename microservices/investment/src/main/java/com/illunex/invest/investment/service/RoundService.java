package com.illunex.invest.investment.service;

import com.illunex.invest.api.core.investment.dto.VQRoundDTO;
import com.illunex.invest.investment.persistence.entity.VQRound;
import com.illunex.invest.investment.persistence.repository.VQRoundRepository;
import com.illunex.invest.investment.service.mapper.InvestmentMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoundService {
    private Log log = LogFactory.getLog(RoundService.class);

    @Autowired VQRoundRepository vqRoundRepository;

    private InvestmentMapper mapper = Mappers.getMapper(InvestmentMapper.class);

    public String vqRoundAnswer(VQRoundDTO vqRoundDTO) {
        VQRound round = vqRoundRepository.findByCompanyIdx(vqRoundDTO.getCompanyIdx());
        if (round == null) {
            vqRoundRepository.save(mapper.vqRoundDTOToEntity(vqRoundDTO));
            return "Round answer is complete";
        } else {
            return "Round answer already exist";
        }
    }
}
