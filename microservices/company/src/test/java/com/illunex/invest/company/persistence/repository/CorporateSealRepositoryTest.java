package com.illunex.invest.company.persistence.repository;

import com.illunex.invest.company.persistence.entity.Company;
import com.illunex.invest.company.persistence.entity.CorporateSeal;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=RANDOM_PORT
        , properties = {"spring.datasource.url=jdbc:h2:mem:company"
        , "eureka.client.enabled=false"
        , "spring.cloud.config.enabled=false"})
@Transactional
public class CorporateSealRepositoryTest {
    @Autowired CompanyRepository companyRepository;
    @Autowired CorporateSealRepository corporateSealRepository;
    CorporateSeal corporateSeal;


    @Before
    public void setUp() {
        Company company = companyRepository.save(Company.builder().companyIdx(1l).build());

        corporateSeal = CorporateSeal.builder()
                .company(company)
                .imgUrl("alskdjflkasdjfklasdjh")
                .build();

        corporateSealRepository.save(corporateSeal);
    }

    @Test
    public void findAllByCompanyCompanyIdx() {
        List<CorporateSeal> allByCompanyCompanyIdx = corporateSealRepository.findAllByCompanyCompanyIdx(corporateSeal.getId());

        assertEquals(allByCompanyCompanyIdx.size(), 1);
        assertEquals(allByCompanyCompanyIdx.get(0).getImgUrl(), "alskdjflkasdjfklasdjh");
    }
}
