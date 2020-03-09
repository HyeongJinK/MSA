package com.illunex.invest.ir.service.mapper;

import com.illunex.invest.ir.persistence.entity.*;
import com.illunex.invest.api.core.ir.dto.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OutcomeMapper {
    OutcomeMapper MAPPER = Mappers.getMapper( OutcomeMapper.class );

    OutcomeDTO entityToDto(OutcomeEntity outcomeEntity);
    OutcomeEntity dtoToEntity(OutcomeDTO outcomeDTO);

    List<InvestEntity> investDtoListToEntity(List<InvestDTO> investDTOList);
    List<InvestDTO> investEntityListToDto(List<InvestEntity> investEntities);

    List<AwardEntity> awardDtoListToEntity(List<AwardDTO> awardDTOList);
    List<AwardDTO> awardEntityListToDto(List<AwardEntity> awardEntities);

    List<ExportEntity> exportDtoListToEntity(List<ExportDTO> exportDTOList);
    List<ExportDTO> exportEntityListToDto(List<ExportEntity> exportEntities);

    List<FundEntity> fundDtoListToEntity(List<FundDTO> fundDTOList);
    List<FundDTO> fundEntityListToDto(List<FundEntity> fundEntities);

    List<PlanEntity> planDtoListToEntity(List<PlanDTO> planDTOList);
    List<PlanDTO> planEntityListToDto(List<PlanEntity> planEntities);

}
