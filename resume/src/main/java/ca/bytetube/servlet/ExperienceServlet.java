package ca.bytetube.servlet;

import ca.bytetube.bean.Experience;
import ca.bytetube.beans.util.Beans;
import ca.bytetube.service.CompanyService;
import ca.bytetube.service.ExperienceService;
import ca.bytetube.service.impl.CompanyServiceImpl;
import ca.bytetube.service.impl.ExperienceServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/experience/*")
public class ExperienceServlet extends BaseServlet {
    private static final ExperienceService service = new ExperienceServiceImpl();
    private static final CompanyService companyService = new CompanyServiceImpl();

    public void save(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        Experience experience = Beans.convert(request.getParameterMap(), Experience.class);
        if (service.save(experience)) {
            redirect( "experience/admin", request, response);
        } else {
            forwardError("save experience failed ", request, response);
        }
    }

    public void admin(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        request.setAttribute("experiences", service.find());
        request.setAttribute("menu", "experience");
        request.setAttribute("companies", companyService.find());
        forward("admin/experience.jsp", request, response);
    }

    public void front(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        request.setAttribute("experiences", service.find());
        forward("front/experience.jsp", request, response);
    }

    public void remove(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String[] id = request.getParameterValues("id");
        List<Integer> ids = new ArrayList<>();
        for (String i : id) {
            ids.add(Integer.valueOf(i));
        }
        if (service.remove(ids)) {
            redirect("experience/admin", request, response);
        } else {
            forwardError("remove experience failed", request, response);
        }
    }
}
