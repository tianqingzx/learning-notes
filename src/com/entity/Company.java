package com.entity;

public class Company {
    private String comId;
    private String address;
    private String compTele;
    private String comName;

    public Company() {
    }

    public Company(String comId, String address, String compTele, String comName) {
        this.comId = comId;
        this.address = address;
        this.compTele = compTele;
        this.comName = comName;
    }

    public String getComId() {
        return comId;
    }

    public void setComId(String comId) {
        this.comId = comId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompTele() {
        return compTele;
    }

    public void setCompTele(String compTele) {
        this.compTele = compTele;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    @Override
    public String toString() {
        return "Company{" +
                "comId='" + comId + '\'' +
                ", address='" + address + '\'' +
                ", compTele='" + compTele + '\'' +
                ", comName='" + comName + '\'' +
                '}';
    }
}
