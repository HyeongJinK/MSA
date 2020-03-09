package com.illunex.invest.ir.controller;

import com.illunex.invest.ir.service.ProductServiceImpl;
import com.illunex.invest.api.core.ir.controller.ProductController;
import com.illunex.invest.api.core.ir.dto.ProductDTO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductControllerImpl implements ProductController {
    private Log log = LogFactory.getLog(ProductControllerImpl.class);

    final ProductServiceImpl productServiceImpl;

    public ProductControllerImpl(ProductServiceImpl productServiceImpl) {
        this.productServiceImpl = productServiceImpl;
    }

    @CrossOrigin("*")
    @GetMapping("/product")
    @Override
    public ResponseEntity<ProductDTO> getProductInfo(@RequestParam Long irIdx){
        ProductDTO productInfo = productServiceImpl.get(irIdx);

        if (productInfo == null) {
            return new ResponseEntity("ProductInfo does not exist", HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity(productInfo, HttpStatus.OK);
        }
    }

    @CrossOrigin("*")
    @PostMapping("/product")
    @Override
    public ResponseEntity<ProductDTO> editProductInfo(ProductDTO productInfo) {
        ProductDTO product = productServiceImpl.edit(productInfo);

        if (productInfo.getProductInformation().equals("unavailable")) {
            return new ResponseEntity("Cannot edit ProductInfo. Invalid IR Index.", HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity(product, HttpStatus.OK);
        }

    }
}
