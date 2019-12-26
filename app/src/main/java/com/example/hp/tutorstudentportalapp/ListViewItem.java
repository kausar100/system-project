package com.example.hp.tutorstudentportalapp;

public class ListViewItem {
    private String section;
    private String department;
    private String date;
    private String ctno;
    private  String batch;

    public ListViewItem() {
    }

    public ListViewItem(String department, String ctno, String batchno) {
        this.department = department;
        this.ctno = ctno;
        this.batch = batchno;
    }

    public ListViewItem(String section, String department, String date, String bn) {
        this.section = section;
        this.department = department;
        this.date = date;
        this.batch = bn;
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

    public String getBatch() {
        return batch;
    }
}
