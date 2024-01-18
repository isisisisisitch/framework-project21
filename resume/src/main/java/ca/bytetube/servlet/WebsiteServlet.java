package ca.bytetube.servlet;

import ca.bytetube.bean.Website;
import ca.bytetube.beans.util.Beans;
import ca.bytetube.service.WebsiteService;
import ca.bytetube.service.impl.WebsiteServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/website/*")
public class WebsiteServlet extends BaseServlet {
    private static final WebsiteService service = new WebsiteServiceImpl();

    public void admin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //System.out.println("website - admin");
        List<Website> websites = service.find();
        if (websites.size() > 0) {
            request.setAttribute("website", websites.get(0));
        }
        request.setAttribute("menu", "website");
        forward("admin/website.jsp", request, response);
    }


    public void save(HttpServletRequest request, HttpServletResponse response) throws Exception{
        Website website = Beans.convert(request.getParameterMap(), Website.class);
        if (service.save(website)) {
            response.sendRedirect(request.getContextPath()+"/website/admin");
        }else {
            request.setAttribute("error","website info save error");
            request.getRequestDispatcher("/page/error.jsp").forward(request,response);
        }
    }
}
