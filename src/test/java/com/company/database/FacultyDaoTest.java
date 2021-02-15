package com.company.database;

import org.junit.*;

public class FacultyDaoTest {

    @Before
    public void setUpBefore() {
        System.out.println("before");
    }

    @After
    public void setUpAfter() {
        System.out.println("after");
    }


    @Test
    public void getFacultiesTest() {
        try {
            FacultyDao facultyDao = new FacultyDao();
            Assert.assertNotNull(facultyDao.getFaculties());
            System.out.println("getFaculties is not null!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
