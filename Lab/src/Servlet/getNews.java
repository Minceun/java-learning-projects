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
 * Servlet implementation class getNews
 */
@WebServlet("/getNews")
public class getNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getNews() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<News> list=parUser.selectNews();
		ArrayList<News> listD = listOrder(list);
		//放到请求对象中
		System.out.println(listD);
		request.setAttribute("News", listD);
		request.getRequestDispatcher("/labs/news/new.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
