package com.illunex.invest.InvestorRelations.service.mapper;

import com.illunex.invest.InvestorRelations.persistence.entity.*;
import com.illunex.invest.api.core.InvestorRelations.dto.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper MAPPER = Mappers.getMapper( ProductMapper.class );

    ProductDTO entityToDto(ProductEntity productEntity);
    ProductEntity dtoToEntity(ProductDTO productDTO);

    List<CustomerEntity> customerDtoListToEntity(List<CustomerDTO> customerDTOList);
    List<CustomerDTO> customerEntityListToDto(List<CustomerEntity> customerEntities);

    List<IPEntity> ipDtoListToEntity(List<IPDTO> ipDTOList);
    List<IPDTO> ipEntityListToDto(List<IPEntity> ipEntities);

    List<MarketEntity> marketDtoListToEntity(List<MarketDTO> marketDTOList);
    List<MarketDTO> marketEntityListToDto(List<MarketEntity> marketEntities);

    List<MarketPlayerEntity> marketPlayerDtoListToEntity(List<MarketPlayerDTO> marketPlayerDTOList);
    List<MarketPlayerDTO> marketPlayerEntityListToDto(List<MarketPlayerEntity> marketPlayerEntities);

}
