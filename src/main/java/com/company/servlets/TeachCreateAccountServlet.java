package com.company.servlets;

import com.company.database.FacultyDao;
import com.company.database.ObjectDao;
import com.company.database.TeacherDao;
import com.company.database.UserDao;
import com.company.util.Faculty;
import com.company.util.Object;
import com.company.util.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/teach_create_account")
public class TeachCreateAccountServlet extends HttpServlet {

    User user = new User();
    UserDao userDao = new UserDao();
    Faculty faculty = new Faculty();
    FacultyDao facultyDao = new FacultyDao();
    Object object = new Object();
    ObjectDao objectDao = new ObjectDao();
    ArrayList<Faculty> facultyArrayList;
    ArrayList<Object> objectArrayList;
    ArrayList<User> userArrayList;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("teach_create_account.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        facultyArrayList = facultyDao.getFaculties();
        objectArrayList = objectDao.getObjects();


        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String phoneNumber = req.getParameter("phoneNumber");
        int objectId = object.getObjectId(objectArrayList, req.getParameter("objectId"));
        int facultyId = faculty.sortFaculty(facultyArrayList, req.getParameter("facultyId"));
        TeacherDao teacherDao = new TeacherDao();

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        UserDao userDao = new UserDao();

        try {
            user = userDao.createAccount(login, password);
            userArrayList = userDao.getUsers();
            int userId = user.getUserId(userArrayList, user);
            teacherDao.createAccount(name, surname, phoneNumber, objectId, facultyId, userId);
            resp.getWriter().print("Teacher account was created!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
