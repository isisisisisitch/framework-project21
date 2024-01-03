package ca.bytetube.servlet;

import ca.bytetube.bean.Skill;
import ca.bytetube.beans.util.Beans;
import ca.bytetube.service.SkillService;
import ca.bytetube.service.impl.SkillServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/skill/*")
public class SkillServlet extends BaseServlet {
    private static final SkillService service = new SkillServiceImpl();

    public void save(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        Skill skill = Beans.convert(request.getParameterMap(), Skill.class);
        if (service.save(skill)) {
            redirect( "skill/admin", request, response);
        } else {
            forwardError("fail to save skills", request, response);
        }
    }

    public void admin(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        List<Skill> skills = service.find();
        request.setAttribute("skills", skills);
        request.setAttribute("menu", "skill");
        forward("admin/skill.jsp", request, response);
    }

    public void remove(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String[] id = request.getParameterValues("id");
        List<Integer> ids = new ArrayList<>();
        for (String i : id) {
            ids.add(Integer.valueOf(i));
        }
        if (service.remove(ids)) {
            redirect("skill/admin", request, response);
        } else {
            forwardError("fail to delete skills", request, response);
        }
    }
}
