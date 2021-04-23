package com.ff.firstWeb.dao;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class checkDao {
    static Connection connection;
    public static boolean link(String account,String password) throws SQLException {
        String usl = "jdbc:mysql://127.0.0.1:3306/school_db?characterEncoding=utf8&useSSL=false&serverTimezone=UTC";
        connection = DriverManager.getConnection(usl,"root","wyf523");
        String sql = "select* from users where user_account=? and user_password=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, account);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return true;
        }
        return false;
    }

    public static void insert(String account,String ip,String login_time) throws SQLException {
        String update = "insert into admin(account,ip,login_time)" + "values(?,?,?)";
        PreparedStatement ps = connection.prepareStatement(update);
        ps.setString(1, account);
        ps.setString(2, ip);
        ps.setString(3, login_time);
        ps.executeUpdate();
    }
}
