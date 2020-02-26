package com.illunex.invest.company.builder;

import com.illunex.invest.api.core.company.dto.CompanyDTO;
import com.illunex.invest.api.core.company.dto.CompanyMemberDTO;
import com.illunex.invest.api.core.company.dto.CompanyProductDTO;
import com.illunex.invest.company.persistence.entity.CompanyEntity;
import com.illunex.invest.company.persistence.entity.CompanyMemberEntity;
import com.illunex.invest.company.persistence.entity.CompanyProductEntity;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
public class CompanyBuilder {
    Long companyIdx;
    Long userIdx;
    String logo;
    String name;
    String businessNumber;
    String companyType;
    LocalDateTime establishmentDate;
    String employeeCount;
    String business;
    String nation;
    String stocksList;
    String zipCode;
    String address;
    String addressDetail;
    String mainProductLine;
    String description;
    String homePage;
    List<CompanyProductEntity> companyProducts;
    List<CompanyMemberEntity> companyMembers;
    List<CompanyProductDTO> companyProductsDTO;
    List<CompanyMemberDTO> companyMembersDTO;

    public static CompanyBuilder getInstance() {
        return new CompanyBuilder();
    }

    public CompanyBuilder companyIdx(Long companyIdx) {
        this.companyIdx = companyIdx; return this;
    }
    public CompanyBuilder userIdx(Long userIdx) {
        this.userIdx = userIdx; return this;
    }
    public CompanyBuilder logo(String logo) {
        this.logo = logo; return this;
    }
    public CompanyBuilder name(String name) {
        this.name = name; return this;
    }
    public CompanyBuilder businessNumber(String businessNumber) {
        this.businessNumber = businessNumber; return this;
    }
    public CompanyBuilder companyType(String companyType) {
        this.companyType = companyType; return this;
    }
    public CompanyBuilder establishmentDate(LocalDateTime establishmentDate) {
        this.establishmentDate = establishmentDate; return this;
    }
    public CompanyBuilder employeeCount(String employeeCount) {
        this.employeeCount = employeeCount; return this;
    }
    public CompanyBuilder business(String business) {
        this.business = business; return this;
    }
    public CompanyBuilder nation(String nation) {
        this.nation = nation; return this;
    }
    public CompanyBuilder stocksList(String stocksList) {
        this.stocksList = stocksList; return this;
    }
    public CompanyBuilder zipCode(String zipCode) {
        this.zipCode = zipCode; return this;
    }
    public CompanyBuilder address(String address) {
        this.address = address; return this;
    }
    public CompanyBuilder addressDetail(String addressDetail) {
        this.addressDetail = addressDetail; return this;
    }
    public CompanyBuilder mainProductLine(String mainProductLine) {
        this.mainProductLine = mainProductLine; return this;
    }
    public CompanyBuilder description(String description) {
        this.description = description; return this;
    }
    public CompanyBuilder homePage(String homePage) {
        this.homePage = homePage; return this;
    }
    public CompanyBuilder companyProducts(List<CompanyProductEntity> companyProducts) {
        this.companyProducts = companyProducts; return this;
    }
    public CompanyBuilder companyMembers(List<CompanyMemberEntity> companyMembers) {
        this.companyMembers = companyMembers; return this;
    }
    public CompanyBuilder companyProductsDTO(List<CompanyProductDTO> companyProductsDTO) {
        this.companyProductsDTO = companyProductsDTO; return this;
    }
    public CompanyBuilder companyMembersDTO(List<CompanyMemberDTO> companyMembersDTO) {
        this.companyMembersDTO = companyMembersDTO; return this;
    }

    public CompanyEntity entityBuild(){
        return new CompanyEntity(companyIdx, userIdx, logo, name, businessNumber
                , companyType, establishmentDate, employeeCount, business, nation
                , stocksList, zipCode, address, addressDetail, mainProductLine
                , description, homePage, companyProducts, companyMembers);
    }
    public CompanyDTO dtoBuild() {
        return new CompanyDTO(companyIdx, userIdx, logo, name, businessNumber
                , companyType, establishmentDate, employeeCount, business, nation
                , stocksList, zipCode, address, addressDetail, mainProductLine
                , description, homePage, companyProductsDTO, companyMembersDTO);
    }
}
