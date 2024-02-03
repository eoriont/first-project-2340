package com.example.firstproject.ui.userStory3;

public class Exam {
    private String date;
    private String time;
    private String location;

    public Exam(String date, String time, String location) {
        this.date = date;
        this.time = time;
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Date: " + date + ", Time: " + time + ", Location: " + location;
    }
}
