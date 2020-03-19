package com.illunex.invest.user.persistence.repository.Impl;

import com.illunex.invest.user.persistence.entity.Role;
import com.illunex.invest.user.persistence.entity.User;
import com.illunex.invest.user.persistence.repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
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
public class UserCustomRepositoryImplTest {
    @Autowired
    UserRepository repository;

    @Before
    public void setUp() {
        repository.save(User.createCompanyAdminUser("test", "test1234", "test", "illunex", "", 1L));
        repository.save(User.createUser("test2", "test1234", "test2", "illunex", "", 1L));
        repository.save(User.createUser("test3", "test1234", "test3", "illunex", "", 1L));
        repository.save(User.createUser("test4", "test1234", "test4", "illunex", "", 1L));
        repository.save(User.createUser("test5", "test1234", "test5", "illunex", "", 1L));
    }

    @Test
    public void findByCompanyIdx() {
        List<User> users = repository.findByCompanyIdx(1L);

        Assert.assertEquals(users.size(), 5);

        for (User user: users) {
            for (Role role: user.getAuthorities()) {
                if (user.getName().equals("test")) {
                    if (role.getName().equals("ROLE_USER")) {
                        Assert.assertEquals(user.getName() + role.getName() + role.getDetailedRights(), "testROLE_USER0");
                    } else {
                        Assert.assertEquals(user.getName() + role.getName() + role.getDetailedRights(), "testROLE_COMPANY_ADMIN15");
                    }
                } else {
                    Assert.assertEquals(user.getName() + role.getName() + role.getDetailedRights(), user.getName()+"ROLE_USER"+role.getDetailedRights());
                }
            }
        }
    }


}