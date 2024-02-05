package com.example.firstproject.ui.userStory1;

import java.util.ArrayList;

public class Class {

    public static ArrayList<Class> classList = new ArrayList<>();

    private String className;

    private String teacher;

    private String time;

    public Class(String className, String teacher, String time) {
        this.className = className;
        this.teacher = teacher;
        this.time = time;
    }

    public String getClassName() {
        return className;
    }

    public String getTeacher() {
        return teacher;
    }

    public String getTime() {
        return time;
    }
    @Override
    public String toString() {
        return "Class: " + className + ", Teacher: " + teacher + ", Time: " + time;
    }
}