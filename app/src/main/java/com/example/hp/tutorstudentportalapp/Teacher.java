package com.example.hp.tutorstudentportalapp;

public class Teacher {
    private String name;
    private String department;
    private String password;
    private String email;
    private String uid;

    public Teacher() {
    }

    public Teacher(String name, String department, String password, String email, String uid) {
        this.name = name;
        this.department = department;
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public String getUid() {
        return uid;
    }
}
