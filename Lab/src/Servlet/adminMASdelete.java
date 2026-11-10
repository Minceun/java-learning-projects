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
 * Servlet implementation class adminMASdelete
 */
@WebServlet("/adminMASdelete")
public class adminMASdelete extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("进入删除的函数！");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset-utf-8");
		String MASid=request.getParameter("id");
		MASed mas=parUser.selectMASById1(MASid);
		System.out.println("bac对象 "+mas);
		int count=parUser.deleteMAS1(mas);
		System.out.println("删除的count = "+count);
		//成功或者失败的重定向
		if(count==0)
		{//修改成功
			response.sendRedirect("/Lab/managerGrau");
			
		}
		else {
			response.sendRedirect("/Lab/managerGrau");
		}
		}


}
