package ca.bytetube.servlet;

import ca.bytetube.bean.Project;
import ca.bytetube.beans.util.Beans;
import ca.bytetube.service.CompanyService;
import ca.bytetube.service.ProjectService;
import ca.bytetube.service.impl.CompanyServiceImpl;
import ca.bytetube.service.impl.ProjectServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/project/*")
public class ProjectServlet extends BaseServlet {
    private static final ProjectService service = new ProjectServiceImpl();
    private static final CompanyService companyService = new CompanyServiceImpl();

    public void save(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        Project project = Beans.convert(request.getParameterMap(), Project.class);
        if (service.save(project)) {
            redirect( "project/admin", request, response);
        } else {
            forwardError("save project failed", request, response);
        }
    }

    public void admin(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        request.setAttribute("projects", service.find());
        request.setAttribute("menu", "project");
        request.setAttribute("companies", companyService.find());
        forward("admin/project.jsp", request, response);
    }

    public void front(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        request.setAttribute("projects", service.find());
        forward("front/project.jsp", request, response);
    }

    public void remove(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String[] id = request.getParameterValues("id");
        List<Integer> ids = new ArrayList<>();
        for (String i : id) {
            ids.add(Integer.valueOf(i));
        }
        if (service.remove(ids)) {
            redirect("project/admin", request, response);
        } else {
            forwardError("remove project failed", request, response);
        }
    }
}
