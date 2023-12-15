package ca.bytetube.servlet;

import ca.bytetube.Data;
import ca.bytetube.bean.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/list")
public class ListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.从db中获取所有customer的数据
        List<Customer> customers = Data.getCustomer();

        //将数据存放在request中
        request.setAttribute("customers",customers);

        //转发到list.jsp中，进行页面展示
       request.getRequestDispatcher("/page/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
