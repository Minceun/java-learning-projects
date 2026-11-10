package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.participantMes;
import SERVICE.parUser;

/**
 * Servlet implementation class ManaParticipant
 */
@WebServlet("/ManaParticipant")
public class ManaParticipant extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//				String keywordString=request.getParameter("keywords");

				
				//获取所有用户
				ArrayList<participantMes> list=parUser.selectAll1();
				//放到请求对象中
				request.setAttribute("PARlist", list);
				request.getRequestDispatcher("managePar.jsp").forward(request, response);
				
				
	}


}
