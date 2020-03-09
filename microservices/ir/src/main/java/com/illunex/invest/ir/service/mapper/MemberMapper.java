package com.illunex.invest.ir.service.mapper;

import com.illunex.invest.ir.persistence.entity.HistoryEntity;
import com.illunex.invest.ir.persistence.entity.MemberEntity;
import com.illunex.invest.api.core.ir.dto.HistoryDTO;
import com.illunex.invest.api.core.ir.dto.MemberDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    MemberMapper MAPPER = Mappers.getMapper( MemberMapper.class );

    MemberDTO entityToDto(MemberEntity memberEntity);
    MemberEntity dtoToEntity(MemberDTO memberDTO);

    List<MemberEntity> memberDtoListToEntity(List<MemberDTO> memberDTOS);
    List<MemberDTO> memberEntityListToDto(List<MemberEntity> memberEntities);

}
