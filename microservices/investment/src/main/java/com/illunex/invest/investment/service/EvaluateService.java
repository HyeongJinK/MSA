package com.illunex.invest.investment.service;

import com.illunex.invest.api.core.investment.dto.EvaluateDTO;
import com.illunex.invest.api.core.investment.dto.EvaluateListDTO;
import com.illunex.invest.investment.persistence.entity.Evaluate;
import com.illunex.invest.investment.persistence.entity.EvaluateJudge;
import com.illunex.invest.investment.persistence.entity.EvaluateReviewItem;
import com.illunex.invest.investment.persistence.entity.EvaluateReviewItemCategory;
import com.illunex.invest.investment.persistence.repository.EvaluateJudgeRepository;
import com.illunex.invest.investment.persistence.repository.EvaluateRepository;
import com.illunex.invest.investment.persistence.repository.EvaluateReviewItemCategoryRepository;
import com.illunex.invest.investment.persistence.repository.EvaluateReviewItemRepository;
import com.illunex.invest.investment.service.mapper.InvestMentMapper;
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
    @Autowired EvaluateReviewItemCategoryRepository evaluateReviewItemCategoryRepository;
    @Autowired EvaluateReviewItemRepository evaluateReviewItemRepository;

    private InvestMentMapper mapper = Mappers.getMapper(InvestMentMapper.class);

    public String setEvaluate(Long companyIdx, Long vcCompanyIdx) {
        Evaluate evaluate = evaluateRepository.findByCompanyIdxAndVcCompanyIdx(companyIdx, vcCompanyIdx);

        if (evaluate == null) {
            // companyIdx 에 해당하는 기업, 제품 정보 받와와서 저장 해놔야됨
            evaluateRepository.save(Evaluate.builder().companyIdx(companyIdx).vcCompanyIdx(vcCompanyIdx).score(0).deleted(false).status("waiting").createDate(LocalDateTime.now()).build());
            return "Evaluate set complete";
        } else {
            return "Already exists Evaluate";
        }

    }

    public EvaluateListDTO getEvaluateList(Long companyIdx) {
        List<EvaluateDTO> evaluateDTOList = mapper.evaluateListEntityToDTO(evaluateRepository.findAllByCompanyIdxAndDeleted(companyIdx, false));

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
            evaluate.setStatus(newEvaluate.getStatus());
            evaluate.setScore(0);
            evaluate.setRequestDate(LocalDateTime.now());

            for (EvaluateJudge e: newEvaluate.getJudgeList()) {

                for (EvaluateReviewItemCategory c: e.getReviewItemCategory()) {

                    for (EvaluateReviewItem r: c.getReviewItem()) {
                        evaluateReviewItemRepository.deleteAllByReviewItemCategoryIdx(c.getIdx());
                        r.setReviewItemCategory(c);
                    }

                    evaluateReviewItemCategoryRepository.deleteAllByJudgeIdx(e.getIdx());
                    c.setJudge(e);
                }

                evaluateJudgeRepository.deleteAllByEvaluateIdx(evaluate.getIdx());
                e.setEvaluate(evaluate);
            }

            evaluate.setJudgeList(newEvaluate.getJudgeList());

            evaluateRepository.save(evaluate);

            return "Evaluate edit complete";
        }

    }

    public String deleteEvaluate(EvaluateDTO evaluateDTO) {
        Evaluate evaluate = evaluateRepository.findById(evaluateDTO.getIdx()).orElse(null);

        if (evaluate == null) {
            return "Invalid Evaluate";
        } else {

            if (evaluate.getDeleted()) {
                return "Evaluate already deleted ";
            } else {
                evaluate.setDeleted(true);
                evaluateRepository.save(evaluate);

                return "Evaluate delete complete";
            }
        }
    }

}
