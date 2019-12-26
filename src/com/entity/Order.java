package com.entity;

public class Order {
    private String tId;
    private String cId;
    private int state;
    private String bDate;
    private int distance;
    private String rDate;
    private String oId;

    public Order() {
    }

    public Order(String tId, String cId, int state, String bDate, int distance, String rDate, String oId) {
        this.tId = tId;
        this.cId = cId;
        this.state = state;
        this.bDate = bDate;
        this.distance = distance;
        this.rDate = rDate;
        this.oId = oId;
    }

    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getbDate() {
        return bDate;
    }

    public void setbDate(String bDate) {
        this.bDate = bDate;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getrDate() {
        return rDate;
    }

    public void setrDate(String rDate) {
        this.rDate = rDate;
    }

    public String getoId() {
        return oId;
    }

    public void setoId(String oId) {
        this.oId = oId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "tId='" + tId + '\'' +
                ", cId='" + cId + '\'' +
                ", state=" + state +
                ", bDate=" + bDate +
                ", distance=" + distance +
                ", rDate=" + rDate +
                ", oId=" + oId +
                '}';
    }
}
