package com.company.servlets;

import com.company.database.ObjectDao;
import com.company.database.TeacherDao;
import com.company.database.UserDao;
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

@WebServlet("/test_ajax")
public class TestAjaxServlet extends HttpServlet {

    UserDao userDao = new UserDao();
    TeacherDao teacherDao = new TeacherDao();
    ObjectDao objectDao = new ObjectDao();
    ArrayList<Object> objectArrayList = new ArrayList<>();
    ArrayList<String> objectNames = new ArrayList<>();
    Gson gson = new Gson();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int userId = userDao.getId(session.getAttribute("sessionId").toString());
        int[] idArray = teacherDao.getObjAndTeachId(userId);
        objectArrayList = objectDao.getObjectNames();
        int teacherId = idArray[0];
        int objectsId = idArray[1];
        String objOperation = req.getParameter("operation");

        try {
        if (objOperation.equals("objects")) {
            for (int i = 0; i < objectArrayList.size(); i++) {
                Object object = objectArrayList.get(i);
                if (object.getId() == objectsId) {
                    objectNames.add(object.getName());
                }
            }
            String namesList = gson.toJson(objectNames);
            resp.setContentType("text/html");
            resp.getWriter().write(namesList);
          } else {
            System.out.println("Error in if statement!");
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
