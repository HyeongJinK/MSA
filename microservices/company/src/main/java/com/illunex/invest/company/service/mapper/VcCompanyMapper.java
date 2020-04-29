package com.illunex.invest.company.service.mapper;

import com.illunex.invest.api.core.company.dto.*;
import com.illunex.invest.company.persistence.entity.*;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VcCompanyMapper {

    VcCompanyDTO vcCompanyEntityToDTO(Company company);
    List<VcCompanyDTO> vcCompanyEntityListToDTO(List<Company> companyList);

    MainProductLineDTO mainProductLineEntityToDTO(MainProductLine mainProductLine);
    List<MainProductLineDTO> mainProductLineEntityListToDTO(List<MainProductLine> mainProductLineList);

    VcProductDTO vcProductEntityToDTO(Product product);
    List<VcProductDTO> vcProductEntityListToDTO(List<Product> productList);

    ProductImageDTO productImageEntityToDTO(ProductImage productImage);
    List<ProductImageDTO> productImageEntityListToDTO(List<ProductImage> productImageList);

    KeywordDTO keywordEntityToDTO(Keyword keyword);
    List<KeywordDTO> keywordListEntityToDTO(List<Keyword> keywordList);

}

