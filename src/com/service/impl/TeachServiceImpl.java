package com.service.impl;

import com.entity.Order;
import com.entity.Teacher;
import com.service.TeachService;

import java.util.ArrayList;

public class TeachServiceImpl implements TeachService {
    @Override
    public boolean teachCheck(Teacher teacher) {
        return true;
    }

    @Override
    public Teacher getTeach(String tId) {
        return null;
    }

    @Override
    public ArrayList<Order> getOrders(Teacher teacher) {
        return null;
    }
}
