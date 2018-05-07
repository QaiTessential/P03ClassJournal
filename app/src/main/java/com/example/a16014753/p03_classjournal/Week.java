package com.example.a16014753.p03_classjournal;

import java.io.Serializable;

public class Week implements Serializable{
    private String weekNumber;
    private String grade;
    private double score;
    public Week(String weekNumber, String grade){
        this.weekNumber = weekNumber;
        this.grade = grade;
    }

    public String getWeekNumber() {
        return weekNumber;
    }

    public void setWeekNumber(String weekNumber) {
        this.weekNumber = weekNumber;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
