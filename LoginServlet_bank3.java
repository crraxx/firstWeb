package com.ff.firstWeb.serverlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet_bank3 extends HttpServlet {
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
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        System.out.println("doPost");
        String acount = req.getParameter("acount");
        String password = req.getParameter("password");
        System.out.println(acount+"::"+password);

        //设置响应内容的编码格式
        resp.setHeader("content-type","text/html;charset=utf-8");
        //向客户端做出相应,本质使用IO字符输出流
        PrintWriter out = resp.getWriter();
        if (acount.equals("admin") && password.equals("111")){
            //早期的动态页面就是从servlet中输出的
            out.print("登陆成功");
            out.print("<Html>");
            out.print("<head>");
            out.print("</head>");
            out.print("<body>");
            for (int i = 0; i < 10; i++) {
                out.print("<h1>"+i+"</h1>");
            }
            out.print("</body>");
            out.print("</Html>");

            //问题:响应的页面十分复杂
            //解决方法:使用jsp的动态页面,本质也是servlet,作用是向客户端响应内容
        }else{
            out.print("账号或密码失败");
        }

    }
}