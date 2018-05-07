package com.example.a16014753.p03_classjournal;

public class Week {
    private String weekNumber;
    private String grade;
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
