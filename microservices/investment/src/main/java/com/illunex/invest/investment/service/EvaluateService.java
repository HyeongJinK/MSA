package com.illunex.invest.investment.service;

import com.illunex.invest.api.core.investment.dto.*;
import com.illunex.invest.investment.persistence.entity.*;
import com.illunex.invest.investment.persistence.repository.*;
import com.illunex.invest.investment.service.mapper.InvestmentMapper;
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

    private InvestmentMapper mapper = Mappers.getMapper(InvestmentMapper.class);

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

    public EvaluateStateListDTO getEvaluateStateList(Long companyIdx) {
        List<EvaluateStateDTO> evaluateStateDTOList = mapper.evaluateStateListEntityToDTO(evaluateRepository.findAllByVcCompanyIdxAndDeleted(companyIdx, false));
        return EvaluateStateListDTO.builder().evaluateState(evaluateStateDTOList).build();
    }

    public EvaluateCardListDTO getEvaluateCardList(Long companyIdx) {
        List<EvaluateCardDTO> evaluateCardDTOList = mapper.evaluateCardListEntityToDTO(evaluateRepository.findAllByVcCompanyIdxAndDeleted(companyIdx, false));
        return EvaluateCardListDTO.builder().evaluateList(evaluateCardDTOList).build();
    }

    public EvaluateListDTO getEvaluateHistory(Long companyIdx) {
        List<EvaluateDTO> evaluateDTOList = mapper.evaluateListEntityToDTO(evaluateRepository.findAllByVcCompanyIdxAndDeletedAndStatus(companyIdx, false, "complete"));
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

            for (EvaluateReviewItemCategory c : newEvaluate.getTemplate().getReviewItemCategory()) {
                for (EvaluateReviewItem i : c.getReviewItem()) {
                    evaluateReviewItemRepository.deleteAllByReviewItemCategoryIdx(c.getIdx());
                    i.setReviewItemCategory(c);
                }
                evaluateReviewItemCategoryRepository.deleteAllByReviewItemTemplateIdx(newEvaluate.getTemplate().getIdx());
                c.setReviewItemTemplate(newEvaluate.getTemplate());
            }

            for (EvaluateJudge j : newEvaluate.getJudgeList()) {
                if(j.getDivision().equals("attend")) {
                    for (EvaluateJudgeScore s : j.getScoreList()) {
                        evaluateJudgeScoreRepository.deleteAllByJudgeIdx(j.getIdx());
                        s.setJudge(j);
                    }
                }
                evaluateJudgeRepository.deleteAllByEvaluateIdx(newEvaluate.getIdx());
                j.setEvaluate(evaluate);
            }

            evaluateReviewItemTemplateRepository.deleteByEvaluateIdx(newEvaluate.getIdx());

            evaluate.setContent(newEvaluate.getContent());
            evaluate.setStatus(newEvaluate.getStatus());
            evaluate.setRequestDate(LocalDateTime.now());
            evaluate.setTemplate(newEvaluate.getTemplate());
            evaluate.setJudgeList(newEvaluate.getJudgeList());

            Evaluate editingEvaluate = evaluateRepository.save(evaluate);

            for (EvaluateJudge j : newEvaluate.getJudgeList()) {

                if(j.getDivision().equals("attend")) {
                    for (EvaluateReviewItemCategory c : editingEvaluate.getTemplate().getReviewItemCategory()) {
                        for (EvaluateReviewItem i : c.getReviewItem()) {
                            j.getScoreList().add(EvaluateJudgeScore.builder()
                                .categoryIdx(c.getIdx())
                                .reviewItemIdx(i.getIdx())
                                .score(0)
                                .judge(j)
                                .build());
                        }
                    }
                }

            }

            evaluateRepository.save(editingEvaluate);

            return "Evaluate edit complete";
        }
    }

    public String editComment(EvaluateCommentDTO evaluateCommentDTO) {
        Evaluate evaluate = evaluateRepository.findById(evaluateCommentDTO.getEvaluateIdx()).orElse(null);

        if (evaluate == null) {
            return "Invalid Evaluate";
        } else {
            for (EvaluateJudge j : evaluate.getJudgeList()) {
                if (j.getUserIdx().equals(evaluateCommentDTO.getUserIdx())) {
                    j.setComment(evaluateCommentDTO.getComment());
                    j.setStatus("complete");
                    j.setEvaluateDate(LocalDateTime.now());
                }
            }
            evaluateRepository.save(evaluate);
            return "Evaluate complete";
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

        if (evaluate == null) {
            return "Invalid Evaluate";
        } else {
            EvaluateJudge judge = mapper.evaluateJudgeDTOToEntity(evaluateReviewDTO.getJudge());
            int attendCount = 0;
            int completeCount = 0;

            for (EvaluateJudge e: evaluate.getJudgeList()) {
                if ( (e.getUserIdx().equals(evaluateReviewDTO.getJudge().getUserIdx())) && (e.getDivision().equals("attend")) )  {
                    attendCount++;
                    e.setStatus("confirm");

                    for (EvaluateJudgeScore j : e.getScoreList()) {
                        for (EvaluateJudgeScore s : judge.getScoreList()) {
                            if (j.getIdx().equals(s.getIdx())) {
                                j.setScore(s.getScore());
                            }
                        }
                    }

                    float judgeScore = 0;

                    for (EvaluateJudgeScore s : judge.getScoreList()) {

                        for (EvaluateReviewItemCategory c :evaluate.getTemplate().getReviewItemCategory()) {
                            int itemTotalScore = 0;

                            if (s.getCategoryIdx().equals(c.getIdx())) {
                                itemTotalScore += s.getScore();
                            }

                            if (evaluate.getTemplate().getWeightApply().equals(true)) {
                                judgeScore += ( (float)itemTotalScore / (c.getReviewItem().size()*10) * (float)c.getWeight() );
                            } else {
                                judgeScore += ( (float)itemTotalScore / (c.getReviewItem().size()*10) * (float)(100/evaluate.getTemplate().getReviewItemCategory().size()) );
                            }

                        }
                    }

                    e.setFinalScore((int)judgeScore);
                }

                if (e.getStatus().equals("complete")) completeCount++;
            }


            if (completeCount == attendCount) {
                float judgeTotalScore = 0;

                for (EvaluateJudge e: evaluate.getJudgeList()) {
                    judgeTotalScore += e.getFinalScore();
                }

                evaluate.setStatus("complete");
                evaluate.setAverageScore((int) (judgeTotalScore/completeCount));
                evaluate.setCompleteDate(LocalDateTime.now());
            }
            evaluateRepository.save(evaluate);
            return "Evaluate Review "+ evaluate.getStatus();
        }
    }
}
