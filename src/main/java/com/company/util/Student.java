package com.company.util;

import com.company.database.StudentDao;

import java.util.ArrayList;

public class Student {

    private int id;
    private String name;
    private String surname;
    private String phoneNumber;
    private int course;
    private int facultyId;
    private int userId;

    public Student() {

    }

    public Student(String name, String surname, String phoneNumber, int course, int facultyId, int userId) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.course = course;
        this.facultyId = facultyId;
        this.userId = userId;
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

    public ArrayList<String> sortStudentNames(ArrayList<Rating> ratingList) {
        StudentDao studentDao = new StudentDao();
        ArrayList<Student> studentList = studentDao.getAllStudents();
        ArrayList<String> sortedList = new ArrayList<>();

        for (int i = 0; i < ratingList.size(); i++) {
            for (int j = 0; j < studentList.size(); j++) {
                if (ratingList.get(i).getStudentId() == studentList.get(j).getId()) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(studentList.get(j).getName() + " " + studentList.get(j).getSurname());
                    sortedList.add(stringBuilder.toString());
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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
}
