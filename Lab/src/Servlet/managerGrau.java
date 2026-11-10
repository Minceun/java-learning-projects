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
 * Servlet implementation class managerGrau
 */
@WebServlet("/managerGrau")
public class managerGrau extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//获取数据库中所有的信息，将信息转发到对应的页面
		ArrayList<DOCed> listD=parUser.selectDoced1();
		ArrayList<MASed> listM=parUser.selectMASed1();
		ArrayList<BACed> listB=parUser.selectBACed1();
		//放到请求对象中
		System.out.println(listD);
		request.setAttribute("listDoc", listD);
		request.setAttribute("listMas", listM);
		request.setAttribute("listBac", listB);
		request.getRequestDispatcher("manageShowGrau.jsp").forward(request, response);
		
		}

}
