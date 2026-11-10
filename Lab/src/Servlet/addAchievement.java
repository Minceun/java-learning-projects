package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.News;
import SERVICE.parUser;

/**
 * Servlet implementation class addAchievement
 */
@WebServlet("/addAchievement")
public class addAchievement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addAchievement() {
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
		
		String title=request.getParameter("title");
		String date=request.getParameter("date");
		String detail=request.getParameter("detail");
		News news=new News(title,detail,date);
		System.out.println(news.getNewTitle()+","+news.getNewTime()+","+news.getNewText());

		//加入到数据库的用户表中
		int count=parUser.insertAchievement(news);
		System.out.println("count = "+count);
		//成功或者失败的重定向
		if(count>0)
		{
			System.out.println("success!");
			response.sendRedirect("/Lab/admin/admin_achievements/achievement.jsp");
		}
		else {
			System.out.println("error!");
			response.sendRedirect("/Lab/admin/admin_achievements/achievement.jsp");
		}
	}

}
