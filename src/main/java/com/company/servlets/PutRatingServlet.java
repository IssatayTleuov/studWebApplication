package com.company.servlets;

import com.company.database.ObjectDao;
import com.company.database.TeacherDao;
import com.company.database.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/put_rating")
public class PutRatingServlet extends HttpServlet {
    UserDao userDao = new UserDao();
    TeacherDao teacherDao = new TeacherDao();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("objectNames", new ObjectDao().getObjectNames());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("put_rating.jsp");
        requestDispatcher.forward(req, resp);

        HttpSession session = req.getSession();
        int userId = userDao.getId(session.getAttribute("sessionId").toString());
        int[] idArray = teacherDao.getObjAndTeachId(userId);
        int teacherId = idArray[0];
        int objectId = idArray[1];
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
