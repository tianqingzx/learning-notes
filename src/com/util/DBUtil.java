package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 * JDBC链接类，提供连接，关闭连接
 * @author ZX
 *
 */
public class DBUtil {
    private static DBUtil dbUtil = new DBUtil();

    private Connection conn = null;

    private DBUtil() {
        try {
            String driverClass = "com.mysql.jdbc.Driver";
            Class.forName(driverClass);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public static DBUtil getInstance() {
        return dbUtil;
    }

    public Connection getConnection() {
//		Connection conn = null;
        try {
            String userName = "root";
            String url = "jdbc:mysql://localhost:3306/rent_car?useUnicode=true&characterEncoding=utf8";
            String password = "1234";
            conn = DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return conn;
    }

    public void closeConn(Connection conn) {
        try {
            conn.close();
            conn = null;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
