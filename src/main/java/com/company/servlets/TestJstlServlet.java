package com.company.servlets;

import com.company.database.RatingDao;
import com.company.util.Rating;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/test_jstl")
public class TestJstlServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Rating> ratingArrayList;
        RatingDao ratingDao = new RatingDao();

        try {
            ratingArrayList = ratingDao.getAllRating();

            for (Rating r: ratingArrayList) {
                System.out.println(r.getMark());
            }

            req.setAttribute("ratings", ratingArrayList);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("test_jstl.jsp");
            requestDispatcher.forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
