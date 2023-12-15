package ca.bytetube.servlet;

import ca.bytetube.bean.Education;
import ca.bytetube.beans.util.Beans;
import ca.bytetube.service.EducationService;
import ca.bytetube.service.impl.EducationServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/education/*")
public class EducationServlet extends BaseServlet {
    private static final EducationService service = new EducationServiceImpl();

    public void save(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        Education education = Beans.convert(request.getParameterMap(), Education.class);
//        Education education = new Education();
//        BeanUtils.populate(education,request.getParameterMap());
        if (service.save(education)) {
            redirect( "education/admin", request, response);
        } else {
            forwardError("save education failed", request, response);
        }
    }

    public void admin(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        request.setAttribute("educations", service.find());
        request.setAttribute("menu", "education");
        forward("admin/education.jsp", request, response);
    }

    public void front(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        request.setAttribute("educations", service.find());
        forward("front/education.jsp", request, response);
    }

    public void remove(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String[] id = request.getParameterValues("id");
        List<Integer> ids = new ArrayList<>();
        for (String i : id) {
            ids.add(Integer.valueOf(i));
        }
        if (service.remove(ids)) {
            redirect("education/admin", request, response);
        } else {
            forwardError("del education failed", request, response);
        }
    }
}
