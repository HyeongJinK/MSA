package com.illunex.invest.ir.service;

import com.illunex.invest.api.core.ir.dto.*;
import com.illunex.invest.ir.persistence.entity.*;
import com.illunex.invest.ir.persistence.repository.*;
import com.illunex.invest.ir.service.mapper.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VCService {
    private Log log = LogFactory.getLog(VCService.class);
    private IRMapper irMapper = Mappers.getMapper(IRMapper.class);
    private BasicInfoMapper basicInfoMapper = Mappers.getMapper(BasicInfoMapper.class);
    private FinanceMapper financeMapper = Mappers.getMapper(FinanceMapper.class);
    private HistoryMapper historyMapper = Mappers.getMapper(HistoryMapper.class);
    private MemberMapper memberMapper = Mappers.getMapper(MemberMapper.class);
    private OutcomeMapper outcomeMapper = Mappers.getMapper(OutcomeMapper.class);
    private ProductMapper productMapper = Mappers.getMapper(ProductMapper.class);
    private ShareholderMapper shareholderMapper = Mappers.getMapper(ShareholderMapper.class);

    @Autowired IRRepository irRepository;
    @Autowired BasicInfoRepository basicInfoRepository;
    @Autowired FinanceRepository financeRepository;
    @Autowired HistoryRepository historyRepository;
    @Autowired MemberRepository memberRepository;
    @Autowired ProductRepository productRepository;
    @Autowired OutcomeRepository outcomeRepository;
    @Autowired ShareholderRepository shareholderRepository;

    public IRDTO getIR(Long companyIdx) {
        return irMapper.entityToDto(irRepository.findByCompanyIdxAndYear(companyIdx, String.valueOf(LocalDateTime.now().getYear())));
    }

    public BasicInfoDTO getBasicInfo(Long companyIdx) {
        return basicInfoMapper.entityToDto(basicInfoRepository.findByIrIdx(getIrIdx(companyIdx)));
    }

    public FinanceDTO getFinanceInfo(Long companyIdx) {
        return financeMapper.entityToDto(financeRepository.findByIrIdx(getIrIdx(companyIdx)));
    }

    public ListDTO getHistoryList(Long companyIdx) {
        List<HistoryEntity> historyEntities = historyRepository.findAllByIrIdx(getIrIdx(companyIdx));
        List<HistoryDTO> result = historyMapper.historyEntityListToDto(historyEntities);
        return ListDTO.builder().historyList(result).build();

    }

    public ListDTO getMemberList(Long companyIdx) {
        List<MemberEntity> memberEntities = memberRepository.findAllByIrIdx(getIrIdx(companyIdx));
        List<MemberDTO> result = memberMapper.memberEntityListToDto(memberEntities);
        return ListDTO.builder().memberList(result).build();
    }

    public OutcomeDTO getOutcomeInfo(Long companyIdx) {
        return outcomeMapper.entityToDto(outcomeRepository.findByIrIdx(getIrIdx(companyIdx)));
    }

    public ProductDTO getProductInfo(Long companyIdx) {
        return productMapper.entityToDto(productRepository.findByIrIdx(getIrIdx(companyIdx)));
    }

    public ListDTO getShareholderList(Long companyIdx) {
        List<ShareholderEntity> shareholderEntities = shareholderRepository.findAllByIrIdx(getIrIdx(companyIdx));
        List<ShareholderDTO> result = shareholderMapper.shareholderEntityListToDto(shareholderEntities);
        return ListDTO.builder().shareholderList(result).build();
    }

    public Long getIrIdx (Long companyIdx) {
        return irRepository.findByCompanyIdxAndYear(companyIdx, String.valueOf(LocalDateTime.now().getYear())).getIdx();
    }
}
