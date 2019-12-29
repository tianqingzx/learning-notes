package com.dao.impl;

import com.dao.RentDao;
import com.entity.Order;
import com.entity.SearchInfo;
import com.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RentDaoImpl implements RentDao {
    private Connection conn = null;

    @Override
    public ArrayList<SearchInfo> findCar(SearchInfo si) {
        conn = DBUtil.getInstance().getConnection();
        String sql = "select * from search_info where car_id not in (" +
                "select distinct car_id from t_order where " +
                "begin_date>=? and end_date<=?" +
                ") and max_distance>=? and car_capacity>=?";

        ArrayList<SearchInfo> searchInfos = new ArrayList<>();
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, si.getBeginDate());
            pre.setString(2, si.getEndDate());
            pre.setInt(3, si.getMaxDistance());
            pre.setInt(4, si.getCarCapacity());
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                SearchInfo searchInfo = new SearchInfo();
                searchInfo.setCarId(rs.getString("car_id"));
                searchInfo.setCompanyName(rs.getString("company_name"));
                searchInfo.setCompanyTel(rs.getString("company_tel"));
                searchInfo.setCarCapacity(rs.getInt("car_capacity"));
                searchInfo.setMaxDistance(rs.getInt("max_distance"));
                searchInfo.setPrice(rs.getInt("price"));
                searchInfos.add(searchInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.getInstance().closeConn(conn);
        }
        return searchInfos;
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
            pre.setString(1, order.getCarId());
            pre.setString(2, order.gettId());
            pre.setInt(3, order.getDistance());
            pre.setString(4, order.getBeginDate());
            pre.setString(5, order.getEndDate());
            pre.setString(6, order.getOrderId());
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
