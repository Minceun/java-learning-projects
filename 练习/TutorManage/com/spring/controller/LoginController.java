package com.spring.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.util.FormDataCollectUtil;
import com.spring.service.AdminService;
import com.spring.service.LoginService;
import com.spring.service.StudentService;
import com.spring.service.TeacherService;

import common.Logger;

@Controller
@RequestMapping("/Login")
public class LoginController {
	
    @Autowired(required = true)
    private StudentService StudentService; 
    
    @Autowired(required = true)
   	private TeacherService TeacherService; 
    
    @Autowired(required = true)
    private AdminService adminService; 
	  
    @Autowired(required = true)
    private LoginService loginService;//定义LoginService类型的对象

    private Logger log = Logger.getLogger(LoginService.class);

    // 用户校验登录
    @RequestMapping("checkUser")//用户校验登录
    public void login_check(HttpServletRequest request,
        HttpServletResponse response) {
    	
    	//将jsp文件传来的数据(用户类型、用户名和密码)转换为Map类型(键-值对)，
    	//键分别为"type"、"userno"、"password"，每个键对应的值分别为在前端输入的值
        Map<String, Object> map = FormDataCollectUtil.getInstance()
            .getFormData(request);  
        int result;
        //将map中的类型值取出
        String type = map.get("type") == null ? null : map.get("type")
            .toString();
        String username = map.get("username") == null ? null : map.get("username")
                .toString();
        try {
            if ("teacher".equals(type)) {
            	//类型和"teacher"相比，如果相同，则执行LoginService中的checkTeacher(map)方法，检查老师，正确返回返回1，错误返回0，下同
                result = loginService.checkTeacher(map);
                if(result == 1) {
                	map.put("tno", map.get("username"));
                	Map<String, Object> session = TeacherService.showTeacherInfo(map);
                	request.getSession().setAttribute("login", "teacher");
                	request.getSession().setAttribute("tid", session.get("tid"));
                	request.getSession().setAttribute("tno", session.get("tno"));
                }
            } else if ("student".equals(type)) {
            	result = loginService.checkStudent(map);
            	 if(result == 1) {
                 	map.put("sno", map.get("username"));
                 	Map<String, Object> session = StudentService.showStudentInfo(map);
                 	request.getSession().setAttribute("login", "student");
                 	request.getSession().setAttribute("sid", session.get("sid"));
                	request.getSession().setAttribute("sno", session.get("sno"));
                 }
            }else{
                result = loginService.checkAdmin(map);
                if(result == 1) {
                	map.put("adminno", map.get("username"));
                	Map<String, Object> session = adminService.showAdminInfo(map);
                	request.getSession().setAttribute("login", "admin");
                	request.getSession().setAttribute("adminid", session.get("adminid"));
                	request.getSession().setAttribute("adminno", session.get("adminno"));
                }
            }
            //向前端返回result参数
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(result);
        } catch (Exception e) {
            log.error(e);
        }
    }
    //用户登录页面
    @RequestMapping("login")
    public String setLogin(HttpServletResponse request,
        HttpServletResponse response) {
        return "Login/login";
    }

   

}
