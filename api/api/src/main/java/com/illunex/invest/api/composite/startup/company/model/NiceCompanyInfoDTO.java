package com.illunex.invest.api.composite.startup.company.model;

import lombok.AllArgsConstructor;

import lombok.Getter;

@AllArgsConstructor
@Getter
public class NiceCompanyInfoDTO {
    private String korentrnm;   //업체명
    private String korreprnm;   //대표자명
    private String korIdscdnm;  //산업코드명
    private String obz_date;    //개업일자
    private String empnum;  // 종업원수
    private String scl; //기업규모
    private String ltgmktdivcd; //상장시장구분코드 (1 : 코스피 2 : 코스닥 3 : 코넥스 9 : 대상아님)
    private String zcd; //우편번호
    private String nolt_koraddr;    //지번주소

    public String getLtgmktdivcdStr() {
        switch (this.ltgmktdivcd) {
            case "1":
                return "코스피";
            case "2":
                return "코스닥";
            case "3":
                return "코넥스";
            default:
                return "";
        }
    }
}
