package com.company.util;

public class Student {
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
