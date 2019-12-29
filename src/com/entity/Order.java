package com.entity;

public class Order {
    private String orderId;
    private String tId;
    private String carId;
    private int state;
    private String beginDate;
    private int distance;
    private String endDate;
    private String diver;
    private String dTel;
    private String companyName;
    private String companyTel;
    private int charge;

    public Order() {
    }

    public Order(String orderId, String tId, String carId, int state, String beginDate, int distance, String endDate, String diver, String dTel, String companyName, String companyTel, int charge) {
        this.orderId = orderId;
        this.tId = tId;
        this.carId = carId;
        this.state = state;
        this.beginDate = beginDate;
        this.distance = distance;
        this.endDate = endDate;
        this.diver = diver;
        this.dTel = dTel;
        this.companyName = companyName;
        this.companyTel = companyTel;
        this.charge = charge;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDiver() {
        return diver;
    }

    public void setDiver(String diver) {
        this.diver = diver;
    }

    public String getdTel() {
        return dTel;
    }

    public void setdTel(String dTel) {
        this.dTel = dTel;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyTel() {
        return companyTel;
    }

    public void setCompanyTel(String companyTel) {
        this.companyTel = companyTel;
    }

    public int getCharge() {
        return charge;
    }

    public void setCharge(int charge) {
        this.charge = charge;
    }

    @Override
    public String toString() {
        String orderinfo = null;
        if (state == 0) {
            orderinfo = "订单[" +
                    "车牌号：'" + carId + '\'' +
                    ", 状态：未完成" +
                    ", 开始时间：'" + beginDate + '\'' +
                    ", 结束时间'" + endDate + '\'' +
                    ", 行驶距离" + distance +
                    ", 司机名：'" + diver + '\'' +
                    ", 司机电话：'" + dTel + '\'' +
                    ", 所属公司：'" + companyName + '\'' +
                    ", 公司电话：'" + companyTel + '\'' +
                    ", 花费：" + charge +
                    ']';
        }else {
            orderinfo = "订单[" +
                    "车牌号：'" + carId + '\'' +
                    ", 状态：已完成" +
                    ", 开始时间：'" + beginDate + '\'' +
                    ", 结束时间'" + endDate + '\'' +
                    ", 行驶距离" + distance +
                    ", 司机名：'" + diver + '\'' +
                    ", 司机电话：'" + dTel + '\'' +
                    ", 所属公司：'" + companyName + '\'' +
                    ", 公司电话：'" + companyTel + '\'' +
                    ", 花费：" + charge +
                    ']';
        }
        return orderinfo;
    }


}
