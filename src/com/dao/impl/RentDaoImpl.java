package com.dao.impl;

import com.dao.RentDao;
import com.entity.Car;
import com.entity.Order;
import com.entity.RentInfo;
import com.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RentDaoImpl implements RentDao {
    private Connection conn = null;

    @Override
    public ArrayList<Car> findCar(RentInfo ri) {
        conn = DBUtil.getInstance().getConnection();
        String sql = "select * from car where car_id not in (" +
                "select distinct car_id from orders where " +
                "begin_date>=? and end_date<=?" +
                ") and car.max_distance>=? and car_capacity>=?";

        ArrayList<Car> carlist = new ArrayList<>();
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, ri.getbDate());
            pre.setString(2, ri.getrDate());
            pre.setInt(3, ri.getDistance());
            pre.setInt(4, ri.getAccommodate());
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Car car = new Car();
                car.setcId(rs.getString("car_id"));
                car.setComId(rs.getString("company_id"));
                car.setDriver(rs.getString("driver"));
                car.setCarAccommodate(rs.getInt("car_capacity"));
                car.setcDistance(rs.getInt("max_distance"));
                car.setdTele(rs.getString("d_tel"));
                car.setPrice(rs.getInt("price"));
                carlist.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.getInstance().closeConn(conn);
        }
        return carlist;
    }

    @Override
    public boolean rent(Order order) {
        conn = DBUtil.getInstance().getConnection();
        String sql = "insert into orders(" +
                "car_id,t_id,distance,begin_date,end_date,order_id,state) values (" +
                "?,?,?,?,?,?,?)";

        int flag = 0;
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, order.getcId());
            pre.setString(2, order.gettId());
            pre.setInt(3, order.getDistance());
            pre.setString(4, order.getbDate());
            pre.setString(5, order.getrDate());
            pre.setString(6, order.getoId());
            pre.setInt(7, order.getState());
            flag = pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.getInstance().closeConn(conn);
        }
        return flag > 0;
    }
}
