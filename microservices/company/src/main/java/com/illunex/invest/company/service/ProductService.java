package com.illunex.invest.company.service;

import com.illunex.invest.api.core.company.dto.ProductDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getProductByCompanyIdx(Long companyId);
    Page<ProductDTO> getProductPageByCompanyIdx(Long companyId);
    ProductDTO edit(ProductDTO productDTO);
    ProductDTO read(Long productId);
}
