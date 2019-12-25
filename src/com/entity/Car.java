package com.entity;

public class Car {
    private String cId;
    private String comId;
    private int carAccommodate;
    private String driver;
    private String dTele;
    private int cDistance;

    public Car() {
    }

    public Car(String cId, String comId, int carAccommodate, String driver, String dTele, int cDistance) {
        this.cId = cId;
        this.comId = comId;
        this.carAccommodate = carAccommodate;
        this.driver = driver;
        this.dTele = dTele;
        this.cDistance = cDistance;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getComId() {
        return comId;
    }

    public void setComId(String comId) {
        this.comId = comId;
    }

    public int getCarAccommodate() {
        return carAccommodate;
    }

    public void setCarAccommodate(int carAccommodate) {
        this.carAccommodate = carAccommodate;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getdTele() {
        return dTele;
    }

    public void setdTele(String dTele) {
        this.dTele = dTele;
    }

    public int getcDistance() {
        return cDistance;
    }

    public void setcDistance(int cDistance) {
        this.cDistance = cDistance;
    }

    @Override
    public String toString() {
        return "Car{" +
                "cId='" + cId + '\'' +
                ", comId='" + comId + '\'' +
                ", carAccommodate=" + carAccommodate +
                ", driver='" + driver + '\'' +
                ", dTele='" + dTele + '\'' +
                ", cDistance=" + cDistance +
                '}';
    }
}
