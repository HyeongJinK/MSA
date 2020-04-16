package com.illunex.invest.company.service;

import com.illunex.invest.api.core.company.dto.ProductDTO;
import com.illunex.invest.company.persistence.entity.Product;
import com.illunex.invest.company.persistence.repository.ProductRepository;
import com.illunex.invest.company.service.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Qualifier("CompanyProductService")
@Transactional(readOnly = true)
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
    @Transactional
    public ProductDTO edit(ProductDTO productDTO) {
        if (productDTO.getId() == null || productDTO.getId().equals(0l)) {
            productDTO.setRegDate(LocalDateTime.now());
        }
        return mapper.entityToDto(productRepository.save(mapper.dtoToEntity(productDTO)));
    }

    @Override
    public ProductDTO read(Long productId) {
        Product product = productRepository.findById(productId).orElse(null);
        if (product == null) {
            // TODO
        }

        product.setCompany(product.getCompany());

        return mapper.entityToDto(product);
    }
}
