package com.illunex.invest.InvestorRelations.persistence.repository;

import com.illunex.invest.InvestorRelations.persistence.entity.BasicInfoEntity;
import com.illunex.invest.InvestorRelations.persistence.entity.IREntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=RANDOM_PORT, properties = {
        "eureka.client.enabled=false",
        "spring.cloud.config.enabled=false",
        "spring.datasource.url=jdbc:h2:mem:IR"})
@Transactional
public class IRRepositoryTest {
    Logger log = LoggerFactory.getLogger(IRRepositoryTest.class);
    @Autowired
    private IRRepository irRepository;

    @Test
    public void saveRepository() {
        BasicInfoEntity basicInfoEntity = BasicInfoEntity.builder()
                .address("askdfj")
                .build();
        IREntity irEntity = IREntity.builder()
                .companyIdx(1L)
                .basicInfo(basicInfoEntity)
                .build();
        basicInfoEntity.setIr(irEntity);


        Long idx = irRepository.save(irEntity).getIdx();
        IREntity findEntity = irRepository.findById(idx).get();

        Assert.assertEquals(findEntity.getBasicInfo().getIdx().longValue(), 1L);
        Assert.assertEquals(findEntity.getBasicInfo().getAddress(), "askdfj");

    }

}
