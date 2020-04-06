package com.illunex.invest.startup.controller.company;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.common.response.ResponseList;
import com.illunex.invest.api.composite.startup.company.controller.ProductCompositeController;
import com.illunex.invest.api.core.company.dto.ProductDTO;
import com.illunex.invest.startup.controller.StartupDefaultController;
import com.illunex.invest.startup.service.company.ProductCompositeIntegration;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class ProductCompositeControllerImpl extends StartupDefaultController implements ProductCompositeController {
    private final ProductCompositeIntegration productCompositeIntegration;

    @Override
    public ResponseEntity<ResponseList> productList() {
        return ResponseEntity.ok(new ResponseList(0
                , "success"
                , productCompositeIntegration.getProductList()));
    }

    @Override
    public ResponseEntity<ResponseData> editProduct(ProductDTO productDTO) {
        return ResponseEntity.ok(ResponseData.builder()
                .errorCode(0)
                .message("success")
                .data(productCompositeIntegration.editProduct(productDTO))
                .build());
    }

    @Override
    public ResponseEntity<ResponseData> uploadImage(MultipartFile file) {
        return ResponseEntity.ok(ResponseData.builder()
                .errorCode(0)
                .message("success")
                .data(productCompositeIntegration.uploadLogo(file))
                .build());
    }

    @Override
    public ResponseEntity<ResponseData> readProduct(Long productId) {
        return ResponseEntity.ok(ResponseData.builder()
                .errorCode(0)
                .message("success")
                .data(productCompositeIntegration.getProduct(productId))
                .build());
    }

    @Override
    public ResponseEntity<ResponseData> deleteProduct(Long productId) {
        return null;
    }
}
