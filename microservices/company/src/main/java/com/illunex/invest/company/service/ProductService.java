package com.illunex.invest.company.service;

import com.illunex.invest.api.core.company.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getProductByCompanyIdx(Long companyId);
    ProductDTO edit(ProductDTO productDTO);
    ProductDTO read(Long productId);
}
