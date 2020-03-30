package com.illunex.invest.company.service.mapper;

import com.illunex.invest.api.core.company.dto.ShareholderDTO;
import com.illunex.invest.company.persistence.entity.Shareholder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ShareholderMapper {
    ShareholderDTO entityToDto(Shareholder shareholder);
    Shareholder dtoToEntity(ShareholderDTO shareholderDTO);
    List<ShareholderDTO> entityToDto(List<Shareholder> list);
    List<Shareholder> dtoToEntity(List<ShareholderDTO> list);
}
