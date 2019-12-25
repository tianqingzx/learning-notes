package com.service;

import com.entity.Order;
import com.entity.Teacher;

import java.util.ArrayList;

public interface TeachService {
    boolean teachCheck(Teacher teacher);
    Teacher getTeach(String tId);
    ArrayList<Order> getOrders(Teacher teacher);
}
