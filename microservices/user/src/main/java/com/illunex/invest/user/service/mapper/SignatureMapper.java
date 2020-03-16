package com.illunex.invest.user.service.mapper;

import com.illunex.invest.api.core.user.dto.SignatureDTO;
import com.illunex.invest.user.persistence.entity.Signature;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SignatureMapper {
    SignatureDTO entityToDto(Signature signature);
    Signature dtoToEntity(SignatureDTO signatureDTO);

    List<SignatureDTO> entityToDto(List<Signature> signature);
    List<Signature> dtoToEntity(List<SignatureDTO> signatureDTO);
}
