package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {
    
    private String charEncoding = null;


    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
    	System.out.println("EncodingFilter....");
        charEncoding = fConfig.getInitParameter("charEncoding");
        if (charEncoding == null || charEncoding.equals("null")) {
            throw new ServletException("EncodingFilter中的编码设置为空");
        }
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 将设置的编码与请求的编码进行比较，若不同，则将请求的编码设置为设置的编码
        if (!charEncoding.equals(request.getCharacterEncoding())) {
            request.setCharacterEncoding(charEncoding);
        }
        // 将相应的编码设置为设置的编码
        response.setCharacterEncoding(charEncoding);
        chain.doFilter(request, response);
        
    }
}
