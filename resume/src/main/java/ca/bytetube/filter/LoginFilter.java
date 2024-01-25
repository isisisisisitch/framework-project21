package ca.bytetube.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {


    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String uri = request.getRequestURI();
        Object user = request.getSession().getAttribute("user");
        System.out.println(user);
        // System.out.println(uri);
        if (uri.contains("/asset/") || uri.contains("/page/") || uri.contains("/captcha") || uri.contains("/user/login")) {
            chain.doFilter(request, response);
        } else if ((uri.contains("/admin") || uri.contains("/remove") || uri.contains("/save")) && user == null) {

            response.sendRedirect(request.getContextPath() + "/page/login.jsp");
        } else {
            chain.doFilter(request, response);
        }


    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }

}
