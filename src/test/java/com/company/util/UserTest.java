package com.company.util;

import com.company.database.UserDao;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class UserTest {
    @Before
    public void setUpBefore() {
        System.out.println("before");
    }

    @After
    public void setUpAfter() {
        System.out.println("after");
    }

    @Test
    public void getUserIdTest() {
        try {
        ArrayList<User> arrayList = new ArrayList<>();
        UserDao userDao = new UserDao();
        arrayList = userDao.getUsers();
        User user = new User("student05@email.com", "lmlj7894", "e20bd112-ec76-46c9-9d72-c3f5e941e588");
        Assert.assertEquals(29, user.getUserId(arrayList, user));
        System.out.println("user_id is correct!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
