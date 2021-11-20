package com.domrowka.app;

import java.util.ArrayList;
import java.util.List;

public class Student implements Comparable<Student>{
    String firstName;
    String lastName;
    StudentCondition condition;
    int birthYear;
    double points;

    public Student(String fN, String lN, StudentCondition con, int bY, double pts) {
        firstName=fN;
        lastName=lN;
        condition=con;
        birthYear=bY;
        points=pts;
    }

    public void print() {
        System.out.println("First name: " + firstName);
        System.out.println("Last name: " + lastName);
        System.out.println("Condition: " + condition);
        System.out.println("Birth year: " + birthYear);
        System.out.println("Points: " + points);
    }

    @Override
    public int compareTo(Student o) {
        int compareNames = lastName.compareTo(o.lastName);
        if(compareNames==0) {
            return firstName.compareTo(o.firstName);
        }
        else {
            return compareNames;
        }
    }
}
