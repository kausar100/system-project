package com.example.hp.tutorstudentportalapp;

public class FetchItem {
    private String roll;
    private Boolean bool;

    public FetchItem() {
    }

    public FetchItem(String roll, Boolean bool) {
        this.roll = roll;
        this.bool = bool;
    }

    public String getRoll() {
        return roll;
    }

    public Boolean getBool() {
        return bool;
    }
}
