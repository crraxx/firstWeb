package com.ff.firstWeb.serverlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;

public class LoginServlet_bank2 extends HttpServlet {
    /*
    无参构造方法默认存在
    init()可以不用重写,会调用父类的方法
    servlet可以滴啊用弗雷的
    get请求--doGet()
    post请求--doPost()
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet");
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        System.out.println(name+"::"+age);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        System.out.println("doPost");
        String acount = req.getParameter("acount");
        String password = req.getParameter("password");
        String sex = req.getParameter("sex");
        String work = req.getParameter("work");
        String[] course = req.getParameterValues("course");
        System.out.println(acount+"::"+password+"::"+sex+"::"+work+"::"+ Arrays.toString(course));

        //请求接收中的数据(请求行,请求头)
        /*System.out.println(req.getMethod());
        System.out.println(req.getRemoteAddr());
        System.out.println(req.getServerName());
        System.out.println(req.getServerPort());
        System.out.println(req.getScheme());
        System.out.println(req.getProtocol());
        System.out.println(req.getContentType());
        System.out.println(req.getContextPath());
        System.out.println(req.getHeader("User-Agent"));
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String name = headerNames.nextElement();
            System.out.println(name+":"+req.getHeader("name"));
        }*/


        //向客户端做出相应,本质使用IO字符输出流
        PrintWriter out = resp.getWriter();

    }
}