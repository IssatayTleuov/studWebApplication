package com.company.servlets;

import com.company.database.RatingDao;
import com.company.database.StudentDao;
import com.company.database.TeacherDao;
import com.company.database.UserDao;
import com.company.util.Rating;
import com.company.util.Student;
import com.google.gson.Gson;

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

    Rating rating = new Rating();
    RatingDao ratingDao = new RatingDao();
    Student student = new Student();
    StudentDao studentDao = new StudentDao();
    UserDao userDao = new UserDao();
    TeacherDao teacherDao = new TeacherDao();
    Gson gson = new Gson();
    ArrayList<Rating> ratingList = new ArrayList<>();
    ArrayList<Student> studentList = new ArrayList<>();
    ArrayList<Rating> sortedRatingList = new ArrayList<>();
    ArrayList<String> sortedStudentList = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

//            HttpSession session = req.getSession();
//            int userId = userDao.getId(session.getAttribute("sessionId").toString());
//            int[] idArray = teacherDao.getObjAndTeachId(userId);
//            int teacherId = idArray[0];
//            int objectsId = idArray[1];

            ratingList = ratingDao.getAllRating();
            studentList = studentDao.getAllStudents();

            sortedRatingList = rating.sortRating(ratingList, 3, 3, 4);
            sortedStudentList = student.sortStudentNames(ratingList);

            req.setAttribute("ratingList", sortedRatingList);
            req.setAttribute("studentList", sortedStudentList);

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
