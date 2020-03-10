package com.illunex.invest.company.service;

import com.illunex.invest.api.core.company.dto.ProductDTO;
import com.illunex.invest.company.persistence.repository.ProductRepository;
import com.illunex.invest.company.service.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Qualifier("CompanyProductService")
public class ProductServiceImpl implements ProductService {
    private ProductMapper mapper = Mappers.getMapper(ProductMapper.class);

    @Qualifier(value = "CompanyProductRepository")
    private final ProductRepository productRepository;

    @Override
    public List<ProductDTO> getProductByCompanyIdx(Long companyIdx) {
        return mapper.entityToDto(productRepository.findByCompanyCompanyIdx(companyIdx));
    }

    @Override
    public Page<ProductDTO> getProductPageByCompanyIdx(Long companyId) {
        return productRepository.findByCompanyCompanyIdx(companyId, PageRequest.of(1, 10));
    }

    @Override
    public ProductDTO edit(ProductDTO productDTO) {
        return mapper.entityToDto(productRepository.save(mapper.dtoToEntity(productDTO)));
    }

    @Override
    public ProductDTO read(Long productId) {
        return null;
    }
}
