package com.company.util;

import java.util.ArrayList;

public class Object {
    private int id;
    private String name;

    public int getObjectId(ArrayList<Object> arrayList, String str) {
        int result = 0;

        for (Object n : arrayList) {
            if (n.getName().equals(str)) {
                result = n.getId();
            }
        }
        return result;
    }

    public ArrayList<Object> getObjectsNames(ArrayList<Object> arr, int objectId) {
        ArrayList<Object> sortedList = new ArrayList<>();

        for (Object obj : arr) {
            if (obj.getId() == objectId) {
                sortedList.add(obj);
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
}
