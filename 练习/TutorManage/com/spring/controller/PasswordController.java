package com.spring.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.util.FormDataCollectUtil;
import com.spring.service.LoginService;
import com.spring.service.PasswordService;

@Controller
@RequestMapping("/Password")
public class PasswordController {

	@Autowired(required = true)
	private PasswordService passwordservice;
	
	@Autowired(required = true)
	private LoginService loginservice;
	
	@RequestMapping("tea_passwordUpdateDisptcher")
	public String tea_passwordUpdateDisptcher(HttpServletRequest request,
            HttpServletResponse response,Model model){
	    	 Map<String, Object> param = FormDataCollectUtil.getInstance()
	    	            .getFormData(request);
	    	 model.addAttribute("type",param.get("type"));
	    	 model.addAttribute("no",request.getSession().getAttribute("tno"));
	    	 return "Password/passwordUpdate";
	}
	@RequestMapping("stu_passwordUpdateDisptcher")
	public String stu_passwordUpdateDisptcher(HttpServletRequest request,
            HttpServletResponse response,Model model){
	    	 Map<String, Object> param = FormDataCollectUtil.getInstance()
	    	            .getFormData(request);
	    	 model.addAttribute("type",param.get("type"));
	    	 model.addAttribute("no",request.getSession().getAttribute("sno"));
	    	 return "Password/passwordUpdate";
	}
	
	@RequestMapping("updatePassword")
	public void updatePassword(HttpServletRequest request,
            HttpServletResponse response,Model model){
		 Map<String, Object> param = FormDataCollectUtil.getInstance()
 	            .getFormData(request);
		 String type = (String)param.get("type");
		 if(type.equals("student")){
			 updateStudentPassword(request,response,model);
		 }else if(type.equals("teacher")){
			 updateTeacherPassword(request,response,model);
		 }
	}
	public void updateTeacherPassword(HttpServletRequest request,
            HttpServletResponse response,Model model){
	    	 Map<String, Object> param = FormDataCollectUtil.getInstance()
	    	            .getFormData(request);
	    	String oldpassword = (String)param.get("oldpassword");
	    	String tno = (String)request.getSession().getAttribute("tno");
	    	String newpassword = (String)param.get("newpassword");
	    	Map<String,Object> onp = new HashMap<String,Object>();
	    	Map<String,Object> nnp = new HashMap<String,Object>();
	    	onp.put("username", tno);
	    	nnp.put("tno", tno);
	    	onp.put("password", oldpassword);
	    	nnp.put("password", newpassword);
	    	if(loginservice.checkTeacher(onp)!=1){
	    		response.setContentType("text/html;charset=utf-8");
	            try {
					response.getWriter().print("0");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}else{
	    		passwordservice.updateTeacherPasseord(nnp);
	    		response.setContentType("text/html;charset=utf-8");
	            try {
					response.getWriter().print("1");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	}
	
	public void updateStudentPassword(HttpServletRequest request,
            HttpServletResponse response,Model model){
	    	 Map<String, Object> param = FormDataCollectUtil.getInstance()
	    	            .getFormData(request);
	    	String oldpassword = (String)param.get("oldpassword");
	    	String sno = (String)request.getSession().getAttribute("sno");
	    	String newpassword = (String)param.get("newpassword");
	    	Map<String,Object> onp = new HashMap<String,Object>();
	    	Map<String,Object> nnp = new HashMap<String,Object>();
	    	onp.put("username", sno);
	    	nnp.put("sno", sno);
	    	onp.put("password", oldpassword);
	    	nnp.put("password", newpassword);
	    	if(loginservice.checkStudent(onp)!=1){
	    		response.setContentType("text/html;charset=utf-8");
	            try {
					response.getWriter().print("0");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}else{
	    		passwordservice.updateStudentPassword(nnp);
	    		response.setContentType("text/html;charset=utf-8");
	            try {
					response.getWriter().print("1");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	}
}
