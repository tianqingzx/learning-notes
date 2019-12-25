package com.entity;

public class RentInfo {
    private String bDate;
    private String rDate;
    private int accommodate;
    private int distance;

    public RentInfo() {
    }

    public RentInfo(String bDate, String rDate, int accommodate, int distance) {
        this.bDate = bDate;
        this.rDate = rDate;
        this.accommodate = accommodate;
        this.distance = distance;
    }

    public String getbDate() {
        return bDate;
    }

    public void setbDate(String bDate) {
        this.bDate = bDate;
    }

    public String getrDate() {
        return rDate;
    }

    public void setrDate(String rDate) {
        this.rDate = rDate;
    }

    public int getAccommodate() {
        return accommodate;
    }

    public void setAccommodate(int accommodate) {
        this.accommodate = accommodate;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "RentInfo{" +
                "bDate=" + bDate +
                ", rDate=" + rDate +
                ", accommodate=" + accommodate +
                ", distance=" + distance +
                '}';
    }
}
