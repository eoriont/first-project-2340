package com.example.firstproject.ui.userStory1;

public class Class {

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

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    @Override
    public String toString() {
        return "Class: " + className + ", Teacher: " + teacher + ", Time: " + time;
    }
}