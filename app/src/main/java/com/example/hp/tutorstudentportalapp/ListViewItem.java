package com.example.hp.tutorstudentportalapp;

public class ListViewItem {
    private String section;
    private String department;
    private String date;
    private String ctno;

    public ListViewItem() {
    }

    public ListViewItem(String department, String ctno) {
        this.department = department;
        this.ctno = ctno;
    }

    public ListViewItem(String section, String department, String date) {
        this.section = section;
        this.department = department;
        this.date = date;
    }
    public String getSection() {
        return section;
    }

    public String getDepartment() {
        return department;
    }

    public String getDate() {
        return date;
    }
    public String getCtno() {
        return ctno;
    }
}
