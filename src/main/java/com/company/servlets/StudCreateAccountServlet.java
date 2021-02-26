package com.company.servlets;

import com.company.database.FacultyDao;
import com.company.database.StudentDao;
import com.company.database.UserDao;
import com.company.util.Faculty;
import com.company.util.User;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet("/stud_create_account")
public class StudCreateAccountServlet extends HttpServlet {
    User user = new User();
    UserDao userDao = new UserDao();
    FacultyDao facultyDao = new FacultyDao();
    Faculty faculty = new Faculty();
    StudentDao studentDao = new StudentDao();
    ArrayList<Faculty> faculties;
    ArrayList<User> users;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("stud_create_account.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        faculties = facultyDao.getFaculties();

        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        StringBuilder stringBuilder = new StringBuilder(name + " " + surname);
        String fullName = stringBuilder.toString();
        String phoneNumber = req.getParameter("phoneNumber");
        int course = Integer.parseInt(req.getParameter("course"));
        int facultyId = faculty.sortFaculty(faculties, req.getParameter("facultyId"));

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        try {
            user =  userDao.createAccount(login, password);
            users = userDao.getUsers();
            int userId = user.getUserId(users, user);
            HttpSession session = req.getSession();
            session.setAttribute("sessionId", user.getSessionId());
            studentDao.createAccount(fullName, phoneNumber, course, facultyId, userId);
            resp.sendRedirect("stud_home_page.jsp");
        } catch (Exception e) {
            System.out.println("Exception" + " " + e.getMessage());
        }
    }
}
