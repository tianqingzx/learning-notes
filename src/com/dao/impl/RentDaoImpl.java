package com.dao.impl;

import com.dao.RentDao;
import com.entity.Car;
import com.entity.Order;
import com.entity.RentInfo;

import java.util.ArrayList;

public class RentDaoImpl implements RentDao {
    @Override
    public ArrayList<Car> findCar(RentInfo ri) {
        return null;
    }

    @Override
    public boolean rent(Order order) {
        return false;
    }
}
