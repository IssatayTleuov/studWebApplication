package com.company.util;

import com.company.database.StudentDao;

import java.util.ArrayList;

public class Student {

    private int id;
    private String fullName;
    private String phoneNumber;
    private int course;
    private int facultyId;
    private int userId;
    private String objectsId;

    public Student() {

    }

    public Student(String fullName, String phoneNumber, int course, int facultyId, int userId) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.course = course;
        this.facultyId = facultyId;
        this.userId = userId;

    }

    public Student(String fullName, String phoneNumber, int course, int facultyId, int userId, String objectsId) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.course = course;
        this.facultyId = facultyId;
        this.userId = userId;
        this.objectsId = objectsId;
    }

    public boolean isStudent(ArrayList<Student> arr, User user) {
        boolean isStudent = false;

        for (Student s : arr) {
            if (s.getUserId() == user.getId()) {
                isStudent = true;
            }
        }
        return isStudent;
    }

    public ArrayList<String> sortStudentNames(ArrayList<Rating> ratingList, ArrayList<Student> studentList, int currentObjectId) {
        ArrayList<String> sortedList = new ArrayList<>();

        for (int i = 0; i < ratingList.size(); i++) {
            for (int j = 0; j < studentList.size(); j++) {
                if (ratingList.get(i).getStudentId() == studentList.get(j).getId()) {
                String strObjectsId = studentList.get(j).getObjectsId();
                String[] array = strObjectsId.split(",");
                for (int k = 0; k < array.length; k++) {
                    int objectId = Integer.parseInt(array[k]);
                    if (currentObjectId == objectId) {
                        sortedList.add(studentList.get(j).getFullName());
                    }
                }
                }
            }
        }
        return sortedList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getObjectsId() {
        return objectsId;
    }

    public void setObjectsId(String objectsId) {
        this.objectsId = objectsId;
    }
}
