package ca.bytetube.servlet;

import ca.bytetube.bean.Award;
import ca.bytetube.bean.Skill;
import ca.bytetube.beans.util.Beans;
import ca.bytetube.service.AwardService;
import ca.bytetube.service.SkillService;
import ca.bytetube.service.impl.AwardServiceImpl;
import ca.bytetube.service.impl.SkillServiceImpl;
import ca.bytetube.util.Uploads;
import org.apache.commons.fileupload.FileItem;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet("/award/*")
public class AwardServlet extends BaseServlet {
    private static final AwardService service = new AwardServiceImpl();
    public void save(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, Object> params = Uploads.getParams(request);
        Award award = Beans.convert(params, Award.class);
        award.setImage(Uploads.uploadImage((FileItem) params.get("imageFile"),request,award.getImage()));
        if (service.save(award)) {
            redirect( "award/admin", request, response);
        } else {
            forwardError("fail to save award", request, response);
        }
    }

    public void admin(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        List<Award> awards = service.find();
        request.setAttribute("awards", awards);
        request.setAttribute("menu", "award");
        forward("admin/award.jsp", request, response);
    }

    public void remove(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String[] id = request.getParameterValues("id");
        List<Integer> ids = new ArrayList<>();
        for (String i : id) {
            ids.add(Integer.valueOf(i));
        }
        if (service.remove(ids)) {
            redirect("award/admin", request, response);
        } else {
            forwardError("fail to delete award", request, response);
        }
    }
}
