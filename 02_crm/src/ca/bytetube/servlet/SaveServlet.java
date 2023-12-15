package ca.bytetube.servlet;

import ca.bytetube.Data;
import ca.bytetube.bean.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * 转发vs重定向
 * 转发： request.getRequestDispatcher("").forward(request,response);
 * 1.转发只能在同一个context下发生，路径不用包含contextPath
 * 2.客户端只需要发送一次请求
 * 3.浏览器地址栏的url不会发生改变
 * 4.转发是服务器内部行为
 *
 * 重定向： response.sendRedirect("");
 * 1.可以重定向到任意的url上，如果重定向到同一个contextPath的时候，路径中必须包含contextPath
 * 2.客户端会向服务器端发送多次请求
 * 3.浏览器地址栏的url会发生改变
 * 4.重定向需要客户端和服务器配合完成
 */
@WebServlet("/save")
public class SaveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取参数
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String height = request.getParameter("height");

        //2.封装数据
        Customer customer = new Customer();
        customer.setName(name);
        customer.setAge(Integer.valueOf(age));
        customer.setHeight(Double.valueOf(height));
        Data.addCustomer(customer);

        //分发数据
        //redirect
        response.sendRedirect("/crm/list");

//        response.setStatus(302);
//        response.setHeader("Location","/crm/list");
//         request.getRequestDispatcher("/list").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
