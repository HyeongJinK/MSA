package com.illunex.invest.ir.service;

import com.illunex.invest.ir.persistence.entity.BasicInfoEntity;
import com.illunex.invest.ir.persistence.entity.IREntity;
import com.illunex.invest.ir.persistence.repository.IRRepository;
import com.illunex.invest.api.core.ir.dto.AttractionDTO;
import com.illunex.invest.api.core.ir.dto.BasicInfoDTO;
import com.illunex.invest.api.core.ir.dto.SubsidyDTO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=RANDOM_PORT, properties = {
        "eureka.client.enabled=false",
        "spring.cloud.config.enabled=false",
        "spring.datasource.url=jdbc:h2:mem:basicInfo"})
@Transactional
public class BasicInfoServiceImplTest {

    @Autowired
    BasicInfoServiceImpl basicInfoServiceImpl;

    @MockBean
    IRRepository irRepository;

    @Before
    public void setup() {
        BasicInfoEntity basicInfoEntity = BasicInfoEntity.builder()
                .idx(1L)
                .build();

        IREntity irEntity = IREntity.builder()
                .idx(1L)
                .basicInfo(basicInfoEntity)
                .build();

        irRepository.save(irEntity);

        when(irRepository.findById(1L))
                .thenReturn(Optional.of(irEntity));
    }

    @Test
    public void editTest(){
        List<AttractionDTO> attractionDTO = new ArrayList<>();
        attractionDTO.add(AttractionDTO.builder()
                .name("123444")
                .build());
        attractionDTO.add(AttractionDTO.builder()
                .name("555")
                .build());

        List<SubsidyDTO> subsidyDTO = new ArrayList<>();
        subsidyDTO.add(SubsidyDTO.builder()
                .name("test")
                .value("test")
                .build());
        subsidyDTO.add(SubsidyDTO.builder()
                .name("test")
                .value("test")
                .build());

        BasicInfoDTO basicInfoDTO = BasicInfoDTO.builder()
                .irIdx(1L)
                .address("1234")
                .attraction(attractionDTO)
                .subsidy(subsidyDTO)
                .build();

        String result = basicInfoServiceImpl.edit(basicInfoDTO);

        Assert.assertEquals(result, "BasicInfo edit success");
    }

}