package com.dao;

import com.entity.Order;
import com.entity.SearchInfo;

import java.util.ArrayList;

public interface RentDao {
    ArrayList<SearchInfo> findCar(SearchInfo si);
    boolean rent(Order order);
}
