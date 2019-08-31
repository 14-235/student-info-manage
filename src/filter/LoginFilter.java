package filter;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String path = req.getRequestURI();
        
        if (path.endsWith(".css")||path.endsWith(".js")||path.endsWith(".svg")||path.endsWith("/loginPage")||path.endsWith("/login")) {
            chain.doFilter(req, resp);
        } else {
        	if("true".equals(req.getSession().getAttribute("isLogin"))) {
    			
    			chain.doFilter(req, resp);
    		} else {
    			
    			resp.sendRedirect(req.getContextPath() + "/loginPage");
    			
    		}
        }
        
        
//        if(url.endsWith(".css")||url.endsWith(".js")
//        		||url.endsWith(".jpg")
//                ||url.endsWith(".gif")||url.endsWith(".png")||url.endsWith(".svg")){
//            chain.doFilter(request, response);
//        }
//        System.out.println("=============");
		
	}
	
}
