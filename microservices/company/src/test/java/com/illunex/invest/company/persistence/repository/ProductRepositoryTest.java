package com.illunex.invest.company.persistence.repository;

import com.illunex.invest.company.builder.CompanyBuilder;
import com.illunex.invest.company.persistence.entity.Company;
import com.illunex.invest.company.persistence.entity.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=RANDOM_PORT
        , properties = {"spring.datasource.url=jdbc:h2:mem:company"
        , "eureka.client.enabled=false"
        , "spring.cloud.config.enabled=false"})
public class ProductRepositoryTest {
    @Autowired ProductRepository repository;
    @Autowired CompanyRepository companyRepository;

    @Before
    public void setup() {
        Company company = CompanyBuilder.getInstance()
                .name("Company")
                .entityBuild();

        Product product = Product.builder()
                .title("Test Product")
                .company(companyRepository.save(company))
                .build();
        repository.save(product);
    }

    @Test
    public void findByCompanyCompanyIdx() {
        List<Product> products = repository.findByCompanyCompanyIdx(1L);
        Assert.assertEquals(products.get(0).getTitle(), "Test Product");
    }

//    @Test
//    public void testFindByCompanyCompanyIdx() {
//    }
//
//    @Test
//    public void findById() {
//    }
//
//    @Test
//    public void save() {
//    }
}