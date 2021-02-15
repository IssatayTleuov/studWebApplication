package com.company.util;

import com.company.database.FacultyDao;
import com.company.util.Faculty;
import org.junit.*;

import java.util.ArrayList;

public class FacultyTest {
    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("before class");
    }

    @Before
    public void setUpBefore() {
        System.out.println("before");
    }

    @After
    public void setUpAfter() {
        System.out.println("after");
    }

    @AfterClass
    public static void setUpAfterClass() {
        System.out.println("after class");
    }

    @Test
    public void sortFacultyTest() {
        try {
            Faculty faculty = new Faculty();
            FacultyDao facultyDao = new FacultyDao();
            ArrayList<Faculty> arrayList;
            arrayList = facultyDao.getFaculties();
            Assert.assertEquals(3, faculty.sortFaculty(arrayList, "Экономический факультет"));
            System.out.println("Correct faculty_id!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
