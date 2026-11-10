package com.controller;
 
//import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
 
@WebServlet(name = "/findUserServlet" ,urlPatterns="/findUserServlet")
public class FindUserServlet extends HttpServlet
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
 
        //"userExist": true, "msg": "此用户名太受欢迎，请换一个"
        //"userExist": false, "msg": "此用户可用"
        Map<String , Object> map = new HashMap<String , Object>();
        if("tom".equals(username))
        {
            map.put("userExist",true);
            map.put("msg","此用户名太受欢迎，请换一个");
        }
        else
        {
            map.put("userExist",false);
            map.put("msg","此用户可用");
        }
 
        ObjectMapper mapper = new ObjectMapper();
 
        String string = mapper.writeValueAsString(map);
        response.getWriter().write(string);
 
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost( request,  response);
    }
}