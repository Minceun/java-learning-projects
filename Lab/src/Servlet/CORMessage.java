package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.COR;
import Entity.participantMes;
import SERVICE.parUser;

/**
 * Servlet implementation class CORMessage
 */
@WebServlet("/CORMessage")
public class CORMessage extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<COR> corlist=parUser.selectCOR1();
		//放到请求对象中
		request.setAttribute("corlist", corlist);
		request.getRequestDispatcher("manageCor.jsp").forward(request, response);
		
	}


}
