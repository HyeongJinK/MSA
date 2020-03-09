package com.illunex.invest.company.service.mapper;

import com.illunex.invest.api.core.company.dto.CompanyDTO;
import com.illunex.invest.api.core.company.dto.KeywordDTO;
import com.illunex.invest.api.core.company.dto.ProductDTO;
import com.illunex.invest.api.core.company.dto.ProductImageDTO;
import com.illunex.invest.company.persistence.entity.Company;
import com.illunex.invest.company.persistence.entity.Keyword;
import com.illunex.invest.company.persistence.entity.Product;
import com.illunex.invest.company.persistence.entity.ProductImage;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDTO entityToDto(Product product);
    Product dtoToEntity(ProductDTO productDTO);

    List<ProductImage> imageToEntity(List<ProductImageDTO> productImages);
    List<Keyword> keywordToEntity(List<KeywordDTO> keywords);
    Company companyToEntity(CompanyDTO company);

    List<ProductImageDTO> imageToDto(List<ProductImage> productImages);
    List<KeywordDTO> keywordToDto(List<Keyword> keywords);
    CompanyDTO companyToDto(Company company);
}
