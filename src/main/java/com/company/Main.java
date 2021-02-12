package com.company;

import com.company.database.FacultyDao;
import com.company.util.Faculty;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException {
        FacultyDao facultyDao = new FacultyDao();
        Faculty faculty = new Faculty();
        ArrayList<Faculty> arrayList = new ArrayList<>();
        arrayList = facultyDao.getFaculties();
        int n = faculty.sortFaculty(arrayList, "Экономический факультет");
        System.out.println(n);
    }
}
