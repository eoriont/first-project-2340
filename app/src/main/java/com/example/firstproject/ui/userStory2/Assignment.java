package com.example.firstproject.ui.userStory2;

import com.example.firstproject.ui.userStory1.Class;

import java.util.ArrayList;

public class Assignment {

    public static ArrayList<Assignment> assignments = new ArrayList<>();
    private String date;
    private String assignment;
    private Class associatedClass;

    public Assignment() {
        this("", "", null);
    }

    public Assignment(String date, String assignment, Class associatedClass) {
        this.date = date;
        this.assignment = assignment;
        this.associatedClass = associatedClass;
    }

    public String getDate() {
        return date;
    }

    public String getAssignment() {
        return assignment;
    }

    public Class getAssociatedClass() {
        return associatedClass;
    }

    @Override
    public String toString() {
        return date + " [" + associatedClass + "] " + assignment;
    }

}
