package com.company.servlets;

import com.company.database.*;
import com.company.util.MarkType;
import com.company.util.Object;
import com.company.util.Rating;
import com.company.util.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet("/test_jstl")
public class TestJstlServlet extends HttpServlet {

    int teacherId;
    int objectsId;
    Object object = new Object();
    Rating rating = new Rating();
    Student student = new Student();
    UserDao userDao = new UserDao();
    TeacherDao teacherDao = new TeacherDao();
    ObjectDao objectDao = new ObjectDao();
    MarkTypeDao markTypeDao = new MarkTypeDao();
    RatingDao ratingDao = new RatingDao();
    ArrayList<Object> objectList = new ArrayList<>();
    ArrayList<Object> sortedObjectList = new ArrayList<>();
    ArrayList<MarkType> markTypeList = new ArrayList<>();
    ArrayList<String> dateList = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int userId = userDao.getId(session.getAttribute("sessionId").toString());
        int[] idArray = teacherDao.getObjAndTeachId(userId);

        teacherId = idArray[0];
        objectsId = idArray[1];
        objectList = objectDao.getAllObjects();
        sortedObjectList = object.getObjectsNames(objectList, objectsId);
        markTypeList = markTypeDao.getMarkTypes();
        dateList = rating.getCurrentMonth();

        req.setAttribute("objects", sortedObjectList);
        req.setAttribute("markTypes", markTypeList);
        req.setAttribute("dates", dateList);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/test_jstl.jsp");
        requestDispatcher.forward(req, resp);
    }

    //        teacher03@email.com
    //        qwertyas

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int object = Integer.parseInt(req.getParameter("objects"));
        int markType = Integer.parseInt(req.getParameter("mark_type"));
        String date = req.getParameter("date");

        ArrayList<Rating> ratingList = ratingDao.getAllRating();
        ArrayList<Rating> sortedRatingList = rating.sortRating(ratingList, teacherId, object, markType, date);
        ArrayList<String> sortedStudentList = student.sortStudentNames(sortedRatingList);

        req.setAttribute("ratings", sortedRatingList);
        req.setAttribute("students", sortedStudentList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/test_jstl.jsp");
        requestDispatcher.forward(req, resp);

    }
}
