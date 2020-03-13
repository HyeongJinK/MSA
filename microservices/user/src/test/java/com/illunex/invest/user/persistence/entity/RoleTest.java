package com.illunex.invest.user.persistence.entity;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RoleTest {
    @Test
    public void detailedRightTest() {
        int detailedRight = 3;

        Assert.assertEquals(1 & 3, 1);
        Assert.assertEquals(2 & 3, 2);
        Assert.assertEquals(4 & 3, 0);
    }
}
