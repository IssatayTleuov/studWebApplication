package com.company.servlets;

import com.company.database.RatingDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit_mark")
public class EditMarkServlet extends HttpServlet {

    RatingDao ratingDao = new RatingDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int ratingId = Integer.parseInt(req.getQueryString());
        int mark = Integer.parseInt(req.getParameter("markField"));

        try {
        ratingDao.updateMark(ratingId, mark);
        resp.getWriter().print("Updated!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
