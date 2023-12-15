package ca.bytetube.servlet;

import ca.bytetube.util.Uris;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain;charset=UTF-8");
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Method method = getClass().getMethod(
                    Uris.lastPath(request.getRequestURI()),
                    HttpServletRequest.class,
                    HttpServletResponse.class);
            method.invoke(this, request, response);
        } catch (Exception e) {
            Throwable exception = e;
            exception.printStackTrace();
            while (exception.getCause() != null) {
                exception = exception.getCause();
            }
            String msg = "【" + request.getRequestURI() + "】"
                    + exception.getMessage();
            forwardError(msg, request, response);
        }
    }

    protected void forward(String path, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/page/" + path).forward(request, response);
    }

    protected void forwardError(String msg, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("error", msg);
        forward("error.jsp", request, response);
    }

    protected void redirect(String path, HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect(request.getContextPath() + "/" + path);
    }
}
