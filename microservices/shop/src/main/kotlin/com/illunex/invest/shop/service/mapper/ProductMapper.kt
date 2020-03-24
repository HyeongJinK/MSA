package com.illunex.invest.shop.service.mapper

import com.illunex.invest.api.core.shop.dto.ProductDTO
import com.illunex.invest.api.core.shop.builder.ProductDTOBuilder
import com.illunex.invest.api.core.shop.enumable.ProductState
import com.illunex.invest.api.core.shop.enumable.ViewMode
import com.illunex.invest.shop.persistence.entity.Product

class ProductMapper {
    fun DtoTOEntity(product: Product): ProductDTO {
        var productDto: ProductDTO = ProductDTO();

        return productDto;
    }

    fun DtoTOEntity(products: List<Product>): List<ProductDTO> {
        var productDtoList: ArrayList<ProductDTO> = ArrayList()

        products.stream().forEach { product ->
            run {
                productDtoList.add(ProductDTO(product.id
                        , product.title
                        , product.description
                        , product.imgUrl
                        , product.price
                        , product.viewMode
                        , false))
            }
        }

        return productDtoList;
    }

    private fun createProductDto(productDtoList: ArrayList<ProductDTO>, product: Product, productState: ProductState) {
        productDtoList.add(ProductDTOBuilder.builder()
                .id(product.id)
                .title(product.title)
                .description(product.description)
                .price(product.price)
                .view(ViewMode.OPEN)
                .build());
    }
}