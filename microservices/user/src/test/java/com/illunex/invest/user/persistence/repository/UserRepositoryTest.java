package com.illunex.invest.user.persistence.repository;


import com.illunex.invest.user.persistence.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=RANDOM_PORT, properties = {
        "eureka.client.enabled=false",
        "spring.cloud.config.enabled=false",
        "spring.datasource.url=jdbc:h2:mem:user"})
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test(expected = DataIntegrityViolationException.class)
    public void saveTestNotPassword() {
        User user = User.builder()
                .username("test")
                .build();

        userRepository.save(user);
    }

    @Test
    public void saveTest() {
        User user = User.builder()
                .build();
        userRepository.save(user);
    }
}
