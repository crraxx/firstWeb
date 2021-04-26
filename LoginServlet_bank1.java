
package com.ff.firstWeb.serverlet;

        import javax.servlet.*;
        import javax.servlet.http.HttpServlet;
        import java.io.IOException;

public class LoginServlet_bank1 extends HttpServlet {
    /*
     * 在客户端第一次访问loginServlet时创建,服务器启动时创建
     * 只被调用一次,只创建一个servlet对象  单实例的
     * 在创建servlet时,应由servlet容器完成,创建实例应在init()之前
     * */
    public LoginServlet_bank1() {
        System.out.println("LoginServlet无参构造方法");
    }

    /*
     * 提供服务器
     * 每次请求都会调用service
     * */
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("service");
    }

    /*
     * 初始化,在创建对象后,构造方法执行后,调用init方法,完成一些初始化操作
     * 只执行一次
     * 如果没有初始化操作可以不用重写init()方法,服务器会调用init(),调用父类中的方法
     * */
    /*@Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println(config.getInitParameter("count"));
        System.out.println("init");
    }*/


    /*
    在服务器关闭前,servlet销毁之前调用
    可以在此方法中完成一些最终操作,比如保存日志
    如果没有最终操作,可以不用重写,但会调用父类中的destory方法
     */
    @Override
    public void destroy() {
        System.out.println("destroy");
    }


}
