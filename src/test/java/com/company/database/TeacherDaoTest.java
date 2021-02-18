package com.company.database;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TeacherDaoTest {

    @Before
    public void setUpBefore() {
        System.out.println("before");
    }

    @After
    public void setUpAfter() {
        System.out.println("after");
    }

    @Test
    public void getObjAndTeachId() {
        try {
            TeacherDao teacherDao = new TeacherDao();
            int[] arr = {21, 1};
            int[] dataArr = teacherDao.getObjAndTeachId(28);
            Assert.assertEquals(arr[0], dataArr[0]);
            Assert.assertEquals(arr[1], dataArr[1]);
            System.out.println("getObjAndTeachId correct id's!");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
