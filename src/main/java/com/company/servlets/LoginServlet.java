package com.company.servlets;

import com.company.database.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/log_in")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("log_in.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        UserDao userDao = new UserDao();
        try {
            boolean isRegistered = userDao.logIn(login, password);
            if (isRegistered) {
                resp.getWriter().print("Log in!");
            } else {
                resp.getWriter().print("Try again!");
            }
        } catch (SQLException e) {
            resp.getWriter().print("Error!");
            e.printStackTrace();
        }
    }
}
