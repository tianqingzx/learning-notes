package com.dao.impl;

import com.dao.TeachDao;
import com.entity.Order;
import com.entity.Teacher;
import com.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TeachDaoImpl implements TeachDao {
    private Connection conn = null;

    @Override
    public boolean teachCheck(Teacher teach) {
        conn = DBUtil.getInstance().getConnection();
        String sql = "select * from teacher where t_id=? and t_password=?";

        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, teach.gettId());
            pre.setString(2, teach.gettPassword());
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.getInstance().closeConn(conn);
        }
        return false;
    }

    @Override
    public Teacher getTeach(String tId) {
        conn = DBUtil.getInstance().getConnection();
        String sql = "select * from teacher where t_id=?";

        Teacher teacherDB = null;
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, tId);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                teacherDB = new Teacher();
                teacherDB.settId(rs.getString("t_id"));
                teacherDB.settName(rs.getString("t_name"));
                teacherDB.settPassword(rs.getString("t_password"));
                teacherDB.settTele(rs.getString("t_tel"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.getInstance().closeConn(conn);
        }
        return teacherDB;
    }

    @Override
    public ArrayList<Order> getOrders(Teacher teach) {
        conn = DBUtil.getInstance().getConnection();
        String sql = "select * from orders where t_id=?";

        ArrayList<Order> orderlist = new ArrayList<>();
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, teach.gettId());
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.settId(rs.getString("t_id"));
                order.setcId(rs.getString("car_id"));
                order.setDistance(rs.getInt("distance"));
                order.setbDate(rs.getString("begin_date"));
                order.setrDate(rs.getString("end_date"));
                order.setoId(rs.getString("order_id"));
                order.setState(rs.getInt("state"));
                orderlist.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.getInstance().closeConn(conn);
        }
        return orderlist;
    }
}
