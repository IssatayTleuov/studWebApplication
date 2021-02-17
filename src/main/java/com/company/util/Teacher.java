package com.company.util;

import java.util.ArrayList;

public class Teacher {

    private int id;
    private String name;
    private String surname;
    private String phoneNumber;
    private int objectId;
    private int facultyId;
    private int userId;

    int currentTeacherId = 0;
    int currentTeacherObjId = 0;

    public Teacher() {

    }

    public Teacher(String name, String surname, String phoneNumber, int objectId, int facultyId, int userId) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.objectId = objectId;
        this.facultyId = facultyId;
        this.userId = userId;
    }

    public boolean isTeacher(ArrayList<Teacher> arr, User user) {
        boolean isTeacher = false;

        for (Teacher t : arr) {
            if (t.getUserId() == user.getId()) {
                currentTeacherId = t.getId();
                currentTeacherObjId = t.getObjectId();
                isTeacher = true;
            }
        }
        return isTeacher;
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

    public int getObjectId() {
        return objectId;
    }

    public void setObjectId(int objectId) {
        this.objectId = objectId;
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
