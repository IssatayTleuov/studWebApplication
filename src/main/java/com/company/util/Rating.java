package com.company.util;

import java.util.ArrayList;

public class Rating {

    private int id;
    private int mark;
    private int studentId;
    private int teacherId;
    private int objectId;
    private int markTypeId;
    private String time;

    public ArrayList<Rating> sortRating(ArrayList<Rating> ratingList, int teacherId, int objectId, int markTypeId) {
        ArrayList<Rating> sortedList = new ArrayList<>();
        for (Rating r : ratingList) {
            if (r.getTeacherId() == teacherId && r.getObjectId() == objectId && r.getMarkTypeId() == markTypeId) {
                sortedList.add(r);
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

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getObjectId() {
        return objectId;
    }

    public void setObjectId(int objectId) {
        this.objectId = objectId;
    }

    public int getMarkTypeId() {
        return markTypeId;
    }

    public void setMarkTypeId(int markTypeId) {
        this.markTypeId = markTypeId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
