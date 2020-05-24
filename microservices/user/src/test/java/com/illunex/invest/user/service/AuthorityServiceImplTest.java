package com.illunex.invest.user.service;

import com.illunex.invest.api.core.user.request.AuthorityItem;
import com.illunex.invest.api.core.user.request.AuthorityRequest;
import com.illunex.invest.user.persistence.entity.Role;
import com.illunex.invest.user.persistence.entity.User;
import com.illunex.invest.user.persistence.repository.RoleRepository;
import com.illunex.invest.user.persistence.repository.UserRepository;
import com.illunex.invest.user.service.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=RANDOM_PORT, properties = {
        "eureka.client.enabled=false",
        "spring.cloud.config.enabled=false",
        "spring.datasource.url=jdbc:h2:mem:user"})
@Transactional
public class AuthorityServiceImplTest {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired AuthorityService authorityService;

    private UserMapper mapper = Mappers.getMapper(UserMapper.class);

    User user2;

    @Before
    public void setUp() {
        userRepository.save(User.createCompanyAdminUser("test", "test1234", "test", "illunex", "", 1L));
        user2 = userRepository.save(User.createUser("test2", "test1234", "test2", "illunex", "", 1L));
        userRepository.save(User.createUser("test3", "test1234", "test3", "illunex", "", 1L));
        userRepository.save(User.createUser("test4", "test1234", "test4", "illunex", "", 1L));
        userRepository.save(User.createUser("test5", "test1234", "test5", "illunex", "", 1L));
    }

    private static void accept(Role role) {
        System.out.println(role.getName());
    }

    @Test
    public void setMemberAuthorityList() {
        Set<Role> authorities = new HashSet<>();
        user2.getAuthorities()
                .stream()
                .forEach((role -> {
                    authorities.add(role);
                }));
        authorities.add(new Role("ROLE_IR", 1));
        authorities.add(new Role("ROLE_INVEST", 3));
        List<AuthorityItem> data = new ArrayList<>();
        data.add(new AuthorityItem(user2.getId(), mapper.UserEntitySetToDtoSet(authorities)));

        authorityService.setMemberAuthorityList(new AuthorityRequest(user2.getId(), data));

        User user = userRepository.findById(user2.getId()).get();

        Assert.assertEquals(user.getAuthorities().size(), 3);

        user.getAuthorities()
                .stream()
                .forEach((AuthorityServiceImplTest::accept));
    }
}