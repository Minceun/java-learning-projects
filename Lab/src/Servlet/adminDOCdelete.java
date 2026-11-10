package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.DOCed;
import Entity.MASed;
import SERVICE.parUser;

/**
 * Servlet implementation class adminDOCdelete
 */
@WebServlet("/adminDOCdelete")
public class adminDOCdelete extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("进入删除的函数！");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset-utf-8");
		String DOCid=request.getParameter("id");
		DOCed doc=parUser.selectDOCById1(DOCid);
		System.out.println("DOC对象 "+doc);
		int count=parUser.deleteDOC1(doc);
		System.out.println("删除的count = "+count);
		//成功或者失败的重定向
		if(count==0)
		{//修改成功
			response.sendRedirect("/Lab/managerGrau");
			
		}
		else {
			response.sendRedirect("/Lab/managerGrau");
		}}

}
