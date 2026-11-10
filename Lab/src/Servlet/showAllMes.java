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
import SERVICE.parUser;

/**
 * Servlet implementation class showAllMes
 */
@WebServlet("/showAllMes")
public class showAllMes extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String keywordString=request.getParameter("keywords");
		String docnameString=request.getParameter("docname");
		String masameString=request.getParameter("masname");
		ArrayList<DOCed> listD=null;
		ArrayList<MASed> listM=null;
		if((docnameString!=null)&&(masameString==null)) {
			listD=parUser.selectDoced1(docnameString);
			request.setAttribute("list", listD);
			request.getRequestDispatcher("new_show_doc_mes.jsp").forward(request, response);

		}else if((docnameString==null)&&(masameString!=null))
		{
			listM=parUser.selectMASed1(masameString);
			request.setAttribute("list", listM);
			request.getRequestDispatcher("new_show_mes.jsp").forward(request, response);

		}
		
	}

}
