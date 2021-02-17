package com.company.servlets;

import com.company.database.ObjectDao;
import com.company.database.RatingDao;
import com.company.util.Rating;
import com.company.util.Teacher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/put_rating")
public class PutRatingServlet extends HttpServlet {

    RatingDao ratingDao = new RatingDao();
    Teacher teacher = new Teacher();
    ArrayList<Rating> ratingArrayList = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("objectNames", new ObjectDao().getObjectNames());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("put_rating.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
