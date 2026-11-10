package com.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)arg0;
		HttpServletResponse resp = (HttpServletResponse)arg1;
		String login = (String)req.getSession().getAttribute("login");
		if(login == null || login.trim() == "") {
			resp.sendRedirect(req.getContextPath());
		}else {
			String servletPath = req.getServletPath();
			if(login.equals("student")) {//学生身份
				if(!servletPath.contains("student") && !servletPath.equals("/teacher/tea_infoByStu") && !servletPath.contains("Password")) {
					resp.sendRedirect(req.getContextPath());
				}
				arg2.doFilter(arg0, arg1);
			}else if(login.equals("teacher")) {
				if(!servletPath.contains("teacher") && !servletPath.equals("/student/Info") && !servletPath.contains("Password")) {
					resp.sendRedirect(req.getContextPath());
				}
				arg2.doFilter(arg0, arg1);
			}else {
				if(!servletPath.contains("Admin")) {
					resp.sendRedirect(req.getContextPath());
				}
				arg2.doFilter(arg0, arg1);
			}
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
