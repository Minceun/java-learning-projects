package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.BACed;
import Entity.DOCed;
import Entity.MASed;
import Entity.participantMes;
import SERVICE.parUser;

/**
 * Servlet implementation class showAllGrad
 */
@WebServlet("/showAllGraud")
public class showAllGraud extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String keywordString=request.getParameter("keywords");

		ArrayList<DOCed> listD=parUser.selectDoced1();
		ArrayList<MASed> listM=parUser.selectMASed1();
		ArrayList<BACed> listB=parUser.selectBACed1();
		//放到请求对象中
		System.out.println(listD);
		request.setAttribute("LISTDOC", listD);
		request.setAttribute("LISTMAS", listM);
		request.setAttribute("LISTBAC", listB);
		System.out.println(listB);
		request.getRequestDispatcher("AllGrau.jsp").forward(request, response);
		
	}

}
