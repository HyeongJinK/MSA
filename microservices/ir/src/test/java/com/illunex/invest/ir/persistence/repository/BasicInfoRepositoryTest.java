package com.illunex.invest.ir.persistence.repository;

import com.illunex.invest.ir.persistence.entity.AttractionEntity;
import com.illunex.invest.ir.persistence.entity.BasicInfoEntity;
import com.illunex.invest.ir.persistence.entity.SubsidyEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=RANDOM_PORT, properties = {
        "eureka.client.enabled=false",
        "spring.cloud.config.enabled=false",
        "spring.datasource.url=jdbc:h2:mem:BasicInfo"})
@Transactional
public class BasicInfoRepositoryTest {
    Logger log = LoggerFactory.getLogger(IRRepositoryTest.class);
    @Autowired
    private BasicInfoRepository basicInfoRepository;

    @Test
    public void edit(){
        List<AttractionEntity> attraction = new ArrayList<>();

        attraction.add(AttractionEntity.builder()
            .name("sadkfj")
            .build()
        );

        List<SubsidyEntity> subsidyEntities = new ArrayList<>();
        subsidyEntities.add(SubsidyEntity.builder()
                .name("test")
                .value("test")
                .build());

        BasicInfoEntity basicInfoEntity = BasicInfoEntity.builder()
            .address("123123")
            .attraction(attraction)
            .subsidy(subsidyEntities)
            .build();

        Long idx = basicInfoRepository.save(basicInfoEntity).getIdx();

        BasicInfoEntity findBasicInfoEntity = basicInfoRepository.findById(idx).get();

        Assert.assertEquals(findBasicInfoEntity.getAttraction().get(0).getName(), "sadkfj");
        Assert.assertEquals(findBasicInfoEntity.getSubsidy().get(0).getName(), "test");
    }

}