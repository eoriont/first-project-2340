package com.example.firstproject.ui.userStory2;

public class Assignment {

    private String date;
    private String assignment;
    private String associatedClass;

    public Assignment() {
        this("", "", "");
    }

    public Assignment(String date, String assignment, String associatedClass) {
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

    public String getAssociatedClass() {
        return associatedClass;
    }

    @Override
    public String toString() {
        return date + " [" + associatedClass + "] " + assignment;
    }

}
