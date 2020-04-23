package com.illunex.invest.investment.service;

import com.illunex.invest.api.core.investment.dto.EvaluateDTO;
import com.illunex.invest.api.core.investment.dto.EvaluateListDTO;
import com.illunex.invest.api.core.investment.dto.EvaluateReviewDTO;
import com.illunex.invest.investment.persistence.entity.*;
import com.illunex.invest.investment.persistence.repository.*;
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
    @Autowired EvaluateJudgeScoreRepository evaluateJudgeScoreRepository;
    @Autowired EvaluateReviewItemTemplateRepository evaluateReviewItemTemplateRepository;
    @Autowired EvaluateReviewItemCategoryRepository evaluateReviewItemCategoryRepository;
    @Autowired EvaluateReviewItemRepository evaluateReviewItemRepository;

    private InvestMentMapper mapper = Mappers.getMapper(InvestMentMapper.class);

    public String setEvaluate(EvaluateDTO evaluateDTO) {
        Evaluate evaluate = evaluateRepository.findByCompanyIdxAndVcCompanyIdx(evaluateDTO.getCompanyIdx(), evaluateDTO.getVcCompanyIdx());

        if (evaluate == null) {
            evaluateRepository.save(Evaluate.builder()
                .companyIdx(evaluateDTO.getCompanyIdx())
                .company(evaluateDTO.getCompany())
                .imgUrl(evaluateDTO.getImgUrl())
                .product(evaluateDTO.getProduct())
                .scale(evaluateDTO.getScale())
                .vcCompanyIdx(evaluateDTO.getVcCompanyIdx())
                .averageScore(0)
                .deleted(false)
                .status("waiting")
                .createDate(LocalDateTime.now())
                .build()
            );
            return "Evaluate set complete";
        } else {
            return "Already exists Evaluate";
        }

    }

    public EvaluateListDTO getEvaluateList(Long companyIdx) {
        List<EvaluateDTO> evaluateDTOList = mapper.evaluateListEntityToDTO(evaluateRepository.findAllByVcCompanyIdxAndDeleted(companyIdx, false));

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

            for (EvaluateJudge j : newEvaluate.getJudgeList()) {

                for (EvaluateJudgeScore s : j.getScoreList()) {
                    evaluateJudgeScoreRepository.deleteAllByJudgeIdx(j.getIdx());
                    s.setJudge(j);
                }

                evaluateJudgeRepository.deleteAllByEvaluateIdx(newEvaluate.getIdx());
                j.setEvaluate(evaluate);
            }

            for (EvaluateReviewItemCategory c : newEvaluate.getTemplate().getReviewItemCategory()) {

                for (EvaluateReviewItem i : c.getReviewItem()) {
                    evaluateReviewItemRepository.deleteAllByReviewItemCategoryIdx(c.getIdx());
                    i.setReviewItemCategory(c);
                }

                evaluateReviewItemCategoryRepository.deleteAllByReviewItemTemplateIdx(newEvaluate.getTemplate().getIdx());
                c.setReviewItemTemplate(newEvaluate.getTemplate());

            }

            evaluateReviewItemTemplateRepository.deleteByEvaluateIdx(newEvaluate.getIdx());
//            evaluateReviewItemTemplateRepository.save(newEvaluate.getTemplate());

            evaluate.setContent(newEvaluate.getContent());
            evaluate.setStatus(newEvaluate.getStatus());
            evaluate.setRequestDate(LocalDateTime.now());
            evaluate.setJudgeList(newEvaluate.getJudgeList());
            evaluate.setTemplate(newEvaluate.getTemplate());

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

    public String review(EvaluateReviewDTO evaluateReviewDTO) {
        Evaluate evaluate = evaluateRepository.findById(evaluateReviewDTO.getIdx()).orElse(null);

        return "Invalid Evaluate";

//        if (evaluate == null) {
//            return "Invalid Evaluate";
//        } else {
//            EvaluateJudge judge = mapper.evaluateJudgeDTOToEntity(evaluateReviewDTO.getJudge());
//            int completeCount = 0;
//
//            for (EvaluateJudge e: evaluate.getJudgeList()) {
//                if (e.getUserIdx().equals(evaluateReviewDTO.getJudge().getUserIdx())) {
//                    e.setEvaluateDate(LocalDateTime.now());
//                    e.setStatus("complete");
//                    e.setReviewItemCategory(judge.getReviewItemCategory());
//
//                    for(EvaluateReviewItemCategory c: e.getReviewItemCategory()) {
//                        c.setJudge(e);
//                        for(EvaluateReviewItem i: c.getReviewItem()) {
//                            i.setReviewItemCategory(c);
//                        }
//                    }
//                }
//
//                if (e.getStatus().equals("complete")) completeCount++;
//            }
//
//            if (completeCount == evaluate.getJudgeList().size()) {
//                float judgeTotalScore = 0;
//
//                for (EvaluateJudge e: evaluate.getJudgeList()) {
//
//                    float judgeScore = 0;
//
//                    for (EvaluateReviewItemCategory c: e.getReviewItemCategory()) {
//                        int itemTotalScore = 0;
//                        float categoryTotalScore;
//                        for (EvaluateReviewItem i: c.getReviewItem()) {
//                            itemTotalScore += i.getPoint();
//                        }
//
//                        categoryTotalScore = ( (float)itemTotalScore / (c.getReviewItem().size()*10) * (float)c.getWeight() );
//
//                        judgeScore += categoryTotalScore;
//                    }
//
//                    judgeTotalScore += judgeScore;
//
//                    e.setScore((int)judgeScore);
//
//                }
//
//                evaluate.setStatus("complete");
//                evaluate.setScore((int) (judgeTotalScore/3));
//                evaluate.setCompleteDate(LocalDateTime.now());
//            }
//
//            evaluateRepository.save(evaluate);
//            return "Evaluate Review "+ evaluate.getStatus();
//        }
    }

}
