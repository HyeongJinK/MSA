package com.illunex.invest.ir.persistence.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "ir")
public class IREntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idx;
    String year;            // 년도
    Long companyIdx;        // 회사 기본키
    Boolean isPassword;     // 패스워드 사용유/무
    String password;        // 패스워드
    String progress;        // 작성 %
    String cardColor;       // 카드 색상
    LocalDateTime updateDate;        // 마지막 수정일
    Integer readCount;      // 조회수

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="basic_info_idx")
    BasicInfoEntity basicInfo;                              // 기본정보

    @OneToMany(mappedBy = "ir")
    List<HistoryEntity> history;                            // 주요연혁

    @OneToMany(mappedBy = "ir")
    List<MemberEntity> member;                              // 주요인력

    @OneToMany(mappedBy = "ir")
    List<ShareholderEntity> shareholder;                    // 주주현황

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="finance_idx")
    FinanceEntity finance;                                  // 재무현황

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="product_idx")
    ProductEntity product;                                  // 제품,기술,시장

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="outcome_idx")
    OutcomeEntity outcome;                                  // 성과 및 계획

    public boolean rowNullCheck(String row) {
        return row == null || row.equals("");
    }

    public boolean listNullCheck(List list){
        return list == null || list.isEmpty() || list.size() == 0;
    }

    public void progressCalculate() {
        try {
            double calculateResult = 0;
            // 총 7페이지 각각 1/7씩 가지고 해당 페이지 안의 개수만큼 더 나누기

            if (!(getBasicInfo() == null)) {
                int count = 0, total = 20;
                if (!rowNullCheck(getBasicInfo().getAddress())) ++count;
                if (!rowNullCheck(getBasicInfo().getBusiness())) ++count;
                if (!rowNullCheck(getBasicInfo().getBusinessNumber())) ++count;
                if (!rowNullCheck(getBasicInfo().getCeo())) ++count;
                if (!rowNullCheck(getBasicInfo().getCompanyType())) ++count;

                if (!rowNullCheck(getBasicInfo().getCorporateNumber())) ++count;
                if (!rowNullCheck(getBasicInfo().getEmployeeCount())) ++count;
                if (!rowNullCheck(getBasicInfo().getEquities())) ++count;
                if (!rowNullCheck(getBasicInfo().getEstablishmentDate())) ++count;
                if (!rowNullCheck(getBasicInfo().getExitPlan())) ++count;

                if (!rowNullCheck(getBasicInfo().getFaceValue())) ++count;
                if (!rowNullCheck(getBasicInfo().getHomePage())) ++count;
                if (!rowNullCheck(getBasicInfo().getName())) ++count;
                if (!rowNullCheck(getBasicInfo().getPhone())) ++count;
                if (!rowNullCheck(getBasicInfo().getSettlement())) ++count;

                if (!rowNullCheck(getBasicInfo().getTotalStocks())) ++count;
                if (!rowNullCheck(getBasicInfo().getUseInvestment())) ++count;
                if (!rowNullCheck(getBasicInfo().getValuation())) ++count;
                if (!listNullCheck(getBasicInfo().getAttraction())) ++count;
                if (!listNullCheck(getBasicInfo().getSubsidy())) ++count;
                calculateResult += count / total;
            }

            if(!(getHistory() == null)) {
                int count = 0, total = 1;
                if (!listNullCheck(getHistory())) ++count;
                calculateResult += count / total;
            }

            if(!(getMember() == null)) {
                int count = 0, total = 1;
                if (!listNullCheck(getMember())) ++count;
                calculateResult += count / total;
            }

            if(!(getShareholder() == null)) {
                int count = 0, total = 1;
                if (!listNullCheck(getShareholder())) ++count;
                calculateResult += count / total;
            }

            if(!(getFinance() == null)) {
                int count = 0, total = 21;
                if (!rowNullCheck(getFinance().getCapital())) ++count;
                if (!rowNullCheck(getFinance().getCost())) ++count;
                if (!rowNullCheck(getFinance().getOtherCurrentAsset())) ++count;
                if (!rowNullCheck(getFinance().getCurrentLiabilities())) ++count;
                if (!rowNullCheck(getFinance().getIntangibleAssets())) ++count;

                if (!rowNullCheck(getFinance().getInventories())) ++count;
                if (!rowNullCheck(getFinance().getInvestments())) ++count;
                if (!rowNullCheck(getFinance().getOtherNonCurrentAssets())) ++count;
                if (!rowNullCheck(getFinance().getNonCurrentLiabilities())) ++count;
                if (!rowNullCheck(getFinance().getNonOperatingExpenses())) ++count;

                if (!rowNullCheck(getFinance().getCapitalAdjustment())) ++count;
                if (!rowNullCheck(getFinance().getOtherComprehensiveIncome())) ++count;
                if (!rowNullCheck(getFinance().getOtherRevenue())) ++count;
                if (!rowNullCheck(getFinance().getQuickAsset())) ++count;
                if (!rowNullCheck(getFinance().getRetainedEarnings())) ++count;

                if (!rowNullCheck(getFinance().getSales())) ++count;
                if (!rowNullCheck(getFinance().getSga())) ++count;
                if (!rowNullCheck(getFinance().getSurplus())) ++count;
                if (!rowNullCheck(getFinance().getTangibleAssets())) ++count;
                if (!rowNullCheck(getFinance().getTax())) ++count;

                if (!listNullCheck(getFinance().getFinancialStatus())) ++count;
                calculateResult += count / total;
            }

            if(!(getProduct() == null)) {
                int count = 0, total = 10;
                if (!rowNullCheck(getProduct().getMainTechnology())) ++count;
                if (!rowNullCheck(getProduct().getMarketResearch())) ++count;
                if (!rowNullCheck(getProduct().getPositioning())) ++count;
                if (!rowNullCheck(getProduct().getProductDifference())) ++count;
                if (!rowNullCheck(getProduct().getProductInformation())) ++count;

                if (!rowNullCheck(getProduct().getTechnologyDifference())) ++count;
                if (!listNullCheck(getProduct().getCustomer())) ++count;
                if (!listNullCheck(getProduct().getIp())) ++count;
                if (!listNullCheck(getProduct().getMarket())) ++count;
                if (!listNullCheck(getProduct().getMarketPlayer())) ++count;
                calculateResult += count / total;
            }

            if(!(getOutcome() == null)) {
                int count = 0, total = 5;
                if (!listNullCheck(getOutcome().getInvest())) ++count;
                if (!listNullCheck(getOutcome().getAward())) ++count;
                if (!listNullCheck(getOutcome().getExport())) ++count;
                if (!listNullCheck(getOutcome().getFund())) ++count;
                if (!listNullCheck(getOutcome().getPlan())) ++count;
                calculateResult += count / total;
            }

//            getBasicInfo() // 18개 + 리스트 2개 = 20
//            getHistory() // 리스트 하나라도 작성되있으면 100%
//            getMember() // 리스트 하나라도 작성되있으면 100%
//            getShareholder() // 리스트 하나라도 작성되있으면 100%
//            getFinance() // 26개 + 리스트 1개 = 27
//            getProduct() // 6개 + 리스트 4개 = 10
//            getOutcome() // 리스트 5개 = 5

            this.progress = Integer.toString((int)(calculateResult / 7 * 100));
            this.updateDate = LocalDateTime.now();
        } catch (Exception ex){
            this.progress = "Invalid IR Index";
        }
    }
}
