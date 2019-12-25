package com.service.impl;

import com.dao.RentDao;
import com.dao.impl.RentDaoImpl;
import com.entity.Car;
import com.entity.Order;
import com.entity.RentInfo;
import com.service.RentService;

import java.util.ArrayList;

public class RentServiceImpl implements RentService {
    private RentDao rentDao = new RentDaoImpl();

    @Override
    public ArrayList<Car> findCar(RentInfo ri) {
        return rentDao.findCar(ri);
    }

    /**
     * 这里有逻辑需要处理：charge 花销的计算
     * 每1公里收费2元
     * @param order
     * @return
     */
    @Override
    public boolean rent(Order order) {
        order.setCharge(order.getDistance() * 2);
        return rentDao.rent(order);
    }
}
