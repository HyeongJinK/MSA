package com.illunex.invest.ir.service;

import com.illunex.invest.ir.persistence.entity.*;
import com.illunex.invest.ir.persistence.repository.*;
import com.illunex.invest.ir.service.mapper.ProductMapper;
import com.illunex.invest.api.core.ir.dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl extends CommonIRService<ProductDTO> {
    private Log log = LogFactory.getLog(ProductServiceImpl.class);
    private ProductMapper productMapper = Mappers.getMapper(ProductMapper.class);

    @Autowired
    ProductRepository productRepository;
    @Autowired
    IRRepository irRepository;
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


        if (irRepository.findById(productDTO.getIrIdx()).isEmpty()) {
            return "Cannot edit Product. Invalid IR Index.";
        } else {
            Long irIdx = productDTO.getIrIdx();
            productEntity.setIdx(irRepository.findById(irIdx).get().getProduct().getIdx());

            customerRepository.deleteAllByProductIdx(productEntity.getIdx());
            ipRepository.deleteAllByProductIdx(productEntity.getIdx());
            marketRepository.deleteAllByProductIdx(productEntity.getIdx());
            marketPlayerRepository.deleteAllByProductIdx(productEntity.getIdx());

            List<CustomerEntity> customerEntities = productEntity.getCustomer();
            List<IPEntity> ipEntities = productEntity.getIp();
            List<MarketEntity> marketEntities = productEntity.getMarket();
            List<MarketPlayerEntity> marketPlayerEntities = productEntity.getMarketPlayer();


            for (CustomerEntity c: customerEntities) {
                c.setProduct(productEntity);
            }
            for (IPEntity i: ipEntities) {
                i.setProduct(productEntity);
            }
            for (MarketEntity m: marketEntities) {
                m.setProduct(productEntity);
            }
            for (MarketPlayerEntity m: marketPlayerEntities) {
                m.setProduct(productEntity);
            }

            ProductEntity result = productRepository.save(productEntity);

            IREntity ir = irRepository.findById(irIdx).get();
            Progress progress = new Progress();
            String res = progress.progressCalculate(ir);
            ir.setProgress(res);
            ir.setUpdateDate(LocalDateTime.now());
            irRepository.save(ir);

            return "Product edit success";
        }
    }

}
