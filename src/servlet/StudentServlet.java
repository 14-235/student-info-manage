package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

import entities.Classinfo;
import entities.Student;
import service.StudentService;

public class StudentServlet extends HttpServlet{

	StudentService studentService= new StudentService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String classid = req.getParameter("classid");
		if(classid!=null) {
			resp.setContentType("application/json; charset=utf-8");
			resp.getWriter().write(studentService.getStudentsByClassId(Integer.parseInt(classid)));
			return;
		}
		resp.setContentType("application/json; charset=utf-8");
		resp.getWriter().write(studentService.getAllStudents());
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		JSONObject res = studentService.deleteClass(Integer.parseInt(req.getParameter("sid")));
		resp.setContentType("application/json; charset=utf-8");
		resp.getWriter().write(res.toJSONString());
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		JSONObject res = studentService.updateClass(new Student(Integer.parseInt(req.getParameter("sid")),req.getParameter("sname"),Integer.parseInt(req.getParameter("sex")),Integer.parseInt(req.getParameter("class")),req.getParameter("date")));
		resp.setContentType("application/json; charset=utf-8");
		resp.getWriter().write(res.toJSONString());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String method = req.getParameter("_method");
		if (method == null) {
			JSONObject res = studentService.addStudent(new Student(req.getParameter("sname"),Integer.parseInt(req.getParameter("sex")),Integer.parseInt(req.getParameter("class")),req.getParameter("date")));
			resp.setContentType("application/json; charset=utf-8");
			resp.getWriter().write(res.toJSONString());
		}else if(method.toLowerCase().equals("put")) {
			doPut(req,resp);
		}else if(method.toLowerCase().equals("delete")) {
			doDelete(req, resp);
		}
		
	}

}
