package com.service.impl;

import com.entity.Car;
import com.entity.Order;
import com.entity.RentInfo;
import com.service.RentService;

import java.util.ArrayList;

public class RentServiceimpl implements RentService {
    @Override
    public ArrayList<Car> findCar(RentInfo ri) {
        return null;
    }

    @Override
    public boolean rent(Order order) {
        return true;
    }
}
