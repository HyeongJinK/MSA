package com.illunex.invest.shop.service.mapper

import com.illunex.invest.api.core.shop.dto.ProductDTO
import com.illunex.invest.api.core.shop.dto.ProductDTOBuilder
import com.illunex.invest.api.core.shop.enumable.ProductState
import com.illunex.invest.shop.persistence.entity.Product
import com.illunex.invest.shop.persistence.entity.Purchase

class ProductMapper {
    fun productDtoTOEntity(product: Product): ProductDTO {
        var productDto: ProductDTO = ProductDTO();

        return productDto;
    }

    fun productDtoListToEntityList(products: List<Product>, purchases: List<Purchase>): List<ProductDTO> {
        var productDtoList: ArrayList<ProductDTO> = ArrayList()

//        if (purchases == null) {
//            for (product in products) {
//                createProductDto(productDtoList, product, ProductState.NONE);
//            }
//        } else {
//            for (product in products) {
//                for (purchase in purchases) {
//                    if (product.id.equals(purchase.get))
//                }
//            }
//        }


        return productDtoList;
    }

    private fun createProductDto(productDtoList: ArrayList<ProductDTO>, product: Product, productState: ProductState) {
        productDtoList.add(ProductDTOBuilder.builder()
                .id(product.id)
                .title(product.title)
                .description(product.description)
                .price(product.price)
                .productState(productState)
                .build());
    }
}