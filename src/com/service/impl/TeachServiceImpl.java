package com.service.impl;

import com.dao.TeachDao;
import com.dao.impl.TeachDaoImpl;
import com.entity.Order;
import com.entity.Teacher;
import com.service.TeachService;

import java.util.ArrayList;

public class TeachServiceImpl implements TeachService {
    private TeachDao teachDao = new TeachDaoImpl();

    @Override
    public boolean teachCheck(Teacher teach) {
        return teachDao.teachCheck(teach);
    }

    @Override
    public Teacher getTeach(String tId) {
        return teachDao.getTeach(tId);
    }

    @Override
    public ArrayList<Order> getOrders(Teacher teach) {
        return teachDao.getOrders(teach);
    }
}
