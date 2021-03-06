package com.domrowka.app;

import java.util.ArrayList;
import java.util.List;
import java.lang.*;
import java.util.Collections;

public class Class {
    String name;
    List<Student> studentList = new ArrayList<Student>();
    int maxCount;
    int count;

    public Class(String nameInit, int maxCountInit) {
        name = nameInit;
        maxCount = maxCountInit;
    }

    public void addStudent(Student student) {
        if(count==maxCount){
            System.err.println("Class capacity at max");
            return;
        }
        for(int i =0; i<studentList.size(); i++) {
            if(student.compareTo(studentList.get(i))==0){
                System.err.println("Student already exists");
                return;
            }
        }
        studentList.add(student);
        count++;
    }

    public void addPoints(Student student, double pts) {
        student.points+=pts;
    }

    public void getStudent(Student student) {
        studentList.remove(student);
        if(student.points==0) {
            student = null;
        }

        /*
        if(student.points==0) {
            studentList.remove(student);
        }
         */
    }

    public void changeCondition(Student student, StudentCondition condition) {
        student.condition = condition;
    }

    public void removePoints(Student student, double points) {
        student.points -= points;
        if (student.points<0){
            student.points = 0;
        }
    }

    public Student search(String firstName, String lastName) {
        for(int i =0; i<studentList.size(); i++) {
            if(firstName.compareTo(studentList.get(i).firstName)==0) {
                if(lastName.compareTo(studentList.get(i).lastName)==0) {
                    return studentList.get(i);
                }
            }
        }
        System.err.println("No such student found");
        return null;
    }

    public List<Student> searchPartial(String line) {
        List<Student> returnList = new ArrayList<Student>();
        for(int i =0; i<studentList.size(); i++) {
            if(studentList.get(i).firstName.contains(line) || studentList.get(i).lastName.contains(line)) {
                returnList.add(studentList.get(i));
            }
        }
        return returnList;
    }

    public int countByCondition(StudentCondition condition) {
        int count = 0;
        for(int i =0; i<studentList.size(); i++) {
            if(studentList.get(i).condition==condition) {
                count++;
            }
        }
        return count;
    }

    public void summary() {
        for(int i =0; i<studentList.size(); i++) {
            System.out.print(studentList.get(i).firstName+" "+studentList.get(i).lastName);
            System.out.println(" "+studentList.get(i).points);
        }
    }

    public void sortByName() {
        Collections.sort(studentList);
    }

    public void sortByPoints() {
        Collections.sort(studentList, new ComparatorPoints() {
            @Override
            public int compare(Student o1, Student o2) {
                return super.compare(o1, o2);
            }
        });
    }

    public Student max() {
       return Collections.max(studentList);
    }
}
