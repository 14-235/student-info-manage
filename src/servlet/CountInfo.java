package servlet;

import java.io.IOException;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

import service.CountInfoService;

/**
 * Servlet implementation class CountInfo
 */
@WebServlet("/CountInfo")
public class CountInfo extends HttpServlet {
    CountInfoService countInfoService = new CountInfoService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CountInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json; charset=utf-8");
		JSONObject res = countInfoService.getAllCountData((HashSet)request.getSession().getAttribute("AllDeptsSet"));
		response.getWriter().write(res.toJSONString());
	}

}
