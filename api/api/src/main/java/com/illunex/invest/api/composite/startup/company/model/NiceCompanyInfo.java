package com.illunex.invest.api.composite.startup.company.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString
public class NiceCompanyInfo {
    private String amnisuyn;    // 관리종목여부
    private String bizno;   // 사업자번호
    private String bnk_brnm;    // 주거래은행지점명
    private String bnknm;   // 주거래은행명
    private String chulja;  // 출자제한그룹여부 (0 : 비대상, 1: 대상)
    private String crpno;   // 법인등록번호
    private String crprgrnstscd;    // 법인등기상태코드 (00:살아있는등기, 10:상호폐지, 20:청산종결, 21:청산종결간주, 30:파산, 40:해산, 41:합병해산, 42:해산간주, 43:조직변경해산, 44:분할해산, 51:회생절차, 55:보전관리, 63:회사정리절차개시결정, 89:기타폐쇄, 98:본점전출, 99:미등록번호)
    private String dtlcont; // 특기사항
    private String eml;     // 이메일
    private String empnum;  // 종업원수
    private String empnum_bse_date;     // 종업원수기준일자
    private String eng_bnknm;       // 주거래은행명
    private String eng_btpnm;       // 영문업종명
    private String eng_grpnm;       // 영문그룹명
    private String eng_idscdnm;     // 영문산업명
    private String eng_itemnm;      // 영문종목명
    private String eng_mainpdtpcl;      // 영문주요상품내역
    private String eng_scl;     // 영문기업규모
    private String engaddr;     // 영문도로명주소
    private String engaddr2;        // 영문도로명주소(공장)
    private String engaddr3;        // 영문도로명주소(영엄소)
    private String engentrnm;       // 영문업체명
    private String engreprnm;       // 영문대표자명
    private String epr_cnu_yn;      // 기업존속여부
    private String etbDate;     // 설립일자
    private String etl_ipc_yn;  // 외부감사여부
    private String faBseDate;   //재무기준일자
    private String fadivcd; //재무구분코드
    private String fax; //팩스번호
    private String fax2;    //팩스번호2
    private String fax3;    //팩스번호3
    private String gicd;    //그룹코드
    private String grpnm;   //그룹명
    private String homepurl;    //홈페이지URL
    private String hupegbn; //일반과세자 휴페업구분
    private String idscd;   //산업코드
    private String idscdid; //산업분류코드
    private String kiscode; //kis코드 업체코드
    private String koraddr; //도로명주소
    private String koraddr2;    //도로명주소2(공장)
    private String koraddr3;    //도로명주소3(영업소)
    private String korentrnm;   //업체명
    private String korIdscdnm;  //산업코드명
    private String korreprcd;   //대표자인물코드
    private String korreprnm;   //대표자명
    private String logo;    //로고url
    private String ltg_date;    //상장일자
    private String ltgmktdivcd; //상장시장구분코드 (1 : 코스피 2 : 코스닥 3 : 코넥스 9 : 대상아님)
    private String mainpdtpcl;  //주요상품내역
    private String mainupche;   //주력업체
    private String nolt_engaddr;    //영문지번주소
    private String nolt_engaddr2;   //영문지번주소(공장)
    private String nolt_engaddr3;   //영문지번주소(영업소)
    private String nolt_koraddr;    //지번주소
    private String nolt_koraddr2;   //지번주소2(공장)
    private String nolt_koraddr3;   //지번주소3(영업소)
    private String nts_sbqcdivcd;   //휴폐업구분코드 (00 : 미등록, 01 : 부가가치세 간이과세자, 02 :부가가치세 면세과세자, 03 : 부가가치제 일반과세자, 04 : 비영리법인 또는 단체국가기관, 05 : 폐업자, 06 : 휴업자, 07 : 고유번호식별단체, 98 : ERROR, 99 : 기타 )
    private String obz_date;    //개업일자
    private String opt_entrnm;  //정제업체
    private String sbn_date;    //창업일자
    private String sbqc_date;   //휴페업일자
    private String scl; //기업규모
    private String sforeign;    //특수기업정보-외 투기업
    private String sido;    //시도
    private String stacmm;  //결산월
    private String stkcd;   //주식코드
    private String tel; //전화번호
    private String tel2;    //전화번호(공장)
    private String tel3;    //전화번호(영업소)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss" , timezone = "Asia/Seoul")
    private Timestamp upt_dtm;  //갱신일시
    private String x;   //x좌표(TM좌표계)
    private String x2;  //x좌표(TM좌표계)(공장)
    private String x3;  //x좌표(TM좌표계)(영업소)
    private String y;   //y좌표(TM좌표계)
    private String y2;  //y좌표(TM좌표계)(공장)
    private String y3;  //y좌표(TM좌표계)(영업소)
    private String zarcd;   //우편번호구역(본사)
    private String zarcd2;  //우편번호구역(공장)
    private String zarcd3;  //우편번호구역(영업소)
    private String zcd; //우편번호
    private String zcd2;    //우편번호(공장)
    private String zcd3;    //우편번호(영업소)
    private String zipareaseq;  //우편구역일련번호(본사)
    private String zipareaseq2; //우편구역일련번호(공장)
    private String zipareaseq3; //우편구역일련번호(영업소)
}
