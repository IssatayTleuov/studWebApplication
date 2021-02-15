package com.company.database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ObjectDaoTest {

    @Before
    public void setUpBefore() {
        System.out.println("before");
    }

    public void setUpAfter() {
        System.out.println("after");
    }

    @Test
    public void getObjectsTest() {
        try {
        ObjectDao objectDao = new ObjectDao();
        Assert.assertNotNull(objectDao.getObjects());
        System.out.println("getObjects is not null!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
