package com.illunex.invest.user.persistence.repository;

import com.illunex.invest.user.persistence.entity.Signature;
import com.illunex.invest.user.persistence.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=RANDOM_PORT, properties = {
        "eureka.client.enabled=false",
        "spring.cloud.config.enabled=false",
        "spring.datasource.url=jdbc:h2:mem:user"})
@Transactional
public class SignatureRepositoryTest {
    @Autowired UserRepository userRepository;
    @Autowired SignatureRepository signatureRepository;

    @Test
    public void findByUserId() {
        User user = User.builder()
                .username("test")
                .password("test1234")
                .build();

        User u = userRepository.save(user);
        //signatureRepository.save(Signature.createSignature("test", u.getId()));
        //List<Signature> signatures = signatureRepository.findByUserId(u.getId());

        //Assert.assertEquals(signatures.get(0).getImgUrl(), "test");
    }
}