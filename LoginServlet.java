package com.ff.firstWeb.serverlet;

import com.ff.firstWeb.dao.checkDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoginServlet extends HttpServlet {
    /*
    无参构造方法默认存在
    init()可以不用重写,会调用父类的方法
    servlet可以滴啊用弗雷的
    get请求--doGet()
    post请求--doPost()
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        resp.setHeader("content-type", "text/html;charset=utf-8");
        //向客户端做出相应,本质使用IO字符输出流
        PrintWriter out = resp.getWriter();
        Connection connection = null;
        try {
            if (checkDao.link(account, password)) {
                int x = 10/0;
                String ip = req.getRemoteAddr();
                Date date = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String login_time = dateFormat.format(date);
                checkDao.insert(account,ip,login_time);
                out.print("登陆成功");
            } else {
                out.print("密码或账户错误");
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
            resp.sendRedirect("505.jsp");
        }
    }
}


