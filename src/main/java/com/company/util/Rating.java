package com.company.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class Rating {

    private int id;
    private int mark;
    private int studentId;
    private int teacherId;
    private int objectId;
    private int markTypeId;
    private Date date;

    public ArrayList<Rating> sortRating(ArrayList<Rating> ratingList, int teacherId, int objectId, int markTypeId, String date) {
        ArrayList<Rating> sortedList = new ArrayList<>();
        DateFormat  dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        for (Rating r : ratingList) {
            String databaseDate = dateFormat.format(r.getDate());
            if (r.getTeacherId() == teacherId && r.getObjectId() == objectId && r.getMarkTypeId() == markTypeId && databaseDate.equals(date)) {
                sortedList.add(r);
            }
        }
        return sortedList;
    }

    public ArrayList<String> getCurrentMonth() {
        LocalDate start = LocalDate.now().withDayOfMonth(1);
        LocalDate end = LocalDate.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        ArrayList<String> dates = new ArrayList<>();
        while(start.isBefore(end)) {
            String formattedStr = start.format(formatter);
            dates.add(formattedStr);
            start = start.plusDays(1);
        }
        String current = end.format(formatter);
        dates.add(current);

        return dates;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
