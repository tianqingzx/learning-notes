package com.entity;

public class Teacher {
    private String tId;
    private String tName;
    private String tTele;
    private String tPassword;

    public Teacher() {
    }

    public Teacher(String tId, String tName, String tTele, String tPassword) {
        this.tId = tId;
        this.tName = tName;
        this.tTele = tTele;
        this.tPassword = tPassword;
    }

    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String gettTele() {
        return tTele;
    }

    public void settTele(String tTele) {
        this.tTele = tTele;
    }

    public String gettPassword() {
        return tPassword;
    }

    public void settPassword(String tPassword) {
        this.tPassword = tPassword;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tId='" + tId + '\'' +
                ", tName='" + tName + '\'' +
                ", tTele='" + tTele + '\'' +
                ", tPassword='" + tPassword + '\'' +
                '}';
    }
}
