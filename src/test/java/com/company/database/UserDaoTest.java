package com.company.database;

import com.company.util.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.UUID;

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

    @Test
    public void updateSessionId() {
        UUID uuid = UUID.randomUUID();
        UserDao userDao = new UserDao();
        ArrayList<User> oldUsersList;
        ArrayList<User> updatedUsersList;
// 146457fe-3d0d-4a05-889a-51ae294dfc48
        try {
        oldUsersList = userDao.getUsers();
        userDao.updateSessionId(uuid.toString(), 1);
        updatedUsersList = userDao.getUsers();
        Assert.assertNotEquals(oldUsersList, updatedUsersList);
        System.out.println("session_id was updated!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getIdTest() {
     try {
         UserDao userDao = new UserDao();
         String sessionId = "76426e9b-a31f-4f86-b845-4fd0301eb22f";
         Assert.assertEquals(1, userDao.getId(sessionId));
         System.out.println("getId get correct user_id!");
     } catch (Exception e) {
         e.printStackTrace();
      }
    }
}
