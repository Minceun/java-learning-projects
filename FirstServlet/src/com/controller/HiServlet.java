package com.controller; 
import java.io.IOException; 
import java.io.PrintWriter; 
import javax.servlet.ServletException; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
public class HiServlet extends HttpServlet 
{ 
	private static final long serialVersionUID = 9097003371258492207L; 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException 
	{
		PrintWriter out = resp.getWriter(); 
		out.println("Hello "+ req.getParameter("username") +". Servlet is coming."); 
		out.close(); 
		//doPost(req, resp); 
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException 
	{	//String name = req.getParameter("username"); 
		req.getRequestDispatcher("welcome.jsp") .forward(req, resp); 
	}
}