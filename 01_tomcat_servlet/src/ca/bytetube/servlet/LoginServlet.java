package ca.bytetube.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("doPost");
        outHTML(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        outPlain(request, response);
    }

    private void outHTML(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //0.设置请求数据的编码集
        request.setCharacterEncoding("UTF-8");
        //1.取出客户端发送到服务器端的数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");

//        System.out.println(username +":" + password);
        //设置response的编码集
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //2.校验用户名密码是否正确
        if ("bytetube".equals(username) && "111111".equals(password)) {
            out.write("<h1 style=\"color: red; border: 1px solid blue;\">login success</h1>");
            out.write("<ul>");
            out.write(" <li>product1</li>");
            out.write(" <li>product2</li>");
            out.write(" <li>product3</li>");
            out.write("</ul>");
        } else {
            out.write("<h1 style=\"color: red; border: 1px solid blue;\">login failed</h1>");

        }
    }

    private void outPlain(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //0.设置请求数据的编码集
        request.setCharacterEncoding("UTF-8");
        //1.取出客户端发送到服务器端的数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");

//        System.out.println(username +":" + password);
        //设置response的编码集
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //2.校验用户名密码是否正确
        if ("bytetube".equals(username) && "111111".equals(password)) {
            out.write("登陆成功");
        } else {
            out.write("login failed");
        }
    }
}
