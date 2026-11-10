package com.spring.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.common.util.FormDataCollectUtil;
import com.spring.service.AdminService;
import com.spring.service.AppointmentService;
import com.spring.service.PaperService;
import com.spring.service.ScheduleService;
import com.spring.service.StudentService;
import com.spring.service.TeacherService;

import common.Logger;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired(required = true)
    private StudentService studentService;
    
    @Autowired(required = true)
    private TeacherService teacherService;
    
    @Autowired(required = true)
    private PaperService paperService;
    
    @Autowired(required = true)
    private AdminService adminService;
    
    @Autowired(required = true)
    private ScheduleService scheduleService;    

    @Autowired(required = true)
    private AppointmentService appointmentService;    
    
    @Autowired(required = true)
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");    
    
    private Logger log = Logger.getLogger(StudentService.class);

    /*
     * 学生主页面
     */
    
    @RequestMapping("smain")
    public String showStudent(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("sid",session.getAttribute("sid"));
        Map<String, Object> stu = studentService.showStudentById(param);//学生个人信息
        model.addAttribute("student", stu);
        return "student/smain";
    }

    /* 学生主页 */
    @RequestMapping("stu_main")
    public String showStudentInfo(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("sno", session.getAttribute("sno"));
        Map<String, Object> map = studentService.showStudentInfo(param);
        // 转型,把照片blob型转byte
        byte[] b = (byte[]) map.get("picture");
        if (b != null) {
            String picture = new String(b);
            //System.out.println(picture);
            map.put("picture", picture);
        }
        model.addAttribute("student", map);
        return "student/stu_main";
    }

    @RequestMapping("Info")
    public String showStudentInfoBytea(HttpServletRequest request, Model model) {
    	 Map<String, Object> param = FormDataCollectUtil.getInstance()
    	            .getFormData(request);
        Map<String, Object> map = studentService.showStudentInfo(param);
        // 转型,把照片blob型转byte
        byte[] b = (byte[]) map.get("picture");
        if (b != null) {
            String picture = new String(b);
            map.put("picture", picture);
        }
        model.addAttribute("student", map);
        return "student/infoByTea";
    }

    /* 学生双选页面 */
    @RequestMapping("stu_both_choices")
    public String getStudentBoth(HttpServletRequest request, Model model) {
    	HttpSession session = request.getSession();
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("sid", session.getAttribute("sid"));
        Map<String, Object> ts = adminService.showStudentAndTeacherOneById(param);//得到学生的最终导师选择结果
        Map<String, Object> time = adminService.showCtime(param);//得到当前时间信息
        Map<String, Object> selectRound = adminService.selectRound(param);//学生导师选择志愿
        List<Map<String, Object>> tea = teacherService.showTeacherAll(param);//所有教师信息
        Map<String, Object> student = studentService.showStudentById(param);
        boolean stop = false;
        Date SSTT = (Date)time.get("SSTT");//学生选择教师截止时间
        Date FRTS = (Date)time.get("FRTS");
        Date now = new Date();
        if(now.after(SSTT) && now.before(FRTS)) {
        	stop = false;
        }else {
        	stop = true;
        }
       	model.addAttribute("TS",ts);
        model.addAttribute("TEA",tea);
        model.addAttribute("student", student);
        model.addAttribute("Round", selectRound);
        model.addAttribute("stop",stop);
        return "student/stu_both_choices";
    }

    /*查询当前学生是否可以进入查看成绩界面
    @RequestMapping("/canGoToSGPage")
    public void canGoToSGPage(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("sid", session.getAttribute("sid"));
    	Map<String, Object> paper = paperService.showPaperTitleById(param);//论文题目选择信息
        Map<String, Object> files = paperService.showFiles(param);//论文相关文档信息
    	if(files != null && paper != null) {//论文题目确定后可以进入
	       request.getRequestDispatcher("stu_grade").forward(request, response);
    	}else {
    		response.setContentType("text/html;charset=utf-8");
			response.getWriter().print("0");
    	}
    }*/
    
    /* 学生成绩页面 */
    @RequestMapping("stu_grade")
    public String getStudentGrade(HttpServletRequest request, Model model) {
    	HttpSession session = request.getSession();
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("sid", session.getAttribute("sid"));
        Map<String, Object> student = studentService.showStudentById(param);//学生个人信息
        Map<String, Object> paper = paperService.showPaperTitleById(param);//论文题目选择信息
        Map<String, Object> files = paperService.showFiles(param);//论文相关文档信息
    	if(files == null || paper == null) {
    		 Map<String, Object> stu = studentService.showStudentById(param);//学生个人信息
    	     model.addAttribute("student", stu);
    	     return "student/smain";
    	}
        model.addAttribute("student", student);
        model.addAttribute("files", files);
        return "student/stu_grade";
    }
    
    /*查询当前学生是否可以进入论文选题界面
    @RequestMapping("canGoToSSTPage")
    public void canGoToSSTPage(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("sid", session.getAttribute("sid"));
    	Map<String, Object> ts = adminService.showStudentAndTeacherOneById(param);
    	if(ts == null) {
    		response.setContentType("text/html;charset=utf-8");
    		response.getWriter().print("0");
    	}else {
    		request.getRequestDispatcher("stu_select_topic").forward(request, response);
    	}
    }
    */
 
    /* 学生选题页面 */
    @RequestMapping("stu_select_topic")
    public String getStudentSetTopic(HttpServletRequest request, Model model) {
    	HttpSession session = request.getSession();
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("sid", session.getAttribute("sid"));
        Map<String, Object> ts = adminService.showStudentAndTeacherOneById(param);
        if(ts == null) {
			Map<String, Object> stu = studentService.showStudentById(param);//学生个人信息
			model.addAttribute("student", stu);
			return "student/smain";
        }
        param.put("tid",ts.get("tid"));
        List<Map<String,Object>> tea_paper_list = paperService.selectTeaReleasePaper(param);//查询该名学生的导师发布的所有论文信息
        if(tea_paper_list != null) {
	        for(int i=0;i<tea_paper_list.size();i++) {
	        	Map<String,Object> tMap = tea_paper_list.get(i);
	        	String sid = tMap.get("sid") == null ? null : tMap.get("sid").toString();
	        	if(sid != null && !sid.equals("-1") && !sid.equals("")) {
	        		Map<String,Object> item = new HashMap<String,Object>();
	        		item.put("sid", sid);
	        		Map<String,Object> sMap = studentService.showStudentById(item);
	        		tMap.putAll(sMap);
	        	}
	        }
        }
        //获取当前学生信息
        Map<String, Object> stu = studentService.showStudentById(param);//学生信息
        //检查当前学生是否选择题目了(返回论文和论文相关文档的信息)
        Map<String, Object> check = paperService.showPaperTitleById(stu);//学生的论文及相关文档所有信息
        stu.put("tid", param.get("tid"));//学生的导师信息加入
        model.addAttribute("Check", check);
        model.addAttribute("student", stu);
        model.addAttribute("tea_paper_list", tea_paper_list.size() == 0?null:tea_paper_list);
        return "student/stu_select_topic";
    }
    
    /* 学生修改题目页面 */
    @RequestMapping("stu_select_topic_detailed")
    public String stu_select_topic_detailed(HttpServletRequest request, Model model) {
        Map<String, Object> param = FormDataCollectUtil.getInstance()
                .getFormData(request);
        Map<String, Object> stu = paperService.showPaperTitleById(param);
        stu.put("sname", studentService.showStudentById(stu).get("sname"));
        model.addAttribute("papers", stu);
        return "student/stu_select_topic_detailed";
    }

    /* 学生修改题目方法 */
    @RequestMapping("updatePaperTitle")
    public void updatePaperTitle(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> param = FormDataCollectUtil.getInstance()
            .getFormData(request);
        try {
            String str = paperService.updatePaperTitle(param);
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(str);
        } catch (Exception e) {
            log.error(e);
        }
    }
    
    /* 学生修改已提交的题目方法 */
    @RequestMapping("updatePaperSubmit")
    public void updatePaperSubmit(HttpServletRequest request,HttpServletResponse response) {
        Map<String, Object> param = FormDataCollectUtil.getInstance()
                .getFormData(request);
        HttpSession session = request.getSession();
        param.put("sid", session.getAttribute("sid"));
        param.put("tid", adminService.showStudentAndTeacherOneById(param).get("tid"));
        try {
            String str = paperService.updatePaperSubmit(param);
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(str);
        } catch (Exception e) {
            log.error(e);
        }
    }
    
    /* 学生格式下载页面 */
    @RequestMapping("stu_template")
    public String getStudentTemplate(HttpServletRequest request, Model model) {
    	HttpSession session = request.getSession();
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("sno", session.getAttribute("sno"));
        model.addAttribute("student", studentService.showStudentInfo(param));
        model.addAttribute("files",paperService.showTemplate(param));
        return "student/stu_template";
    }
    
    /*查询当前学生是否可以进入文档管理界面
    @RequestMapping("canGoToSTMPage")
    public void canGoToSTMPage(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("sid", session.getAttribute("sid"));
    	Map<String, Object> paper = paperService.showPaperTitleById(param);//论文题目选择信息
        Map<String, Object> files = paperService.showFiles(param);//论文相关文档信息
    	String result = null;
    	if(files != null && paper != null) {//论文题目确定后可以进入
	        request.getRequestDispatcher("stu_thesis_manage").forward(request, response);
    	}else {
    		response.setContentType("text/html;charset=utf-8");
			response.getWriter().print("0");
    	}
    }
    */
    
    /* 学生文档管理页面 */
    @RequestMapping("stu_thesis_manage")
    public String getStudentThesis(HttpServletRequest request, Model model) {
    	HttpSession session = request.getSession();
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("sid", session.getAttribute("sid"));
        Map<String, Object> paper = paperService.showPaperTitleById(param);//论文题目选择信息
        Map<String, Object> files = paperService.showFiles(param);//论文相关文档信息
    	if(files == null || paper == null) {//论文题目确定后可以进入
    		Map<String, Object> stu = studentService.showStudentById(param);//学生个人信息
    	    model.addAttribute("student", stu);
    		return "student/smain";
    	}
        model.addAttribute("student", studentService.showStudentById(param));
        model.addAttribute("files", files);
        return "student/stu_thesis_manage";
    }

    /* 学生信息修改页面 */
    @RequestMapping("stu_edit")
    public String studentEdit(HttpServletRequest request, Model model) {
    	HttpSession session = request.getSession();
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("sno", session.getAttribute("sno"));
        Map<String, Object> map = studentService.showStudentInfo(param);
            // 转型,把照片blob型转byte
            byte[] b = (byte[]) map.get("picture");
            if (b != null) {
                String picture = new String(b);
               // System.out.println(picture);
                map.put("picture", picture);
            }
            model.addAttribute("student", map);
        return "student/stu_edit";
    }
    
    /*学生预约教师界面*/
    @RequestMapping("stu_reserve")
    public String stuReserve(HttpServletRequest request, Model model) {
		 Map<String, Object> param = FormDataCollectUtil.getInstance()
		            .getFormData(request);
		 HttpSession session = request.getSession();
		 Map<String,Object> paramMap = new HashMap<String,Object>();
		 paramMap.put("sid", session.getAttribute("sid"));
		 Map<String, Object> ts = adminService.showStudentAndTeacherOneById(paramMap);
		 int week = 0;
		 if(ts == null) {
			 Map<String, Object> stu = studentService.showStudentById(paramMap);//学生个人信息
			 model.addAttribute("student", stu);
			 return "student/smain";
		 }
		 String now = sdf.format(new Date());
		 paramMap.put("date", now);
		 if(param.get("week") != null) {
			 week = Integer.parseInt((String)param.get("week"));
			
		 }else {
			 week = scheduleService.selectWeekByDate(paramMap);//得到当前周数	
			// System.out.println(week);
		 }
		 paramMap.put("week", week);
     	 paramMap.put("tid", ts.get("tid"));
     	 List<Map<String, Object>> schedule = scheduleService.selectWeekInfoByTid(paramMap);//得到教师当前周的所有日程信息
     	 for(int i=0;i<schedule.size();i++) {
     		Map<String, Object> _map = schedule.get(i);
     		if((Integer)_map.get("affairType") == 2) {
     			if(_map.get("affairContent").equals(session.getAttribute("sid").toString())) {
     				_map.put("affairContent", "与您的预约");     				
     			}else {
     				_map.put("affairContent", "与他人的预约");
     			}
     		}
     	 }
     	 Map<String, Object> stu = studentService.showStudentById(paramMap);
     	 List<String> date = scheduleService.selectWeekInfo(paramMap);
     	 for(int i=0;i<date.size();i++) {
     		 switch(i) {
	     		 case 0:model.addAttribute("Monday", date.get(i));break;
	     		 case 1:model.addAttribute("Tuesday", date.get(i));break;
	     		 case 2:model.addAttribute("Wednesday", date.get(i));break;
	     		 case 3:model.addAttribute("Thursday", date.get(i));break;
	     		 case 4:model.addAttribute("Friday", date.get(i));break;
	     		 case 5:model.addAttribute("Saturday", date.get(i));break;
	     		 case 6:model.addAttribute("Sunday", date.get(i));break;
     		 }
     	 }
     	 List<Map<String, Object>> appointment = appointmentService.selectAppointmentBySid(paramMap);
     	 if(appointment.size() == 0) {
     		 appointment = null;
     	 }else {
	     	 for(int i=0;i<appointment.size();i++) {
	     		 Map<String,Object> map = new HashMap<String,Object>();
	     		 Map<String, Object> app = appointment.get(i);
	     		 map.put("tid", app.get("tid"));
	     		 app.put("tname", teacherService.showTeacherInfoById(map).get("tname"));
	     		 app.put("sclass", sclassTransform((Integer)app.get("sclass")));
	     		 app.put("day", dayTransform((Integer)app.get("day")));
	     	 }
     	 }
     	 //System.out.println(schedule.size());
     	 model.addAttribute("student", stu);
     	 model.addAttribute("schedule", schedule);
     	 model.addAttribute("week",week);
     	 model.addAttribute("appointment", appointment);//预约信息
     	 return "student/stu_reserve";
    }
    
    /*星期转换*/
    public String dayTransform(int i) {
    	switch(i) {
	    	case 1:return "一";
	    	case 2:return "二";
	    	case 3:return "三";
	    	case 4:return "四";
	    	case 5:return "五";
	    	case 6:return "六";
	    	case 7:return "天";
	    	default: return "";
    	}
    }
    
    /*课程转换*/
    public String sclassTransform(int i) {
    	switch(i) {
	    	case 1:return "1-2";
	    	case 2:return "3-4";
	    	case 3:return "5-6";
	    	case 4:return "7-8";
	    	case 5:return "9-10";
	    	case 6:return "11-12";
	    	default: return "";
    	}
    }
    
    /*学生进行预约*/
    @RequestMapping("stu_set_reserve")
    public void stu_set_reserve(HttpServletRequest request,
        HttpServletResponse response) throws ParseException {
    	HttpSession session = request.getSession();
    	Map<String, Object> param = FormDataCollectUtil.getInstance()
                .getFormData(request);
    	int result = 0;
    	Date date = sdf.parse((String)param.get("date"));
    	if(!date.before(new Date())) {
	    	Object sid = session.getAttribute("sid");
	    	param.put("sid", sid);
	    	Map<String, Object> ts = adminService.showStudentAndTeacherOneById(param);
	    	Object tid = ts.get("tid");
	    	if(tid != null) {    		
	    		param.put("tid", tid);
	    		param.put("date", sdf.parse((String)param.get("date")));
	    		param.put("now", sdf.format(new Date()));
	    		if(appointmentService.selectNumByTidAndSid(param) != 0) {
	    			result = -1;//提交了有效预约请求
	    		}else if(scheduleService.selectNumByTidAndSid(param) != 0) {
	    			result = -2;//和导师已有有效预约
	    		}else {
	    			result = appointmentService.addAppointment(param);//合法预约请求
	    		}
	    	}
    	}
    	 response.setContentType("text/html;charset=utf-8");
         try {
			response.getWriter().print(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    /*学生取消预约*/
    @RequestMapping("stu_rmv_reserve")
    public void stu_rmv_reserve(HttpServletRequest request,
        HttpServletResponse response) {
    	
    	HttpSession session = request.getSession();
    	Map<String, Object> param = FormDataCollectUtil.getInstance()
                .getFormData(request);
    	int result = 0;
    	String sid = (String)session.getAttribute("sid");
    	param.put("sid", sid);
    	if(appointmentService.isExistARecord(param) == 1) {
    		appointmentService.deleteAppointment(param);
    		result = 1;//取消成功
    	}
    	 response.setContentType("text/html;charset=utf-8");
         try {
			response.getWriter().print(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    /* 更新学生方法 */
    @RequestMapping("updateStudent")
    public void updateStudent(HttpServletRequest request,
        HttpServletResponse response) {
        Map<String, Object> param = FormDataCollectUtil.getInstance()
            .getFormData(request);
        HttpSession session = request.getSession();
        param.put("sno", session.getAttribute("sno"));
        Boolean xb;
        if ("1".equals(param.get("xb"))) {
            xb = new Boolean(true);
        } else {
            xb = new Boolean(false);
        }
        /*String MD5message = MD5Tool.getMessageDigest((String)param.get("password"));
        param.remove("password");
        param.put("password", MD5message);
        System.out.println(xb);*/
        param.put("xb", xb);
        try {
            String str = studentService.updateStudentByStu(param);
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(str);
        } catch (Exception e) {
            log.error(e);
        }
    }

    /*  更新round */
    @Transactional
    @RequestMapping("updateRound")
    public void updateRound(HttpServletRequest request,HttpServletResponse response) {
        Map<String, Object> param = FormDataCollectUtil.getInstance().getFormData(request);
        HttpSession session = request.getSession();
        param.put("sid", session.getAttribute("sid"));
        try {
            String str = adminService.updateRound(param);
            System.out.println(str);
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(str);
        } catch (Exception e) {
            log.error(e);
        }
    }
    
    @Transactional
    @RequestMapping("insertRound")
    public void insertRound(HttpServletRequest request,HttpServletResponse response) {
        Map<String, Object> param = FormDataCollectUtil.getInstance().getFormData(request);
        HttpSession session = request.getSession();
        param.put("sid", session.getAttribute("sid"));
        try {
            String str = adminService.insertRound(param);
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(str);
        } catch (Exception e) {
            log.error(e);
        }
    }
    
    /* 学生自拟题目并提交 */
    @RequestMapping("addPaperTitleByStu")
    public void addPaperTitleAndSid(HttpServletRequest request,
        HttpServletResponse response) {
        Map<String, Object> param = FormDataCollectUtil.getInstance()
                .getFormData(request);
        HttpSession session = request.getSession();
        param.put("sid", session.getAttribute("sid"));
        param.put("tid", adminService.showStudentAndTeacherOneById(param).get("tid"));
        try {
            String str = paperService.addPaperTitleByStu(param);
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(str);
        } catch (Exception e) {
            log.error(e);
        }
    }
    
    /* 新增论文Title和sid方法 
    @RequestMapping("addPaperTitleAndSid")
    public void addPaperTitleAndSid(HttpServletRequest request,
    		HttpServletResponse response) {
    	Map<String, Object> param = FormDataCollectUtil.getInstance()
    			.getFormData(request);
    	param.put("state", 0);
    	param.put("submit", 0);
    	param.put("isTeaRelease", 0);
    	try {
    		String str = paperService.addPaperTitleAndSid(param);
    		response.setContentType("text/html;charset=utf-8");
    		response.getWriter().print(str);
    	} catch (Exception e) {
    		log.error(e);
    	}
    }*/

    /* 学生选题，修改Title中Sid方法 */
    @RequestMapping("submitPaperByTeaRelease")
    public void updateStudentAndTitle(HttpServletRequest request,
        HttpServletResponse response) {
        Map<String, Object> param = FormDataCollectUtil.getInstance()
            .getFormData(request);
        HttpSession session = request.getSession();
        param.put("sid", session.getAttribute("sid"));
        String result = paperService.submitPaperByTeaRelease(param);
        try {
        	response.setContentType("text/html;charset=utf-8");
			response.getWriter().print(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    /* 学生删除自拟题目 */
    @RequestMapping("deletePaperByStu")
    public void deletePaperByStu(HttpServletRequest request,
        HttpServletResponse response) {
        Map<String, Object> param = FormDataCollectUtil.getInstance()
            .getFormData(request);
        HttpSession session = request.getSession();
    	param.put("sid",session.getAttribute("sid"));
        try {
            String str = paperService.deletePaperByStu(param);
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(str);
        } catch (Exception e) {
            log.error(e);
        }

    }
    /* 学生撤销选择导师发布的论文题目 */
    @RequestMapping("deletePaperByTea")
    public void deletePaperByTea(HttpServletRequest request,
    		HttpServletResponse response) {
    	Map<String, Object> param = FormDataCollectUtil.getInstance()
    			.getFormData(request);
    	HttpSession session = request.getSession();
    	param.put("sid",session.getAttribute("sid"));
    	try {
    		String str = paperService.deletePaperByTea(param);
    		response.setContentType("text/html;charset=utf-8");
    		response.getWriter().print(str);
    	} catch (Exception e) {
    		log.error(e);
    	}
    	
    }
    /* 删除sid */
    @RequestMapping("deleteSid")
    public void deleteSid(HttpServletRequest request,
        HttpServletResponse response) {
        Map<String, Object> param = FormDataCollectUtil.getInstance()
                .getFormData(request);
        try {
            String str = paperService.deleteSid(param);
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(str);
        } catch (Exception e) {
            log.error(e);
        }
        
    }
    
    // 上传学生文档
    @RequestMapping("/OneUpload")
    public void oneUpload(@RequestParam("imagefile") MultipartFile imageFile,
        HttpServletRequest request,HttpServletResponse response) {
        // 得到上传文件的保存目录，将上传的文件存放于WEB-INF目录下，不允许外界直接访问，保证上传文件的安全
        String uploadUrl = request.getSession().getServletContext()
            .getRealPath("/WEB-INF/upload");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
        String filename = imageFile.getOriginalFilename();
        String fileType;
        if(filename.lastIndexOf(".") != -1) {        	
        	fileType = filename.substring(filename.lastIndexOf("."));
        }else {
        	fileType = ".doc";
        }
        //log.info(df.format(new Date()));// new Date()为获取当前系统时间
        String temp = df.format(new Date());
        // 获取当前学生信息用来传sno
        Map<String, Object> param = FormDataCollectUtil.getInstance()
            .getFormData(request);
        Map<String, Object> map = studentService.showStudentById(param);//根据学生id查询学号等信息
        String sid = param.get("sid").toString();
        String type = param.get("type").toString();
        String sno = map.get("sno").toString();
        Map<String, Object> updatefile = paperService.showFiles(param);//查询该名学生论文文档记录
        File dir = new File(uploadUrl + File.separator + sno);//每名学生的用来存储文档的目录
        System.out.println("是否存在目录？"+dir.exists());
        if(!dir.exists()) {
        	dir.mkdirs();
        }
        /*boolean flag = false;
        if (updatefile == null) {//不存在文档的记录，需要进行添加
            updatefile = new HashMap<>();
            updatefile.put("sid", sid);
            flag = true;
            dir.mkdirs();// 创建目录
        }*/
        // 判断传入什么类型文档，并将文件名传入一个map中
        int i = Integer.parseInt(type);
        String newFileName = null;
        switch(i) {
        case 1:
            System.out.println(1);
            newFileName = sno + "-开题报告" + fileType;
            updatefile.put("OpeningReport",newFileName);
            updatefile.put("Otime", temp);
            updatefile.put("OSnum",(int)updatefile.get("OSnum")+1);
            break;
        case 2:
            System.out.println(2);
            newFileName = sno + "-外文翻译" + fileType;
            updatefile.put("ForeignLanguageTranslation",newFileName);
            updatefile.put("Ftime", temp);
            updatefile.put("FSnum",(int)updatefile.get("FSnum")+1);
            break;
        case 3:
            System.out.println(3);
            newFileName = sno + "-论文" + fileType;
            updatefile.put("Paper",newFileName);
            updatefile.put("Ptime", temp);
            updatefile.put("PSnum",(int)updatefile.get("PSnum")+1);
            break;
        case 4:
            System.out.println(4);
            newFileName = sno + "-论证书" + fileType;
            updatefile.put("ArgumentBook",newFileName);
            updatefile.put("Atime", temp);
            updatefile.put("ASnum",(int)updatefile.get("ASnum")+1);
            break;
        case 5:
            System.out.println(5);
            newFileName = sno + "-指导手册" + fileType;
            updatefile.put("InstructionManual",newFileName);
            updatefile.put("Itime", temp);
            updatefile.put("ISnum",(int)updatefile.get("ISnum")+1);
            break;
        case 6:
            System.out.println(6);
            newFileName = sno + "-指导意见" + fileType;
            updatefile.put("GuidingOpinions",newFileName);
            updatefile.put("Gtime", temp);
            updatefile.put("GSnum",(int)updatefile.get("GSnum")+1);
            break;
        default:
            System.out.println(0);
        }
        
        /*//判断是否超出时间
        int result ;
        result = adminService.checkCtime(param);
        if(result == 0){
            System.out.println("超出时间");
            return "teacher/tmain";
       }else{*/
       //System.out.println("2");
        paperService.updateFiles(updatefile);// 储存并更新数据库
        System.out.println("更新文件上传到: " + uploadUrl + File.separator+ sno
            + File.separator + newFileName);
        File targetFile = new File(uploadUrl + File.separator + sno
           + File.separator + newFileName);
        if (!targetFile.exists()) {
            try {
                targetFile.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        try {
            imageFile.transferTo(targetFile);
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print("uploadSuccess");
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // 下载学生文档
    @RequestMapping("/OpenDownload")
    public void download(HttpServletRequest request,HttpServletResponse response) {
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        java.io.BufferedInputStream bis = null;

        // 获取sno
        Map<String, Object> param = FormDataCollectUtil.getInstance()
            .getFormData(request);
        Map<String, Object> map = studentService.showStudentById(param);
        String sid = map.get("sid").toString();
        String type = param.get("type").toString();
        String sno = map.get("sno").toString();
        param.put("sid", sid);
        // 查询对应sno的文档
        Map<String, Object> files = paperService.showFiles(param);
        // 根据类型判断要下载什么文档
        int i = Integer.parseInt(type);
        String filename = null;
        switch (i) {
        case 1:
            System.out.println(1);
            filename = files.get("OpeningReport").toString();
            break;
        case 2:
            System.out.println(2);
            filename = files.get("ForeignLanguageTranslation").toString();
            break;
        case 3:
            System.out.println(3);
            filename = files.get("Paper").toString();
            break;
        case 4:
            System.out.println(4);
            filename = files.get("ArgumentBook").toString();
            break;
        case 5:
            System.out.println(5);
            filename = files.get("InstructionManual").toString();
            break;
        case 6:
            System.out.println(6);
            filename = files.get("GuidingOpinions").toString();
            break;
        case 7:
        	System.out.println(7);
        	filename = files.get("tOpeningReport").toString();
        	break;
        case 8:
        	System.out.println(8);
        	filename = files.get("tForeignLanguageTranslation").toString();
        	break;
        case 9:
        	System.out.println(9);
            filename = files.get("tPaper").toString();
            break;
        case 10:
            System.out.println(10);
            filename = files.get("tArgumentBook").toString();
            break;
        default:
            System.out.println(0);
        }

        String filePath = request.getSession().getServletContext()
            .getRealPath("/WEB-INF/upload/");
        String downLoadPath = filePath + File.separator + sno + File.separator
            + filename;
        //System.out.println(downLoadPath);
        try {
            long fileLength = new File(downLoadPath).length();
            response.reset();
            response.setHeader("Content-Disposition", "attachment; filename="
                +URLEncoder.encode(filename, "UTF-8"));
            response.addHeader("Content-Length", "" + fileLength);
            response.setContentType("application/octet-stream;charset=UTF-8");
            bis = new BufferedInputStream(new FileInputStream(downLoadPath));
            OutputStream os = response.getOutputStream();
            byte[] buff = new byte[1048576];
            int bytesRead;
            while ((bytesRead = bis.read(buff)) > 0) {
                os.write(buff, 0, bytesRead);
            }
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bis != null)
                    bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    // 下载模板
    @RequestMapping("/templateDownload")
    public void tdownload( HttpServletRequest request,HttpServletResponse response) {
        
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        java.io.BufferedInputStream bis = null;
        
        Map<String, Object> param = FormDataCollectUtil.getInstance()
                .getFormData(request);
        String type = param.get("type").toString();
        // 查询模板 
        Map<String, Object> files = paperService.showTemplate(param);
        // 根据类型判断要下载什么文档
        int i = Integer.parseInt(type);
        String filename = null;
        switch (i) {
        case 1:
            System.out.println(1);
            filename = files.get("GraduationDesignManual").toString();
            break;
        case 2:
            System.out.println(2);
            filename = files.get("ScoreTable").toString();
            break;
        case 3:
            System.out.println(3);
            filename = files.get("ReplyRecord").toString();
            break;
        case 4:
            System.out.println(4);
            filename = files.get("OpeningReportTemplate").toString();
            break;
        case 5:
            System.out.println(5);
            filename = files.get("Other").toString();
            break;
        default:
            System.out.println(0);
        }
        
        String filePath = request.getSession().getServletContext()
                .getRealPath("/WEB-INF/template/");
        String downLoadPath = filePath +  File.separator+ filename;
        System.out.println(downLoadPath);
        try {
            long fileLength = new File(downLoadPath).length();
            response.reset();
            response.setHeader("Content-Disposition", "attachment; filename="
                + URLEncoder.encode(filename, "UTF-8"));
            response.addHeader("Content-Length", "" + fileLength);
            response.setContentType("application/octet-stream;charset=UTF-8");
            bis = new BufferedInputStream(new FileInputStream(downLoadPath));
            OutputStream os = response.getOutputStream();
            byte[] buff = new byte[1048576];
            int bytesRead;
            while ((bytesRead = bis.read(buff)) > 0) {
                os.write(buff, 0, bytesRead);
            }
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bis != null)
                    bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
    }

}
