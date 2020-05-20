package com.illunex.invest.company.service.mapper;

import com.illunex.invest.api.core.company.dto.CompanyIdDTO;
import com.illunex.invest.api.core.company.dto.CorporateSealDTO;
import com.illunex.invest.company.persistence.entity.CorporateSeal;
import org.junit.Assert;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

import java.util.Optional;

public class CorporateSealMapperTest {
    private CorporateSealMapper mapper = Mappers.getMapper(CorporateSealMapper.class);

    @Test
    public void dtoToEntityTest() {
        CorporateSealDTO dto = CorporateSealDTO
                .builder()
                .company(CompanyIdDTO
                        .builder()
                        .companyIdx(1L)
                        .build()
                )
                .build();

        CorporateSeal entity = mapper.dtoToEntity(dto);

        Assert.assertEquals(java.util.Optional.ofNullable(entity.getCompany().getCompanyIdx()), Optional.of(1L));
    }
}
