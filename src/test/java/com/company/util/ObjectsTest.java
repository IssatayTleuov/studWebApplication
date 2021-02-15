package com.company.util;

import com.company.database.ObjectDao;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ObjectsTest {

    @Before
    public void setUpBefore() {
        System.out.println("before");
    }

    @After
    public void setUpAfter() {
        System.out.println("after");
    }

    @Test
    public void getObjectsIdTest() {
        try {
            Object object = new Object();
            ObjectDao objectDao = new ObjectDao();
            Assert.assertEquals(1, object.getObjectId(objectDao.getObjects(), "Химия"));
            System.out.println("Correct object_id!");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
