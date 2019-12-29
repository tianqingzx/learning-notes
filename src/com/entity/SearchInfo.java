package com.entity;

/**
 * 该类被使用来记录用户输入的租车条件
 * @author ZX
 */
public class SearchInfo {
    private String carId;
    private String companyName;
    private String companyTel;
    private String beginDate;
    private String endDate;
    private int carCapacity;
    private int maxDistance;
    private int price;

    public SearchInfo() {
    }

    public SearchInfo(String carId, String companyName, String companyTel, String beginDate, String endDate, int carCapacity, int maxDistance, int price) {
        this.carId = carId;
        this.companyName = companyName;
        this.companyTel = companyTel;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.carCapacity = carCapacity;
        this.maxDistance = maxDistance;
        this.price = price;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
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

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getCarCapacity() {
        return carCapacity;
    }

    public void setCarCapacity(int carCapacity) {
        this.carCapacity = carCapacity;
    }

    public int getMaxDistance() {
        return maxDistance;
    }

    public void setMaxDistance(int maxDistance) {
        this.maxDistance = maxDistance;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "车辆信息[" +
                "车牌号：'" + carId + '\'' +
                ", 所属公司名：'" + companyName + '\'' +
                ", 公司电话：'" + companyTel + '\'' +
                ", 核载人数：" + carCapacity +
                ", 最大行驶距离：" + maxDistance +
                ", 租费：" + price +
                ']';
    }
}
