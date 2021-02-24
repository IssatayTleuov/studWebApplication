package com.company.database;

import com.company.util.Object;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class ObjectDaoTest {

    @Before
    public void setUpBefore() {
        System.out.println("before");
    }

    @After
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

    @Test
    public void getObjectNamesTest() {
        try {
        ObjectDao objectDao = new ObjectDao();
        ArrayList<Object> objectArrayList = new ArrayList<>();
        objectArrayList = objectDao.getAllObjects();
        Assert.assertNotNull(objectArrayList);
//        Assert.assertThat(arrayList, IsIterableContainingInOrder.contains(nameList.toArray()));
        System.out.println("getObjectNames is not null!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
