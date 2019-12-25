package com.dao;

import com.entity.Car;
import com.entity.Order;
import com.entity.RentInfo;

import java.util.ArrayList;

public interface RentDao {
    ArrayList<Car> findCar(RentInfo ri);
    boolean rent(Order order);
}
