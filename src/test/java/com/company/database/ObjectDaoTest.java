package com.company.database;

import org.hamcrest.collection.IsIterableContainingInOrder;
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
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> nameList = new ArrayList<>();
        arrayList.add("Химия");
        arrayList.add("Экономика");
        arrayList.add("География");
        arrayList.add("Филология");
        nameList = objectDao.getObjectNames();
        Assert.assertThat(arrayList, IsIterableContainingInOrder.contains(nameList.toArray()));
        System.out.println("Correct names of objects");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
