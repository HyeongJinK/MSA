package com.illunex.invest.InvestorRelations.service;

import com.illunex.invest.InvestorRelations.service.mapper.BasicInfoMapper;
import com.illunex.invest.api.core.InvestorRelations.dto.AttractionDTO;
import com.illunex.invest.api.core.InvestorRelations.dto.BasicInfoDTO;
import com.illunex.invest.api.core.InvestorRelations.dto.SubsidyDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=RANDOM_PORT, properties = {
        "eureka.client.enabled=false",
        "spring.cloud.config.enabled=false",
        "spring.datasource.url=jdbc:h2:mem:IR"})
@Transactional
public class BasicInfoServiceImplTest {
    private BasicInfoMapper basicInfoMapper = Mappers.getMapper(BasicInfoMapper.class);

    @Autowired
    BasicInfoServiceImpl basicInfoService;

//    @MockBean
//    BasicInfoRepository basicInfoRepository;
//

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
                .address("1234")
                .attraction(attractionDTO)
                .subsidy(subsidyDTO)
                .build();




        BasicInfoDTO result = basicInfoService.edit(basicInfoDTO);

        Assert.assertEquals(result.getAddress(), "1234");
        Assert.assertEquals(result.getAttraction().get(0).getName(), "123444");
        Assert.assertEquals(result.getAttraction().get(1).getName(), "555");
        Assert.assertEquals(result.getSubsidy().get(0).getName(), "test");
        Assert.assertEquals(result.getSubsidy().get(0).getValue(), "test");


    }


}