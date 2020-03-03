package com.illunex.invest.InvestorRelations.service;

import com.illunex.invest.InvestorRelations.persistence.entity.IREntity;

import java.util.List;

public class Progress {

    public boolean rowNullCheck(String row) {
        return row == null || row.equals("");
    }

    public boolean listNullCheck(List list){
        return list == null || list.isEmpty() || list.size() == 0;
    }

    public String progressCalculate(IREntity ir) {
        try {
            double calculateResult = 0;
            // 총 7페이지 각각 1/7씩 가지고 해당 페이지 안의 개수만큼 더 나누기

            if (!(ir.getBasicInfo() == null)) {
                int count = 0, total = 20;
                if (!rowNullCheck(ir.getBasicInfo().getAddress())) ++count;
                if (!rowNullCheck(ir.getBasicInfo().getBusiness())) ++count;
                if (!rowNullCheck(ir.getBasicInfo().getBusinessNumber())) ++count;
                if (!rowNullCheck(ir.getBasicInfo().getCeo())) ++count;
                if (!rowNullCheck(ir.getBasicInfo().getCompanyType())) ++count;
                if (!rowNullCheck(ir.getBasicInfo().getCorporateNumber())) ++count;
                if (!rowNullCheck(ir.getBasicInfo().getEmployeeCount())) ++count;
                if (!rowNullCheck(ir.getBasicInfo().getEquities())) ++count;
                if (!rowNullCheck(ir.getBasicInfo().getEstablishmentDate().toString())) ++count;
                if (!rowNullCheck(ir.getBasicInfo().getExitPlan())) ++count;
                if (!rowNullCheck(ir.getBasicInfo().getFaceValue())) ++count;
                if (!rowNullCheck(ir.getBasicInfo().getHomePage())) ++count;
                if (!rowNullCheck(ir.getBasicInfo().getName())) ++count;
                if (!rowNullCheck(ir.getBasicInfo().getPhone())) ++count;
                if (!rowNullCheck(ir.getBasicInfo().getSettlement())) ++count;
                if (!rowNullCheck(ir.getBasicInfo().getTotalStocks())) ++count;
                if (!rowNullCheck(ir.getBasicInfo().getUseInvestment())) ++count;
                if (!rowNullCheck(ir.getBasicInfo().getValuation())) ++count;
                if (!listNullCheck(ir.getBasicInfo().getAttraction())) ++count;
                if (!listNullCheck(ir.getBasicInfo().getSubsidy())) ++count;
                calculateResult += count / total;
            }

            if(!(ir.getHistory() == null)) {
                int count = 0, total = 1;
                if (!listNullCheck(ir.getHistory())) ++count;
                calculateResult += count / total;
            }

            if(!(ir.getMember() == null)) {
                int count = 0, total = 1;
                if (!listNullCheck(ir.getMember())) ++count;
                calculateResult += count / total;
            }

            if(!(ir.getShareholder() == null)) {
                int count = 0, total = 1;
                if (!listNullCheck(ir.getShareholder())) ++count;
                calculateResult += count / total;
            }

            if(!(ir.getFinance() == null)) {
                int count = 0, total = 27;
                if (!rowNullCheck(ir.getFinance().getCapital())) ++count;
                if (!rowNullCheck(ir.getFinance().getCost())) ++count;
                if (!rowNullCheck(ir.getFinance().getCurrentAsset())) ++count;
                if (!rowNullCheck(ir.getFinance().getCurrentLiabilities())) ++count;
                if (!rowNullCheck(ir.getFinance().getGrossProfit())) ++count;
                if (!rowNullCheck(ir.getFinance().getIntangibleAssets())) ++count;
                if (!rowNullCheck(ir.getFinance().getInventories())) ++count;
                if (!rowNullCheck(ir.getFinance().getInvestments())) ++count;
                if (!rowNullCheck(ir.getFinance().getNetIncome())) ++count;
                if (!rowNullCheck(ir.getFinance().getNonCurrentAssets())) ++count;
                if (!rowNullCheck(ir.getFinance().getNonCurrentLiabilities())) ++count;
                if (!rowNullCheck(ir.getFinance().getNonOperatingExpenses())) ++count;
                if (!rowNullCheck(ir.getFinance().getOperatingProfit())) ++count;
                if (!rowNullCheck(ir.getFinance().getOrdinaryProfit())) ++count;
                if (!rowNullCheck(ir.getFinance().getOtherAssets())) ++count;
                if (!rowNullCheck(ir.getFinance().getOtherComprehensiveIncome())) ++count;
                if (!rowNullCheck(ir.getFinance().getOtherRevenue())) ++count;
                if (!rowNullCheck(ir.getFinance().getQuickAsset())) ++count;
                if (!rowNullCheck(ir.getFinance().getRetainedEarnings())) ++count;
                if (!rowNullCheck(ir.getFinance().getSales())) ++count;
                if (!rowNullCheck(ir.getFinance().getSga())) ++count;
                if (!rowNullCheck(ir.getFinance().getSurplus())) ++count;
                if (!rowNullCheck(ir.getFinance().getTangibleAssets())) ++count;
                if (!rowNullCheck(ir.getFinance().getTax())) ++count;
                if (!rowNullCheck(ir.getFinance().getTotalCapital())) ++count;
                if (!rowNullCheck(ir.getFinance().getTotalLiabilities())) ++count;
                if (!listNullCheck(ir.getFinance().getFinancialStatus())) ++count;
                calculateResult += count / total;
            }

            if(!(ir.getProduct() == null)) {
                int count = 0, total = 10;
                if (!rowNullCheck(ir.getProduct().getMainTechnology())) ++count;
                if (!rowNullCheck(ir.getProduct().getMarketResearch())) ++count;
                if (!rowNullCheck(ir.getProduct().getPositioning())) ++count;
                if (!rowNullCheck(ir.getProduct().getProductDifference())) ++count;
                if (!rowNullCheck(ir.getProduct().getProductInformation())) ++count;
                if (!rowNullCheck(ir.getProduct().getTechnologyDifference())) ++count;
                if (!listNullCheck(ir.getProduct().getCustomer())) ++count;
                if (!listNullCheck(ir.getProduct().getIp())) ++count;
                if (!listNullCheck(ir.getProduct().getMarket())) ++count;
                if (!listNullCheck(ir.getProduct().getMarketPlayer())) ++count;
                calculateResult += count / total;
            }

            if(!(ir.getOutcome() == null)) {
                int count = 0, total = 5;
                if (!listNullCheck(ir.getOutcome().getInvest())) ++count;
                if (!listNullCheck(ir.getOutcome().getAward())) ++count;
                if (!listNullCheck(ir.getOutcome().getExport())) ++count;
                if (!listNullCheck(ir.getOutcome().getFund())) ++count;
                if (!listNullCheck(ir.getOutcome().getPlan())) ++count;
                calculateResult += count / total;
            }

//            ir.getBasicInfo() // 18개 + 리스트 2개 = 20
//            ir.getHistory() // 리스트 하나라도 작성되있으면 100%
//            ir.getMember() // 리스트 하나라도 작성되있으면 100%
//            ir.getShareholder() // 리스트 하나라도 작성되있으면 100%
//            ir.getFinance() // 26개 + 리스트 1개 = 27
//            ir.getProduct() // 6개 + 리스트 4개 = 10
//            ir.getOutcome() // 리스트 5개 = 5

            String result = Integer.toString((int)(calculateResult / 7 * 100));
            return result;
        } catch (Exception ex){
            return "Invalid IR Index";
        }
    }

}
