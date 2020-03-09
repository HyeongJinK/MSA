package com.illunex.invest.user.persistence.entity;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserTest {
    Logger log = LoggerFactory.getLogger(UserTest.class);

    @Test
    public void createUser() {
        User user = User.createCompanyAdminUser("username", "password", "testName", "Web");

        Assert.assertEquals(user.getUsername(), "username");
        Assert.assertEquals(user.getPassword(), User.encodePassword("password"));
        Assert.assertEquals(user.getName(), "testName");
        log.info(User.encodePassword("password"));
        Assert.assertEquals(user.getVender(), "Web");
    }
}
