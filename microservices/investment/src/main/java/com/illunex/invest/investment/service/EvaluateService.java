package com.illunex.invest.investment.service;

import com.illunex.invest.api.core.invest.dto.EvaluateDTO;
import com.illunex.invest.api.core.invest.dto.EvaluateListDTO;
import com.illunex.invest.api.core.invest.dto.JudgeDTO;
import com.illunex.invest.api.core.invest.dto.ReviewItemDTO;
import com.illunex.invest.investment.persistence.entity.Evaluate;
import com.illunex.invest.investment.persistence.entity.EvaluateJudge;
import com.illunex.invest.investment.persistence.entity.EvaluateReviewItem;
import com.illunex.invest.investment.persistence.repository.*;
import com.illunex.invest.investment.service.mapper.EvaluateMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EvaluateService {
    private Log log = LogFactory.getLog(EvaluateService.class);

    @Autowired EvaluateRepository evaluateRepository;
    @Autowired EvaluateJudgeRepository evaluateJudgeRepository;
    @Autowired EvaluateReviewItemRepository evaluateReviewItemRepository;
    @Autowired JudgeRepository judgeRepository;
    @Autowired ReviewItemRepository reviewItemRepository;

    private EvaluateMapper mapper = Mappers.getMapper(EvaluateMapper.class);

    public String setEvaluate(Long companyIdx, Long vcCompanyIdx) {
        Evaluate evaluate = evaluateRepository.findByCompanyIdxAndVcCompanyIdx(companyIdx, vcCompanyIdx);

        if (evaluate == null) {
            // companyIdx 에 해당하는 기업, 제품 정보 받와와서 저장 해놔야됨
            evaluateRepository.save(Evaluate.builder().companyIdx(companyIdx).vcCompanyIdx(vcCompanyIdx).score(0).status("waiting").updateDate(LocalDateTime.now()).build());
            return "Evaluate set complete";
        } else {
            return "Already exists Evaluate";
        }

    }

    public EvaluateListDTO getEvaluateList(Long companyIdx) {
        List<EvaluateDTO> evaluateDTOList = mapper.evaluateListEntityToDTO(evaluateRepository.findAllByCompanyIdx(companyIdx));

        return EvaluateListDTO.builder().evaluateList(evaluateDTOList).build();
    }

    public EvaluateDTO getEvaluate(Long evaluateIdx) {
        return mapper.evaluateEntityToDTO(evaluateRepository.findById(evaluateIdx).get());
    }

    @Transactional
    public String editEvaluate(EvaluateDTO evaluateDTO) {
        Evaluate newEvaluate = mapper.evaluateDTOToEntity(evaluateDTO);
        Evaluate evaluate = evaluateRepository.findById(evaluateDTO.getIdx()).orElse(null);

        if (evaluate == null) {
            return "Invalid Evaluate";
        } else {

            evaluate.setContent(newEvaluate.getContent());
            evaluate.setUpdateDate(LocalDateTime.now());

            for (EvaluateJudge e: newEvaluate.getJudgeList()) {

                for (EvaluateReviewItem r: e.getReviewItem()) {
                    evaluateReviewItemRepository.deleteAllByJudgeIdx(e.getIdx());
                    r.setJudge(e);
                }

                evaluateJudgeRepository.deleteAllByEvaluateIdx(evaluate.getIdx());
                e.setEvaluate(evaluate);
            }

            evaluate.setJudgeList(newEvaluate.getJudgeList());

            evaluateRepository.save(evaluate);

            return "Evaluate edit complete";
        }

    }

    public String editJudge(JudgeDTO judgeDTO) {
        judgeRepository.save(mapper.judgeDTOToEntity(judgeDTO));
        return "Judge edit complete";
    }

    public String editReviewItem(ReviewItemDTO reviewItemDTO) {
        reviewItemRepository.save(mapper.reviewItemDTOToEntity(reviewItemDTO));
        return "ReviewItem edit complete";
    }

}
