package com.company.database;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserDaoTest {

    @Before
    public void setUpBefore() {
        System.out.println("before");
    }

    @After
    public void setUpAfter() {
        System.out.println("after");
    }

    @Test
    public void getUsersTest() {
        try {
        UserDao userDao = new UserDao();
        Assert.assertNotNull(userDao.getUsers());
        System.out.println("userList is not null!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
