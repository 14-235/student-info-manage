package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

import service.LoginService;

public class LoginServlet extends HttpServlet {
	LoginService loginService = new LoginService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String un = req.getParameter("username");
		String up = req.getParameter("password");
		
		JSONObject res = loginService.login(un, up);
		if("1".equals(res.get("flag"))) {
			req.getSession().setAttribute("isLogin", "true");
			req.getSession().setAttribute("username", res.get("username"));
		}
		resp.setContentType("application/json; charset=utf-8");
		resp.getWriter().write(res.toJSONString());
	}
}
