package com.illunex.invest.company.service.mapper;

import com.illunex.invest.api.core.company.dto.CompanyDTO;
import com.illunex.invest.company.builder.CompanyBuilder;
import com.illunex.invest.company.persistence.entity.Company;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CompanyMapperTest {
    private CompanyMapper mapper = Mappers.getMapper(CompanyMapper.class);

    @Test
    public void entryToDtoTest() {
        assertNotNull(mapper);

        Company entity = Company.builder()
                .companyIdx(1l)
                .name("Test")
                .build();

        CompanyDTO dto = mapper.entityToDto(entity);

        assertEquals(entity.getCompanyIdx(), dto.getCompanyIdx());
        assertEquals(entity.getName(), dto.getName());
    }

    @Test
    public void dtoToEntityTest() {
        assertNotNull(mapper);

        CompanyDTO dto = CompanyDTO.builder()
                .companyIdx(1l)
                .name("Test")
                .build();

        Company entity = mapper.dtoToEntity(dto);

        assertEquals(entity.getCompanyIdx(), dto.getCompanyIdx());
        assertEquals(entity.getName(), dto.getName());
    }
}
