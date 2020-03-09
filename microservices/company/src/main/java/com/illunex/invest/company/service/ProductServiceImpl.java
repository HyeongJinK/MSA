package com.illunex.invest.company.service;

import com.illunex.invest.api.core.company.dto.ProductDTO;
import com.illunex.invest.company.persistence.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<ProductDTO> getProductByCompanyIdx(Long companyIdx) {

        return null;
    }

    @Override
    public ProductDTO edit(ProductDTO productDTO) {
        return null;
    }

    @Override
    public ProductDTO read(Long productId) {
        return null;
    }
}
