package com.example.hp.tutorstudentportalapp;

public class Student {

    private String name;
    private String department;
    private String password;
    private String roll;
    private String email;
    private String uid;

    public Student() {
    }

    public Student(String name, String department, String password, String roll, String email, String uid) {
        this.name = name;
        this.department = department;
        this.password = password;
        this.roll = roll;
        this.email = email;
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getPassword() {
        return password;
    }

    public String getRoll() {
        return roll;
    }

    public String getEmail() {
        return email;
    }

    public String getUid() {
        return uid;
    }
}
