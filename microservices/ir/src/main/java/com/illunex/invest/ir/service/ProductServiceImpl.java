package com.illunex.invest.ir.service;

import com.illunex.invest.api.core.ir.dto.ProductDTO;
import com.illunex.invest.ir.persistence.entity.*;
import com.illunex.invest.ir.persistence.repository.*;
import com.illunex.invest.ir.service.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl extends CommonIRService<ProductDTO> {
    private Log log = LogFactory.getLog(ProductServiceImpl.class);
    private ProductMapper productMapper = Mappers.getMapper(ProductMapper.class);

    @Autowired
    ProductRepository productRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    IPRepository ipRepository;
    @Autowired
    MarketRepository marketRepository;
    @Autowired
    MarketPlayerRepository marketPlayerRepository;

    @Override
    public ProductDTO get(Long irIdx) {
        ProductEntity productInfo = productRepository.findByIrIdx(irIdx);

        return productMapper.entityToDto(productInfo);
    }

    @Override
    @Transactional
    public String edit(ProductDTO productDTO) {
        ProductEntity productEntity = productMapper.dtoToEntity(productDTO);
        IREntity ir = irRepository.findById(productDTO.getIrIdx()).orElse(null);

        return editTemplate(ir, () -> {
            productEntity.setIdx(ir.getProduct().getIdx());
            editCustomer(productEntity);
            editIP(productEntity);
            editMarket(productEntity);
            editMarketPlayer(productEntity);
            productRepository.save(productEntity);
        }, "Cannot edit Product. Invalid IR Index."
        , "Product edit success");
    }

    private void editCustomer(ProductEntity productEntity) {
        customerRepository.deleteAllByProductIdx(productEntity.getIdx());
        for (CustomerEntity s: productEntity.getCustomer()){
            s.setProduct(productEntity);
        }
    }

    private void editIP(ProductEntity productEntity) {
        ipRepository.deleteAllByProductIdx(productEntity.getIdx());
        for (IPEntity s: productEntity.getIp()){
            s.setProduct(productEntity);
        }
    }

    private void editMarket(ProductEntity productEntity) {
        marketRepository.deleteAllByProductIdx(productEntity.getIdx());
        for (MarketEntity s: productEntity.getMarket()){
            s.setProduct(productEntity);
        }
    }

    private void editMarketPlayer(ProductEntity productEntity) {
        marketPlayerRepository.deleteAllByProductIdx(productEntity.getIdx());
        for (MarketPlayerEntity s: productEntity.getMarketPlayer()){
            s.setProduct(productEntity);
        }
    }
}
