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
        String sql = "select * from car where c_id not in (" +
                "select distinct c_id from orders where " +
                "Bdate>=? and Rdate<=?" +
                ") and c_distance>=? and car_accommodate>=?";

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
                car.setcId(rs.getString("c_id"));
                car.setComId(rs.getString("com_id"));
                car.setDriver(rs.getString("driver"));
                car.setCarAccommodate(rs.getInt("car_accommodate"));
                car.setcDistance(rs.getInt("c_distance"));
                car.setdTele(rs.getString("d_tel"));
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
        String sql_1 = "select max(o_id) from orders";
        String sql_2 = "insert into orders(" +
                "c_id,t_id,distance,Bdate,Rdate,charge,o_id,state) values (" +
                "?,?,?,?,?,?,?,?)";

        int o_id = 0;
        int flag = 0;
        try {
            PreparedStatement pre = conn.prepareStatement(sql_1);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                o_id = rs.getInt("o_id") + 1;
            }
            pre = conn.prepareStatement(sql_2);
            pre.setString(1, order.getcId());
            pre.setString(2, order.gettId());
            pre.setInt(3, order.getDistance());
            pre.setString(4, order.getbDate());
            pre.setString(5, order.getrDate());
            pre.setInt(6, order.getCharge());
            pre.setInt(7, o_id);
            pre.setInt(8, order.getState());
            flag = pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.getInstance().closeConn(conn);
        }
        if (flag > 0) {
            return true;
        }else {
            return false;
        }
    }
}
