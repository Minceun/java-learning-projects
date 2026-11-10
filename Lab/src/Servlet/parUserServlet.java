package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.participantMes;
import SERVICE.parUser;

/**
 * Servlet implementation class parUserServlet
 */
@WebServlet("/parUserServlet")
public class parUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset-utf-8");
		
		String name=request.getParameter("name");
		String gender=request.getParameter("gender");
		int age=Integer.parseInt(request.getParameter("age"));
		String tele=request.getParameter("tele");
		String degree=request.getParameter("degree");
		String work=request.getParameter("work");
		String message=request.getParameter("message");
		String prize=request.getParameter("prize");
		String reason=request.getParameter("reason");
		participantMes parMes1=new participantMes(name, gender, age, tele,degree, work, message, prize, reason);
		//加入到数据库的用户表中
		System.out.println(parMes1);
		int count=parUser.insert1(parMes1);
		System.out.println("count = "+count);
		//成功或者失败的重定向
		if(count>0)
		{
			response.sendRedirect("index.jsp");
			
		}
		else {
			
			response.sendRedirect("participant.jsp");
		}
	}

}
