package com.dao;

import com.entity.Order;
import com.entity.Teacher;

import java.util.ArrayList;

public interface TeachDao {
    boolean teachCheck(Teacher teach);
    Teacher getTeach(String tId);
    ArrayList<Order> getOrders(Teacher teach);
}
