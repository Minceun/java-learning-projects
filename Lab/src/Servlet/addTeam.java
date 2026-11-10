package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.BACed;
import Entity.DOCed;
import Entity.MASed;
import Entity.News;
import SERVICE.parUser;

/**
 * Servlet implementation class addTeam
 */
@WebServlet("/addTeam")
public class addTeam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addTeam() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset-utf-8");
		
		String name=request.getParameter("name");
		String id=request.getParameter("id");
		String degree=request.getParameter("degree");
		String sex=request.getParameter("sex");
		String sta=request.getParameter("status");
		int status;
		if(sta==null) {sta="off";}
		if(sta.equals("on")) {
			status=1;
		}else {
			status=0;
		}
		
		System.out.println(name);
		System.out.println(id);
		System.out.println(degree);
		System.out.println(sex);
		System.out.println(status);

		if(degree.equals("0")) {
			BACed baced=new BACed(id,name,sex,"","","",status);
			int count=parUser.insertBAC(baced);
			if(count>0)
			{
				System.out.println("success!");
				response.sendRedirect("/Lab/admin/admin_teams/team.jsp");
			}
			else {
				System.out.println("error!");
				response.sendRedirect("/Lab/admin/admin_teams/team.jsp");
			}
		}if(degree.equals("1")) {
			MASed mased=new MASed(id,name,sex,"","","","","","",status);
			int count=parUser.insertMAS(mased);
			if(count>0)
			{
				System.out.println("success!");
				response.sendRedirect("/Lab/admin/admin_teams/team.jsp");
			}
			else {
				System.out.println("error!");
				response.sendRedirect("/Lab/admin/admin_teams/team.jsp");
			}
		}if(degree.equals("2")) {
			DOCed doced=new DOCed(id,name,sex,"","","","","","",status);
			int count=parUser.insertDOC(doced);
			if(count>0)
			{
				System.out.println("success!");
				response.sendRedirect("/Lab/admin/admin_teams/team.jsp");
			}
			else {
				System.out.println("error!");
				response.sendRedirect("/Lab/admin/admin_teams/team.jsp");
			}
		}
	}

}
