package com.service.impl;

import com.dao.RentDao;
import com.dao.impl.RentDaoImpl;
import com.entity.Order;
import com.entity.SearchInfo;
import com.service.RentService;

import java.util.ArrayList;
import java.util.Random;

public class RentServiceImpl implements RentService {
    private RentDao rentDao = new RentDaoImpl();

    @Override
    public ArrayList<SearchInfo> findCar(SearchInfo si) {
        return rentDao.findCar(si);
    }

    /**
     * 这里有逻辑需要处理：charge 花销的计算
     * 每1公里收费5元
     * 默认提交后状态为0
     * @param order
     * @return
     */
    @Override
    public boolean rent(Order order) {
        String order_id = "";
        String begin_date = order.getBeginDate();
        String car_id = order.getCarId();

        if (begin_date != null && car_id != null) {
            String[] str = begin_date.split("-");
            char[] chars = car_id.toCharArray();
//            System.out.println("str[" + str[0]  + str[1] + str[2] + "]");
//            System.out.println("chars[" + chars[0]  + "]");
            order_id = str[0] + str[1] + str[2] + chars[4] + chars[5] + chars[6];
        }

        Random random = new Random();
        int rand_num = random.nextInt(10000);
        order_id = order_id + rand_num;

        order.setOrderId(order_id);
        order.setState(0);
        return rentDao.rent(order);
    }
}
