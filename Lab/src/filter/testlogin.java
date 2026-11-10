package filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class testlogin
 */
@WebFilter("/*")
public class testlogin implements Filter {

    /**
     * Default constructor. 
     */
    public testlogin() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse resp=(HttpServletResponse)response;
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset-utf-8");
		HttpSession session=req.getSession();
		String flag=(String)session.getAttribute("isLogin");
		String request_uri=req.getRequestURI();
		String ctxpath=req.getContextPath();
		String uri=request_uri.substring(ctxpath.length());
		System.out.println("flag值 = "+flag);

		System.out.println("uri = "+uri);
		if (uri.contains("manage")||(uri.contains("admin"))) {
			if(flag!=null&&flag.equals("1"))
			{
				System.out.println("flag值 = "+flag);
				chain.doFilter(request, response);
			}else {
				PrintWriter out=response.getWriter();
				out.write("<script>");
				out.write("location.href='/Lab/login.jsp';");
				out.write("</script>");
				out.close();
				System.out.println("管理员未登录，这些页面不可以访问！");
				return;
			}
		}else {
			chain.doFilter(request, response);
		}
		
}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
