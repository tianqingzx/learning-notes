package com.service;

import com.entity.Order;
import com.entity.SearchInfo;

import java.util.ArrayList;

public interface RentService {
    ArrayList<SearchInfo> findCar(SearchInfo ri);
    boolean rent(Order order);
}
