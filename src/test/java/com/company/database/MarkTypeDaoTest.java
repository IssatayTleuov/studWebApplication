package com.company.database;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class MarkTypeDaoTest {

    @Before
    public void setUpBefore() {
        System.out.println("before");
    }

    @After
    public void setUpAfter() {
        System.out.println("after");
    }

    @Test
    public void getMarkTypesTest() {
        try {
            MarkTypeDao markTypeDao = new MarkTypeDao();
            //ArrayList<MarkType> markTypeArrayList = new ArrayList<>();
            Assert.assertNotNull(markTypeDao.getMarkTypes());
            System.out.println("getMarkTypes not null!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
