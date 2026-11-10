package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.News;
import SERVICE.parUser;

/**
 * Servlet implementation class getAchievements
 */
@WebServlet("/getAchievements")
public class getAchievements extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getAchievements() {
        super();
        // TODO Auto-generated constructor stub
    }

    public static ArrayList<News> listOrder(ArrayList<News> list){
		ArrayList<News> list1 = new ArrayList<>();
    if (list.size() > 1){
        for (int i = list.size()-1;i >= 0; i--){
            list1.add(list.get(i));
        }
    }else {
        list1 = list;
    }
    return list1;
}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<News> list=parUser.selectAchievements();
		ArrayList<News> listD = listOrder(list);
		
		//放到请求对象中
		System.out.println(listD);
		request.setAttribute("Achievements", listD);
		request.getRequestDispatcher("/labs/achievements/achievement.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
