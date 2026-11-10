package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Entity.admin;
import SERVICE.parUser;

/**
 * Servlet implementation class manager_login
 */
@WebServlet("/login")
public class manager_login extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset-utf-8");
		//设置字符集
		String userNum=request.getParameter("admin_num");
		String userPassword=request.getParameter("admin_password");
		admin user=new admin(userNum,userPassword);
		int count=0;
		count=parUser.selectPsw1(userNum,userPassword);
		System.out.println("count = "+count);
		//显示status是1的用户的信息，放到一个ArrayList里面
		ArrayList<admin> admin_list=parUser.selectHigher1(1);
		//
		HttpSession session=request.getSession();
		for(int i=0;i<admin_list.size();i++)
		{
			String numString=admin_list.get(i).getAdmin_num();
			if(numString.equals(userNum))
			{
				System.out.println("相等");
				System.out.println("numString = "+numString);
				System.out.println("userNum = "+userNum);
				session.setAttribute("isHigher", "1");
				System.out.println("权限设置为1");
				break;
				//session里面isHigher是1的时候才可以高级增删改
			}
			else {
				System.out.println("权限设置为0");
				session.setAttribute("isHigher", "0");
			}
		}
		if(count>0)
		{
			//成功
			//成功--写入session
			admin ad=parUser.selectAdmin1(userNum,userPassword);
			//只有放置到session里面，才能可以被访问
			session.setAttribute("name", ad);
			System.out.println("登录设置为1");
			session.setAttribute("isLogin", "1");
			//是否登录
			response.sendRedirect("/Lab/admin_select");
		}
		else {
			//失败
			response.sendRedirect("/Lab/login.jsp");
		}
	}

}
