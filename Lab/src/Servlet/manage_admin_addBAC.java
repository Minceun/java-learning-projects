package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.BACed;
import Entity.MASed;
import SERVICE.parUser;

/**
 * Servlet implementation class manage_admin_addBAC
 */
@WebServlet("/manage_admin_addBAC")
public class manage_admin_addBAC extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset-utf-8");
		
		String BACid=request.getParameter("BACid");
		String BACname=request.getParameter("BACname");
		String BACgender=request.getParameter("BACgender");
		String BACtele=request.getParameter("BACtele");
		String BACemail=request.getParameter("BACemail");
		String BACMes=request.getParameter("BACMes");

		int status=Integer.parseInt(request.getParameter("status"));
		BACed bac =new BACed(BACid, BACname, BACgender, BACtele, BACemail, BACMes,status);
		
		int count=parUser.insertBAC1(bac);
		System.out.println("count = "+count);
		//成功或者失败的重定向
		if(count>0)
		{
			response.sendRedirect("managerGrau");
			
		}
		else {
			response.sendRedirect("managerGrau");
		}
	}

}
