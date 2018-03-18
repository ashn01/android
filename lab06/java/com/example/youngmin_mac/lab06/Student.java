package com.example.youngmin_mac.lab06;

/**
 * Created by youngmin-mac on 2018. 3. 11..
 */

public class Student {
    String dummy;
    String ID;
    String name;
    String grade;
    public Student(String ID, String name, String grade)
    {
        this.ID = ID;
        this.name = name;
        this.grade = grade;
    }

    public String toString()
    {
        return "ID: "+ID+" name: "+name +" grade: "+grade;
    }

    public String getID()
    {
        return ID;
    }

    public String getName()
    {
        return name;
    }

    public String getGrade()
    {
        return grade;
    }

    public String getDummy() {return dummy;}
    public void setDummy(String dummy) {this.dummy = dummy;}
}
