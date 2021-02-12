package com.company.servlets;

import com.company.database.FacultyDao;
import com.company.database.StudentDao;
import com.company.database.UserDao;
import com.company.util.Faculty;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet("/create_account")
public class CreateAccountServlet extends HttpServlet {

    FacultyDao facultyDao;
    Faculty faculty;
    ArrayList<Faculty> faculties;
    //ArrayList<String> facultyNames;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        faculties = facultyDao.getFaculties();
//        facultyNames = faculty.sortFaculty(faculties);

        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String phoneNumber = req.getParameter("phoneNumber");
        int course = Integer.parseInt(req.getParameter("course"));
        int facultyId = faculty.sortFaculty(faculties, req.getParameter("facultyId"));
        StudentDao studentDao = new StudentDao();

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        UserDao userDao = new UserDao();
        try {
            int userId = userDao.createAccount(login, password);
            studentDao.createAccount(name, surname, phoneNumber, course, facultyId, userId);
            resp.getWriter().print("Account was created");
        } catch (Exception e) {
            System.out.println("Exception" + " " + e.getMessage());
        }
    }
}
