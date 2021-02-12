package com.company.util;

import java.util.ArrayList;

public class Faculty {
    private int id;
    private String name;

    public int sortFaculty(ArrayList<Faculty> arrayList, String studentFaculty) {
        //ArrayList<String> facultyNames = new ArrayList<>();
        int result = 0;
        for (Faculty f : arrayList) {
            if (studentFaculty.equals(f.getName())) {
                result = f.getId();
            }
        }
        return result;
    }

//    public int chooseFaculty(ArrayList<String> arrayList, String studentFaculty) {
//        int result = 0;
//        for (int i = 0; i < arrayList.size(); i++) {
//            if (arrayList.get(i).equals(studentFaculty)) {
//                result = i + 1;
//            }
//        }
//        return result;
    //}

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
