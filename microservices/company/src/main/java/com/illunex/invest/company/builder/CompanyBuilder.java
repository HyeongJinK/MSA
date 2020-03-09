package com.illunex.invest.company.builder;

import com.illunex.invest.api.core.company.dto.CompanyDTO;
import com.illunex.invest.api.core.company.dto.MainProductLineDTO;
import com.illunex.invest.api.core.company.dto.MemberDTO;
import com.illunex.invest.api.core.company.dto.ProductDTO;
import com.illunex.invest.company.persistence.entity.Company;
import com.illunex.invest.company.persistence.entity.MainProductLine;
import com.illunex.invest.company.persistence.entity.Member;
import com.illunex.invest.company.persistence.entity.Product;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
public class CompanyBuilder {
    Long companyIdx;
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
    String description;
    String homePage;
    List<Product> products;
    List<Member> members;
    List<MainProductLine> mainProductLines;
    List<MainProductLineDTO> mainProductLinesDTO;
    List<ProductDTO> companyProductsDTO;
    List<MemberDTO> companyMembersDTO;

    public static CompanyBuilder getInstance() {
        return new CompanyBuilder();
    }

    public CompanyBuilder companyIdx(Long companyIdx) {
        this.companyIdx = companyIdx; return this;
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
    public CompanyBuilder description(String description) {
        this.description = description; return this;
    }
    public CompanyBuilder homePage(String homePage) {
        this.homePage = homePage; return this;
    }
    public CompanyBuilder mainProductLines(List<MainProductLine> mainProductLines) {
        this.mainProductLines = mainProductLines; return this;
    }
    public CompanyBuilder mainProductLinesDTO(List<MainProductLineDTO> mainProductLineDTO) {
        this.mainProductLinesDTO = mainProductLineDTO; return this;
    }
    public CompanyBuilder companyProducts(List<Product> products) {
        this.products = products; return this;
    }
    public CompanyBuilder companyMembers(List<Member> members) {
        this.members = members; return this;
    }
    public CompanyBuilder companyProductsDTO(List<ProductDTO> companyProductsDTO) {
        this.companyProductsDTO = companyProductsDTO; return this;
    }
    public CompanyBuilder companyMembersDTO(List<MemberDTO> companyMembersDTO) {
        this.companyMembersDTO = companyMembersDTO; return this;
    }

    public Company entityBuild(){
        return new Company(companyIdx, logo, name, businessNumber
                , companyType, establishmentDate, employeeCount, business, nation
                , stocksList, zipCode, address, addressDetail
                , description, homePage, mainProductLines, products, members);
    }
    public CompanyDTO dtoBuild() {
        return new CompanyDTO(companyIdx, logo, name, businessNumber
                , companyType, establishmentDate, employeeCount, business, nation
                , stocksList, zipCode, address, addressDetail
                , description, homePage, mainProductLinesDTO, companyProductsDTO, companyMembersDTO);
    }
}
