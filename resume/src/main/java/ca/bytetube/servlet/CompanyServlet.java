package ca.bytetube.servlet;

import ca.bytetube.bean.Company;
import ca.bytetube.beans.util.Beans;
import ca.bytetube.service.CompanyService;
import ca.bytetube.service.impl.CompanyServiceImpl;
import ca.bytetube.util.Uploads;
import org.apache.commons.fileupload.FileItem;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet("/company/*")
public class CompanyServlet extends BaseServlet {
    private static final CompanyService service = new CompanyServiceImpl();

    public void save(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        Map<String, Object> params = Uploads.getParams(request);
        Company company = Beans.convert(params, Company.class);
        company.setLogo(Uploads.uploadImage((FileItem) params.get("logoFile"), request, company.getLogo()));
        if (service.save(company)) {
            redirect( "company/admin", request, response);
        } else {
            forwardError("save company failed", request, response);
        }
    }

    public void admin(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        request.setAttribute("companies", service.find());
        request.setAttribute("menu", "company");
        forward("admin/company.jsp", request, response);
    }

    public void remove(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String[] id = request.getParameterValues("id");
        List<Integer> ids = new ArrayList<>();
        for (String i : id) {
            ids.add(Integer.valueOf(i));
        }
        if (service.remove(ids)) {
            redirect("company/admin", request, response);
        } else {
            forwardError("remove company failed", request, response);
        }
    }
}
