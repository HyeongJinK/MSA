package com.illunex.invest.company.service.mapper;

import com.illunex.invest.api.core.company.dto.*;
import com.illunex.invest.company.persistence.entity.*;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDTO entityToDto(Product product);
    Product dtoToEntity(ProductDTO productDTO);

    List<ProductDTO> entityToDto(List<Product> product);
    List<Product> dtoToEntity(List<ProductDTO> productDTO);

    List<ProductImage> imageToEntity(List<ProductImageDTO> productImages);
    List<Keyword> keywordToEntity(List<KeywordDTO> keywords);
    Company companyToEntity(CompanyDTO company);

    MainProductDTO entityToDto(MainProduct mainProduct);
    MainProduct dtoToEntity(MainProductDTO mainProductDTO);

    List<ProductImageDTO> imageToDto(List<ProductImage> productImages);
    List<KeywordDTO> keywordToDto(List<Keyword> keywords);
    CompanyDTO companyToDto(Company company);
}
