package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.DOCed;
import Entity.MASed;
import Entity.admin;
import SERVICE.parUser;

/**
 * Servlet implementation class manage_admin_addMAS
 */
@WebServlet("/manage_admin_addMAS")
public class manage_admin_addMAS extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset-utf-8");
		
		String MASid=request.getParameter("MASid");
		String MASname=request.getParameter("MASname");
		String MASgender=request.getParameter("MASgender");
		String MAStele=request.getParameter("MAStele");
		String MASfield=request.getParameter("MASfield");
		String MASemail=request.getParameter("MASemail");
		String MASMes=request.getParameter("MASMes");
		String MASresult=request.getParameter("MASresult");
		String MASpatent=request.getParameter("MASpatent");
		int status=Integer.parseInt(request.getParameter("status"));
		MASed mas=new MASed(MASid, MASname, MASgender, MAStele, MASfield, MASemail, MASMes, MASresult, MASpatent, status);
		
		int count=parUser.insertMAS1(mas);
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
