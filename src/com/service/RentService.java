package com.service;

import com.entity.Car;
import com.entity.Order;
import com.entity.RentInfo;

import java.util.ArrayList;

public interface RentService {
    ArrayList<Car> findCar(RentInfo ri);
    boolean rent(Order order);
}
