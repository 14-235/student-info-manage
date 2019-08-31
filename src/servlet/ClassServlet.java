package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

import entities.Classinfo;
import service.ClassService;

public class ClassServlet extends HttpServlet{
	ClassService classService = new ClassService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json; charset=utf-8");
		JSONObject res = classService.getAllClasses();
		req.getSession().setAttribute("AllDeptsSet", res.get("depts"));
		
		resp.getWriter().write(res.toJSONString());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String method = req.getParameter("_method");
		if (method == null) {
			JSONObject res = classService.addClass(new Classinfo(req.getParameter("classname"),req.getParameter("subject"),req.getParameter("dept")));
			resp.setContentType("application/json; charset=utf-8");
			resp.getWriter().write(res.toJSONString());
		}else if(method.toLowerCase().equals("put")) {
			doPut(req,resp);
		}else if(method.toLowerCase().equals("delete")) {
			doDelete(req, resp);
		}
		
		
		
		
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JSONObject res = classService.deleteClass(Integer.parseInt(req.getParameter("id")));
		resp.setContentType("application/json; charset=utf-8");
		resp.getWriter().write(res.toJSONString());
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JSONObject res = classService.updateClass(new Classinfo(Integer.parseInt(req.getParameter("id")),req.getParameter("classname"),req.getParameter("subject"),req.getParameter("dept")));
		resp.setContentType("application/json; charset=utf-8");
		resp.getWriter().write(res.toJSONString());
	}
	
}
