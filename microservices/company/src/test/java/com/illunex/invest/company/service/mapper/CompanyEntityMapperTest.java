package com.illunex.invest.company.service.mapper;

import com.illunex.invest.api.core.company.dto.CompanyDTO;
import com.illunex.invest.company.builder.CompanyBuilder;
import com.illunex.invest.company.persistence.entity.CompanyEntity;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CompanyEntityMapperTest {
    private CompanyMapper mapper = Mappers.getMapper(CompanyMapper.class);

    @Test
    public void entryToDtoTest() {
        assertNotNull(mapper);

        CompanyEntity entity = CompanyBuilder.getInstance()
                .companyIdx(1l)
                .name("Test")
                .entityBuild();

        CompanyDTO dto = mapper.entityToDto(entity);

        assertEquals(entity.getCompanyIdx(), dto.getCompanyIdx());
        assertEquals(entity.getName(), dto.getName());
    }

    @Test
    public void dtoToEntityTest() {
        assertNotNull(mapper);

        CompanyDTO dto = CompanyBuilder.getInstance()
                .companyIdx(1l)
                .name("Test")
                .dtoBuild();

        CompanyEntity entity = mapper.dtoToEntity(dto);

        assertEquals(entity.getCompanyIdx(), dto.getCompanyIdx());
        assertEquals(entity.getName(), dto.getName());
    }
}
