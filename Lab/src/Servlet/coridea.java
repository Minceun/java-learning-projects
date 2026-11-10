package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.COR;
import Entity.participantMes;
import SERVICE.parUser;

/**
 * Servlet implementation class coridea
 */
@WebServlet("/coridea")
public class coridea extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset-utf-8");
		
		String name=request.getParameter("name");
		String gender=request.getParameter("gender");
		int age=Integer.parseInt(request.getParameter("age"));
		String idea=request.getParameter("idea");
		String tele=request.getParameter("tele");
		COR cor=new COR(name,gender,age,idea,tele);
		//加入到数据库的用户表中
		System.out.println(cor);
		int count=parUser.insertCOR1(cor);
		System.out.println("count = "+count);
		//成功或者失败的重定向
		if(count>0)
		{
			response.sendRedirect("index.jsp");
			//返回到首页
			
		}
		else {
			
			response.sendRedirect("CORIDEA.jsp");
		}
	}

}
