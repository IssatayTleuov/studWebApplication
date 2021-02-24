package com.company.servlets;

import com.company.database.MarkTypeDao;
import com.company.database.ObjectDao;
import com.company.database.TeacherDao;
import com.company.database.UserDao;
import com.company.util.MarkType;
import com.company.util.Object;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/test_ajax_2")
public class TestAjax2Servlet extends HttpServlet {

    Object object = new Object();
    MarkTypeDao markTypeDao = new MarkTypeDao();
    UserDao userDao = new UserDao();
    TeacherDao teacherDao = new TeacherDao();
    ObjectDao objectDao = new ObjectDao();
    ArrayList<Object> objectsList = new ArrayList<>();
    ArrayList<Object> allObjectsList = new ArrayList<>();
    ArrayList<MarkType> allMarkTypesList = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int userId = userDao.getId(session.getAttribute("sessionId").toString());
        int[] idArray = teacherDao.getObjAndTeachId(userId);
        int teacherId = idArray[0];
        int objectsId = idArray[1];

        allObjectsList = objectDao.getAllObjects();
        objectsList = object.getObjectsNames(allObjectsList, objectsId);
        allMarkTypesList = markTypeDao.getMarkTypes();

            try {
                Gson gson = new Gson();
                String objects = gson.toJson(objectsList);
                resp.setContentType("application/json");
                resp.getWriter().write(objects);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
   // }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
