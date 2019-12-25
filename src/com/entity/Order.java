package com.entity;

import java.util.Date;

public class Order {
    private String tId;
    private String cId;
    private int state;
    private Date bDate;
    private int distance;
    private int charge;
    private Date rDate;
    private int oId;

    public Order() {
    }

    public Order(String tId, String cId, int state, Date bDate, int distance, int charge, Date rDate, int oId) {
        this.tId = tId;
        this.cId = cId;
        this.state = state;
        this.bDate = bDate;
        this.distance = distance;
        this.charge = charge;
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

    public Date getbDate() {
        return bDate;
    }

    public void setbDate(Date bDate) {
        this.bDate = bDate;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getCharge() {
        return charge;
    }

    public void setCharge(int charge) {
        this.charge = charge;
    }

    public Date getrDate() {
        return rDate;
    }

    public void setrDate(Date rDate) {
        this.rDate = rDate;
    }

    public int getoId() {
        return oId;
    }

    public void setoId(int oId) {
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
                ", charge=" + charge +
                ", rDate=" + rDate +
                ", oId=" + oId +
                '}';
    }
}
