package com.company.servlets;

import com.company.database.StudentDao;
import com.company.database.TeacherDao;
import com.company.database.UserDao;
import com.company.util.Student;
import com.company.util.Teacher;
import com.company.util.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

@WebServlet("/log_in")
public class LoginServlet extends HttpServlet {

    User user = new User();
    UserDao userDao = new UserDao();
    Teacher teacher = new Teacher();
    TeacherDao teacherDao = new TeacherDao();
    Student student = new Student();
    StudentDao studentDao = new StudentDao();
    ArrayList<Teacher> teachers;
    ArrayList<Student> students;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("log_in.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        UUID uuid = UUID.randomUUID();
        HttpSession session = req.getSession();
        session.setAttribute("sessionId", uuid);
        System.out.println(session.getAttribute("sessionId"));

    //        teacher03@email.com
    //        qwertyas

        try {
            user = userDao.logIn(login, password);
            userDao.updateSessionId(uuid.toString(), user.getId());
            teachers = teacherDao.getTeachUserId();
            boolean isTeacher = teacher.isTeacher(teachers, user);
            students = studentDao.getAllUsers();
            boolean isStudent = student.isStudent(students, user);

            if (isTeacher) {
                resp.sendRedirect("teach_home_page.jsp");
            } else if (isStudent) {
                resp.sendRedirect("stud_home_page.jsp");
            } else {
                resp.getWriter().print("Try again!");
            }

        } catch (SQLException e) {
            resp.getWriter().print("Error!");
            e.printStackTrace();
        }
    }
}
