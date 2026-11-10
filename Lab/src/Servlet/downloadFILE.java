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
import Entity.FILE;
import Entity.MASed;
import SERVICE.parUser;

/**
 * Servlet implementation class downloadFILE
 */
@WebServlet("/downloadFILE")
public class downloadFILE extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<FILE> listFILE=parUser.selectFILE1();
		//放到请求对象中
		System.out.println(listFILE);
		request.setAttribute("filelist", listFILE);
		request.getRequestDispatcher("download.jsp").forward(request, response);}


}
