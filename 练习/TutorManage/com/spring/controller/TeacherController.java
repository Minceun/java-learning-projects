package com.spring.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired(required = true)
    private TeacherService teacherService;

    @Autowired(required = true)
    private StudentService studentService;

    @Autowired(required = true)
    private PaperService paperService;

    @Autowired(required = true)
    private AdminService adminService;
    
    @Autowired(required = true)
    private ScheduleService scheduleService;
    
    @Autowired(required = true)
    private AppointmentService appointmentService;
    
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
    public static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private Logger log = Logger.getLogger(TeacherService.class);

    //文档管理详细页面 
    @RequestMapping("tea_topics_detailed")
    public String showTea_detailed(HttpServletRequest request, Model model) {
        Map<String, Object> param = FormDataCollectUtil.getInstance()
            .getFormData(request);
        Map<String, Object> sMap = studentService.showStudentInfo(param);
        model.addAttribute("student", sMap);
        param.put("sid", sMap.get("sid"));
        model.addAttribute("files", paperService.showFiles(param));
        return "teacher/tea_topics_detailed";
    }

    //评定小组详细页面  <暂时注释>
    /*@RequestMapping("teachergroup_detailed")
    public String showTeachergroup_detailed(HttpServletRequest request,
        Model model) {
        Map<String, Object> param = FormDataCollectUtil.getInstance()
            .getFormData(request);
        model.addAttribute("student", studentService.showStudentInfo(param));
        model.addAttribute("files", paperService.showFiles(param));
        return "teacher/teachergroup_detailed";
    }*/

    //左边导航栏页面
    @RequestMapping("tmain")
    public String showTeacher(HttpServletRequest request, Model model) {
    	HttpSession session = request.getSession();
    	Map<String, Object> param = new HashMap<String,Object>();
    	param.put("tno", session.getAttribute("tno"));
        model.addAttribute("teacher", teacherService.showTeacherInfo(param));
        return "teacher/tmain";
    }

    // 教师主页 
    @RequestMapping("tea_main")
    public String showTeacherMain(HttpServletRequest request, Model model) {
    	HttpSession session = request.getSession();
    	Map<String, Object> param = new HashMap<String,Object>();
		param.put("tno",session.getAttribute("tno"));
        Map<String, Object> map = teacherService.showTeacherInfo(param);
        // 转换图片格式
        byte[] b = (byte[]) map.get("picture");
        if (b != null) {
            String picture = new String(b);
            map.put("picture", picture);
        }
        model.addAttribute("teacher", map);
        return "teacher/tea_main";
    }
    
    //学生请求教师信息页面
    @RequestMapping("tea_infoByStu")
    public String tea_infoByStu(HttpServletRequest request, Model model) {
        Map<String, Object> param = FormDataCollectUtil.getInstance()
            .getFormData(request);
        Map<String, Object> map = teacherService.showTeacherInfo(param);
        // 转换图片格式
        byte[] b = (byte[]) map.get("picture");
        if (b != null) {
            String picture = new String(b);
            // System.out.println(picture);
            map.put("picture", picture);
        }
        model.addAttribute("teacher", map);
        return "teacher/tea_infoByStu";
    }

    //联系我们页面 <暂时注释>
    /*@RequestMapping("tea_contract")
    public String getStudentContract(HttpServletRequest request, Model model) {
        Map<String, Object> param = FormDataCollectUtil.getInstance()
            .getFormData(request);
        model.addAttribute("teacher", teacherService.showTeacherInfo(param));
        return "teacher/tea_contract";
    }*/

    //双选页面 
    @RequestMapping("tea_both_choices")
    public String getTeacherBoth(HttpServletRequest request,Model model) throws IOException, ParseException {
    	HttpSession session = request.getSession();
    	Map<String, Object> param = new HashMap<String,Object>();
        Map<String, Object> round = new HashMap<>();
        round.put("ROUND1", session.getAttribute("tid"));//获得教师的tid
        /*根据教师tid获得当前教师可以反选的学生名单(可以选择的,不包括已经被选择的学生名单)*/
        /*计算roundnumber*/
        int rn = this.calRoundNumber(new Date());
        if(rn <= 0 || rn >= 5) {
        	param.put("tno", session.getAttribute("tno"));
            model.addAttribute("teacher", teacherService.showTeacherInfo(param));
            return "teacher/tmain";
        }
        round.put("rn", rn);
//        double GPA = teacherService.getGPAStandard();
        round.put("grade", AdminController.getYear());
        System.out.println(round.get("grade"));
        List<Map<String, Object>> Round = adminService.selectRoundByTeacher(round);//获得所有可以被选择的学生的信息（一条selectRound表的记录）
        // 遍历list，获取对应学生信息，加入list中
        for (int i = 0; i < Round.size(); i++) {
            Map<String, Object> sMap = Round.get(i);
            String s = sMap.get("sid") == null ? null : sMap.get("sid")
                .toString();
            if (s != null && !s.equals("")) {
            	int star = 0;// star == 0 GPA未排在后22名 star == 1 GPA排在后22名
                Map<String, Object> item = new HashMap<String, Object>();
                item.put("sid", s);//得到学生学号
                Map<String, Object> pMap = studentService.showStudentById(item);//通过学生学号得到学生全部信息
//                if(Double.parseDouble(pMap.get("GPA").toString()) <= GPA) {
                if(pMap.get("lowGPA")!=null) {
                	pMap.put("sname", "*"+pMap.get("sname"));
                }
            	pMap.put("gpa",pMap.get("GPA").toString());
                sMap.putAll(pMap);  
            }
        }
        Map<String, Object> time = adminService.showCtime(param);
        Date now = new Date();
        Date SSTT = (Date)time.get("SSTT");
        Date TSST = (Date)time.get("TSST");
       /*查询已经被该名导师选择的学生信息*/
        param.put("tid", session.getAttribute("tid"));
        List<Map<String, Object>> ts = adminService.showStudentAndTeacher(param);
        //遍历ts，获取对应学生信息，加入ts中
        for(int i = 0;i < ts.size(); i++){
        	int star = 0;
            Map<String, Object> sMap = ts.get(i);
            String s = sMap.get("sid") == null?null:sMap.get("sid").toString();
            if(rn > this.calRoundNumber(sdf2.parse((sMap.get("stime").toString())))) {//之前轮次导师选择的学生不可删除
            	sMap.put("stime", 0);
            }else {//当前轮次导师选择的学生可删除
            	sMap.put("stime", 1);
            }
            if(s != null&& !s.equals("")){
                Map<String, Object> item = new HashMap<String, Object>();
                item.put("sid", s);
                Map<String, Object> pMap = studentService.showStudentById(item);
//                if(Double.parseDouble(pMap.get("GPA").toString()) <= GPA) {
                if(pMap.get("lowGPA")!=null) {
                	pMap.put("sname", "*"+pMap.get("sname"));
                }
                pMap.put("gpa",pMap.get("GPA").toString());
                sMap.putAll(pMap);
            }
         }
        if(rn >= 1 && rn <= 4) {
        	model.addAttribute("time", 1);//导师可以进行选择
        }
        model.addAttribute("TS",ts);
        model.addAttribute("teacher", teacherService.showTeacherInfoById(param));
        model.addAttribute("Round", Round);
        return "teacher/tea_both_choices";
    }
    
    /**
     * 计算给定时间所处的导师双选阶段
     * @return
     */
    public int calRoundNumber(Date date) {
    	Map<String, Object> time = adminService.showCtime(null);
    	try {
    		if(date.before(sdf2.parse(time.get("SSTT").toString()))) {
    			//学生还未开始选择
    			return -1;
    		}else if(date.before(sdf2.parse(time.get("FRTS").toString()))) {
    			//学生选择完毕，第一轮导师双选未开始
	    		return 0;
	    	}else if(date.before(sdf2.parse(time.get("SRTS").toString()))) {
	    		//第一轮开始
	    		return 1;
	    	}else if(date.before(sdf2.parse(time.get("TRTS").toString()))) {
	    		//第二轮开始
	    		return 2;
	    	}else if(date.before(sdf2.parse(time.get("FoRTS").toString()))) {
	    		//第三轮开始
	    		return 3;
	    	}else if(date.before(sdf2.parse(time.get("TSST").toString()))){
	    		//第四轮开始
	    		return 4;
	    	}else {
	    		//导师双选结束
	    		return 5;
	    	}
    	}catch(Exception e) {
    		e.printStackTrace();
    		//error
    		return -2;
    	}
    }
    
    
    // 修改双选表<ajax>
    @RequestMapping("TselectTS")
    @Transactional
    public void updateTS(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> param = FormDataCollectUtil.getInstance().getFormData(request);
        HttpSession session = request.getSession();
        param.put("tid", session.getAttribute("tid"));
        String[] sidgroup = request.getParameterValues("sid[]");
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < sidgroup.length; i++) {
        	String sid = sidgroup[i];
        	//System.out.println(sno);
        	Map<String, Object> ts =new HashMap<>();
        	ts.put("tid", param.get("tid"));
        	ts.put("sid", sid);
        	ts.put("num", -1);
        	ts.put("stime", new Date());
        	list.add(ts);
        }
        String result = adminService.TselectTS(list);
        try {
        	response.setContentType("text/html;charset=utf-8");
        	response.getWriter().print(result);
        } catch (Exception e) {
        	log.error(e);
        }
    }
    //教师删除选择的学生<ajax>
    @RequestMapping("TdeleteTS")
    @Transactional
    public void deleteTS(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> param = FormDataCollectUtil.getInstance().getFormData(request);
        HttpSession session = request.getSession();
        param.put("tid", session.getAttribute("tid"));
        String [] sidgroup = request.getParameterValues("sid[]");
        String result = null;
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        int s = sidgroup.length;
        for (int i = 0; i < sidgroup.length; i++) {
            String sid = sidgroup[i];
            //System.out.println(sno);
            Map<String, Object> ts = new HashMap<>();
            ts.put("tid", param.get("tid"));
            ts.put("sid", sid);
            ts.put("num", 1);
            //判断是否删除了没选的学生
            list.add(ts);
        }
        result = adminService.TdeleteTS(list);
        try {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(result);
        } catch (Exception e) {
            log.error(e);
        }
    }
    
    //教师修改信息页面 
    @RequestMapping("tea_info")
    public String teaInfo(HttpServletRequest request, Model model) {
    	HttpSession session = request.getSession();
    	Map<String, Object> param = new HashMap<String,Object>();
    	param.put("tno", session.getAttribute("tno"));
        Map<String, Object> map = teacherService.showTeacherInfo(param);
        // 转换图片格式
        byte[] b = (byte[]) map.get("picture");
        if (b != null) {
            String picture = new String(b);
            // System.out.println(picture);
            map.put("picture", picture);
        }
        model.addAttribute("teacher", map);
        return "teacher/tea_info";
    }

    
    // 教师发布题目页面 
    @RequestMapping("tea_set_topics")
    public String getTeacherSetTopic(HttpServletRequest request, Model model) {

    	HttpSession session = request.getSession();
    	Map<String, Object> param = new HashMap<String,Object>();
    	param.put("tno",session.getAttribute("tno"));
        Map<String, Object> tea = teacherService.showTeacherInfo(param);
        param.put("tid", tea.get("tid"));
        model.addAttribute("teacher", tea);//得到教师相关信息
        List<Map<String, Object>> list = paperService.selectPaperTitleByTea(param);//得到与该教师有关的论文信息
        int release = 0;//导师是否发布了题目
        int submit = 0;//是否有学生提交了题目
        // 遍历list，获取对应学生信息，加入list中
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> sMap = list.get(i);
            if((boolean)sMap.get("isTeaRelease")) {
            	release++;
            }
            if(sMap.get("sid") != null){
            	submit++;
            }
            String s = sMap.get("sid") == null ? null : sMap.get("sid")
                .toString();
            if (s != null && !s.equals("-1") && !s.equals("")) {
                Map<String, Object> item = new HashMap<String, Object>();
                item.put("sid", s);
                Map<String, Object> pMap = studentService.showStudentById(item);
                if(AdminController.getYear_t()==Integer.parseInt(pMap.get("grade").toString()))sMap.putAll(pMap);
                else {
                	pMap.put("sno", "0");
                	sMap.putAll(pMap);
                }
            }
        }
        model.addAttribute("papers", list);
        model.addAttribute("releaseNum", release);
        model.addAttribute("submitNum", submit);
        return "teacher/tea_set_topics";
    }

    //教师查询题目页面<暂时未用到>
   /* @RequestMapping("tea_set_topics_detailed")
    public String tea_set_topics_detailed(HttpServletRequest request,
        Model model) {
        Map<String, Object> param = FormDataCollectUtil.getInstance()
            .getFormData(request);
        Map<String, Object> title = paperService.showPaperTitleById(param);
        Map<String, Object> stu = studentService.showStudentById(title);
        if (stu != null) {
            title.put("sname", stu.get("sname"));
            title.put("sno", stu.get("sno"));
        }
        model.addAttribute("title", title);
        return "teacher/tea_set_topics_detailed";
    }*/

    /* 教师汇总页面 */
    /*@RequestMapping("tea_summary")
    public String getTeaSummary(HttpServletRequest request, Model model) {
        Map<String, Object> param = FormDataCollectUtil.getInstance()
            .getFormData(request);
        // 获取当前教师信息用来传tno
        model.addAttribute("teacher", teacherService.showTeacherInfo(param));
        List<Map<String, Object>> list = adminService
            .showStudentByTeacher(param);
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> sMap = list.get(i);
            String s = sMap.get("sno").toString();
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("sno", s);
            Map<String, Object> smap = studentService.showStudentInfo(item);
            Map<String, Object> pmap = paperService.showFiles(item);
            if (smap != null) {
                if (pmap != null) {
                    sMap.putAll(pmap);
                }
                sMap.putAll(smap);
            }
        }
        model.addAttribute("studentAll", list);
        return "teacher/tea_summary";
    }*/
    
    //模板页面
    @RequestMapping("tea_template")
    public String getStudentThesi(HttpServletRequest request, Model model) {
    	HttpSession session = request.getSession();
    	Map<String, Object> param = new HashMap<String,Object>();
    	param.put("tno", session.getAttribute("tno"));
        model.addAttribute("teacher", teacherService.showTeacherInfo(param));
        model.addAttribute("files", paperService.showTemplate(param));
        return "teacher/tea_template";
    }

    //教师文档管理页面 
    @RequestMapping("tea_topics")
    public String gett(HttpServletRequest request, Model model) {
    	HttpSession session = request.getSession();
    	Map<String, Object> param = new HashMap<String,Object>();
    	param.put("tno",session.getAttribute("tno"));
        // 获取当前教师信息用来传tno
        Map<String, Object> tMap = teacherService.showTeacherInfo(param);//该名教师信息
        model.addAttribute("teacher", tMap);
        param.put("tid", tMap.get("tid"));//将导师工号信息放入param中
        // 获取当前老师的所有学生(根据tid)
        List<Map<String, Object>> list = adminService
            .showStudentByTeacher(param);
        //System.out.println("list="+list);
        if(list.size() == 0) {
        	list = null;
        }else {
	        for (int i = 0; i < list.size(); i++) {
	            Map<String, Object> sMap = list.get(i);
	            String s = sMap.get("sid").toString();
	            Map<String, Object> item = new HashMap<String, Object>();
	            item.put("sid", s);
	            item.put("sno", studentService.showStudentById(item).get("sno"));
	            Map<String, Object> smap = studentService.showStudentInfo(item);//获取学生的基本信息及论文题目信息
	            Map<String, Object> pmap = paperService.showFiles(item);//获取学生的论文相关文档信息
	            if (smap != null) {
	                if (pmap != null) {
	                    sMap.putAll(pmap);
	                }
	                sMap.putAll(smap);
	            }
	        }
        }
        model.addAttribute("studentAll", list);
        return "teacher/tea_topics";
    }
    
    @RequestMapping("tea_agenda")
    public String tea_schedule(HttpServletRequest request, Model model) {
    	HttpSession session = request.getSession();
    	 Map<String, Object> param = FormDataCollectUtil.getInstance()
    	            .getFormData(request);
    	Map<String,Object> paramMap = new HashMap<String,Object>();
    	Object tid = session.getAttribute("tid");
    	paramMap.put("tid", tid);
    	int week;
    	String now = sdf.format(new Date());
		paramMap.put("date", now);
    	if(param.get("week") != null) {
    		week = Integer.parseInt((String)param.get("week"));
		}else {
			week = scheduleService.selectWeekByDate(paramMap);//得到当前周数			 
		}
    	paramMap.put("week", week);
    	List<Map<String, Object>> weekInfo = scheduleService.selectWeekInfoByTid(paramMap);
    	for(int i=0;i<weekInfo.size();i++) {
    		Map<String,Object> map = weekInfo.get(i);
    		Object sid = map.get("affairContent");
    		Map<String,Object> _map = new HashMap<String,Object>();
    		_map.put("sid", sid);
    		if((Integer)map.get("affairType") == 2) {
    			map.put("sname", studentService.showStudentById(_map).get("sname"));
    			//System.out.println(x);
    		}
    	}
    	Map<String, Object> tea = teacherService.showTeacherInfoById(paramMap);
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
    	List<Map<String, Object>> appointment = appointmentService.selectAppointmentByTid(paramMap);
    	if(appointment.size() == 0) {
    		appointment = null;
    	}else {
	    	for(int i=0;i<appointment.size();i++) {
	    		Map<String, Object> app = appointment.get(i);
	    		Map<String,Object> map = new HashMap<String,Object>();
	    		map.put("sid", app.get("sid"));
	    		app.put("sname", studentService.showStudentById(map).get("sname"));
	    		app.put("_sclass", sclassTransform((Integer)app.get("sclass")));
	     		app.put("_day", dayTransform((Integer)app.get("day")));
	    	}
    	}
    	model.addAttribute("week",week);
    	model.addAttribute("tea", tea);
    	model.addAttribute("schedule", weekInfo);
    	model.addAttribute("appointment", appointment);
    	return "teacher/tea_agenda";
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
    
    @RequestMapping("tea_edit_schedule")//教师编辑日程信息，包括添加和撤销日程
    public void tea_edit_schedule(HttpServletRequest request, HttpServletResponse response) {
    	HttpSession session = request.getSession();
   	 	Map<String, Object> param = FormDataCollectUtil.getInstance()
   	            .getFormData(request);
   	 	int result = 0;
   	 	param.put("tid", session.getAttribute("tid"));
   	 	result = scheduleService.updateSchedule(param);
   	 	if(!((String)param.get("newAffairType")).equals("0") && result == 1) {//修改日程为不可预约
   	 		appointmentService.deleteAppointment(param);//删除之前所有预约
   	 	}
   	 	response.setContentType("text/html;charset=utf-8");
   	 	try {
			response.getWriter().print(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    @RequestMapping("tea_set_reserve")
    public void tea_set_reserve(HttpServletRequest request, HttpServletResponse response) throws ParseException {
    	HttpSession session = request.getSession();
   	 	Map<String, Object> param = FormDataCollectUtil.getInstance()
   	            .getFormData(request);
   	 	int result = 0;
   	 	param.put("tid", session.getAttribute("tid"));
   	 	param.put("affairContent", param.get("sid"));
   	 	param.put("newAffairType", 2);
   	 	int i = scheduleService.updateSchedule(param);
   	 	if(i == 1) {
   	 		result = appointmentService.deleteAppointment(param);//成功
   	 	}
   	 	response.setContentType("text/html;charset=utf-8");
	 	try {
			response.getWriter().print(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    //评定小组页面 <暂时注释>
    /*@RequestMapping("teachergroup")
    public String getStudentThes(HttpServletRequest request, Model model) {
        Map<String, Object> param = FormDataCollectUtil.getInstance()
            .getFormData(request);
        // 获取当前教师信息用来传tno
        model.addAttribute("teacher", teacherService.showTeacherInfo(param));

        List<Map<String, Object>> list = teacherService.showStudentAll(param);
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> sMap = list.get(i);
            String s = sMap.get("sno").toString();
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("sno", s);
            Map<String, Object> pMap = paperService.showFiles(item);
            if (pMap != null) {
                sMap.putAll(pMap);
            }
        }
        // 遍历list，获取对应学生的论文题目，加入list中
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> sMap = list.get(i);
            String s = sMap.get("sid") == null ? null : sMap.get("sid")
                .toString();
            if (s != null && !s.equals("-1") && !s.equals("")) {
                Map<String, Object> item = new HashMap<String, Object>();
                item.put("sid", s);
                Map<String, Object> tMap = paperService
                    .showPaperTitleById(item);
                if (tMap != null) {
                    sMap.putAll(tMap);
                }

            }
        }
        model.addAttribute("studentAll", list);
        return "teacher/teachergroup";
    }
	*/
    
    //上传学生文档方法 <暂时未用到>
   /*@RequestMapping("/OneUpload")
    public String oneUpload(@RequestParam("imagefile") MultipartFile imageFile,
        HttpServletRequest request) {
        // 得到上传文件的保存目录，将上传的文件存放于WEB-INF目录下，不允许外界直接访问，保证上传文件的安全
        String uploadUrl = request.getSession().getServletContext()
            .getRealPath("/WEB-INF/upload");
        String filename = imageFile.getOriginalFilename();

        // 获取当前学生信息用来传sno
        Map<String, Object> param = FormDataCollectUtil.getInstance()
            .getFormData(request);
        Map<String, Object> map = studentService.showStudentInfo(param);
        String num = map.get("sno").toString();
        String type = param.get("type").toString();

        System.out.println(type);
        param.put("sno", num);

        Map<String, Object> updatefile = paperService.showFiles(param);

        File dir = new File(uploadUrl + File.separator + num);
        // 判断上传文件的保存目录是否存在

        boolean flag = false;

        if (updatefile == null) {
            updatefile = new HashMap<>();
            updatefile.put("sno", num);
            flag = true;
            dir.mkdirs();// 创建目录
        }
        int number = 0;
        // 判断传入什么类型文档，并将文件名传入一个map中
        int i = Integer.parseInt(type);
        switch (i) {
        case 1:
            System.out.println(1);
            updatefile.put("OpeningReport", filename);
            if (updatefile.keySet().contains("Onum")
                && updatefile.get("Onum").toString() != null
                && !updatefile.get("Onum").equals("")) {
                number = Integer.parseInt(updatefile.get("Onum").toString());
            }
            number++;
            String O = String.valueOf(number);
            updatefile.put("Onum", O);
            break;
        case 2:
            System.out.println(2);
            updatefile.put("ForeignLanguageTranslation", filename);
            if (updatefile.keySet().contains("Fnum")
                && updatefile.get("Fnum").toString() != null
                && !updatefile.get("Fnum").equals("")) {
                number = Integer.parseInt(updatefile.get("Fnum").toString());
            }
            number++;
            String F = String.valueOf(number);
            updatefile.put("Fnum", F);
            break;
        case 3:
            System.out.println(3);
            updatefile.put("Paper", filename);
            if (updatefile.keySet().contains("Pnum")
                && updatefile.get("Pnum").toString() != null
                && !updatefile.get("Pnum").equals("")) {
                number = Integer.parseInt(updatefile.get("Pnum").toString());
            }
            number++;
            String P = String.valueOf(number);
            updatefile.put("Pnum", P);
            break;
        case 4:
            System.out.println(4);
            updatefile.put("ArgumentBook", filename);
            if (updatefile.keySet().contains("Anum")
                && updatefile.get("Anum").toString() != null
                && !updatefile.get("Anum").equals("")) {
                number = Integer.parseInt(updatefile.get("Anum").toString());
            }
            number++;
            String A = String.valueOf(number);
            updatefile.put("Anum", A);
            break;
        case 5:
            System.out.println(5);
            updatefile.put("InstructionManual", filename);
            if (updatefile.keySet().contains("Inum")
                && updatefile.get("Inum").toString() != null
                && !updatefile.get("Inum").equals("")) {
                number = Integer.parseInt(updatefile.get("Inum").toString());
            }
            number++;
            String I = String.valueOf(number);
            updatefile.put("Inum", I);
            break;
        case 6:
            System.out.println(6);
            updatefile.put("GuidingOpinions", filename);
            if (updatefile.keySet().contains("Gnum")
                && updatefile.get("Gnum").toString() != null
                && !updatefile.get("Gnum").equals("")) {
                number = Integer.parseInt(updatefile.get("Gnum").toString());
            }
            number++;
            String G = String.valueOf(number);
            updatefile.put("Gnum", G);
            break;
        default:
            System.out.println(0);
        }
        if (flag) {
            paperService.addFiles(updatefile);
            // 新增到数据库
            System.out.println("新增文件上传到: " + uploadUrl + File.separator + num
                + File.separator + filename);
        } else {
            paperService.updateFiles(updatefile);
            // 储存并更新数据库
            System.out.println("更新文件上传到: " + uploadUrl + File.separator + num
                + File.separator + filename);
        }

        File targetFile = new File(uploadUrl + File.separator + num
            + File.separator + filename);
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
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return "teacher/uploadSuccess";
    }*/

    //<ajax>下载学生文档方法 
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
        System.out.println(param);
        Map<String, Object> map = studentService.showStudentById(param);
        String num = map.get("sno").toString();
        String type = param.get("type").toString();
        param.put("sid", map.get("sid"));
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
            filename = files.get("InstructionManual").toString();
            break;
        case 5:
            System.out.println(5);
            filename = files.get("ArgumentBook").toString();
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
        String downLoadPath = filePath + File.separator + num + File.separator
            + filename;
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

     //上传模板方法<暂时未用到>
     /*@RequestMapping("/templateUpload")
    public String templateUpload(
        @RequestParam("imagefile") MultipartFile imageFile,
        HttpServletRequest request) {
        // 得到上传文件的保存目录，将上传的文件存放于WEB-INF目录下，不允许外界直接访问，保证上传文件的安全
        String uploadUrl = request.getSession().getServletContext()
            .getRealPath("/WEB-INF/template");
        String filename = imageFile.getOriginalFilename();
        Map<String, Object> param = FormDataCollectUtil.getInstance()
            .getFormData(request);
        Map<String, Object> updatefile = paperService.showTemplate(param);

        File dir = new File(uploadUrl);
        // 判断上传文件的保存目录是否存在
        boolean flag = false;
        if (updatefile == null) {
            flag = true;
            dir.mkdirs();// 创建目录
        }
        // 判断传入什么类型文档，并将文件名传入一个map中
        String type = param.get("type").toString();
        int i = Integer.parseInt(type);
        switch (i) {
        case 1:
            System.out.println(1);
            param.put("GraduationDesignManual", filename);
            break;
        case 2:
            System.out.println(2);
            param.put("ScoreTable", filename);
            break;
        case 3:
            System.out.println(3);
            param.put("ReplyRecord", filename);
            break;
        case 4:
            System.out.println(4);
            param.put("OpeningReportTemplate", filename);
            break;
        case 5:
            System.out.println(5);
            param.put("Other", filename);
            break;
        default:
            System.out.println(0);
        }
        if (flag) {
            paperService.addTemplate(param);
            // 新增到数据库
            System.out.println("新增文件上传到: " + uploadUrl + File.separator
                + filename);
        } else {
            paperService.updateTemplate(param);
            // 储存并更新数据库
            System.out.println("更新文件上传到: " + uploadUrl + File.separator
                + filename);
        }

        File targetFile = new File(uploadUrl + File.separator + filename);
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
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return "teacher/uploadSuccess";
    }
    */

    //下载模板方法 <ajax>
    @RequestMapping("/templateDownload")
    public void tdownload(HttpServletRequest request,
        HttpServletResponse response) {

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
        String downLoadPath = filePath + File.separator + filename;
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

    //修改保存教师信息方法
    @RequestMapping("updateTeacher")
    public void saveTeacher(HttpServletRequest request,
        HttpServletResponse response) {
        Map<String, Object> param = FormDataCollectUtil.getInstance()
            .getFormData(request);
        HttpSession session = request.getSession();
        param.put("tno", session.getAttribute("tno"));
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
            String str = teacherService.updateTeacherByTea(param);
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(str);
        } catch (Exception e) {
            log.error(e);
        }
    }

    //教师汇总， 修改学生信息方法<暂未用到>
    /*@RequestMapping("updateSummary")
    public void updateSummary(HttpServletRequest request,
        HttpServletResponse response) {
        Map<String, Object> param = FormDataCollectUtil.getInstance()
            .getFormData(request);

        try {
            String str = teacherService.updateSummary(param);
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(str);
        } catch (Exception e) {
            log.error(e);
        }
    }*/

    //教师新增论文题目方法 <ajax>
    @RequestMapping("addTitle")
    public void addTitle(HttpServletRequest request,
        HttpServletResponse response) {
        Map<String, Object> param = FormDataCollectUtil.getInstance()
            .getFormData(request);
        HttpSession session = request.getSession();
        param.put("tid", session.getAttribute("tid"));
        param.put("isTeaRelease", true);
        try {
            String str = paperService.addPaperTitle(param);
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(str);
        } catch (Exception e) {
            log.error(e);
        }
    }

    //教师查询论文题目方法<ajax> 
    @RequestMapping("selectTitle")
    public void selectTitle(HttpServletRequest request,
        HttpServletResponse response) {
        Map<String, Object> param = FormDataCollectUtil.getInstance()
            .getFormData(request);
        int i = 0;
        try {
            if (!param.get("title").toString().isEmpty()) {
                if (paperService.countPaper(param) != 0) {
                    Map<String, Object> paper = paperService
                        .showPaperInfoByTitle(param);
                    i = Integer.parseInt(paper.get("paperid").toString());
                }
            } else if (!param.get("sno").toString().isEmpty()) {
                Map<String, Object> stu = studentService.showStudentInfo(param);
                if (paperService.countPaper(stu) != 0) {
                    Map<String, Object> paper = paperService
                        .showPaperTitleById(stu);
                    i = Integer.parseInt(paper.get("paperid").toString());
                }
            } 
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(i);
        } catch (Exception e) {
            log.error(e);
        }
    }

   //教师删除论文题目方法 <ajax>
    @RequestMapping("deleteTitle")
    public void deletePaperById(HttpServletRequest request,
        HttpServletResponse response) {
        Map<String, Object> param = FormDataCollectUtil.getInstance()
            .getFormData(request);
        try {
            String str = paperService.tea_deletePaper(param);
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(str);
        } catch (Exception e) {
            log.error(e);
        }

    }

    //更改题目状态方法<ajax>
    @RequestMapping("changeTitleState")
    public void changeTitleState(HttpServletRequest request,
        HttpServletResponse response) {
        Map<String, Object> param = FormDataCollectUtil.getInstance()
            .getFormData(request);
        if ("1".equals(param.get("state"))) {
            param.put("state", 0);
        } else {
            param.put("state", 1);
        }
        try {
            String str = paperService.changeTitleState(param);
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(str);
        } catch (Exception e) {
            log.error(e);
        }

    }

    //更改文档通过状态<ajax>
    @RequestMapping("updateFilesState")
    public void updateFilesState(HttpServletRequest request,
        HttpServletResponse response) {
        Map<String, Object> param = FormDataCollectUtil.getInstance()
            .getFormData(request);
        param.put("sid", studentService.showStudentInfo(param).get("sid"));
        try {
            Map<String, Object> updatefile = paperService.showFiles(param);
            if (param.get("Ostate") != null) {
                updatefile.put("Ostate", param.get("Ostate").toString());
            } else if (param.get("Fstate") != null) {
                updatefile.put("Fstate", param.get("Fstate").toString());
            } else if (param.get("Pstate") != null) {
                updatefile.put("Pstate", param.get("Pstate").toString());
            } else if (param.get("Astate") != null) {
                updatefile.put("Astate", param.get("Astate").toString());
            } else if (param.get("Istate") != null) {
                updatefile.put("Istate", param.get("Istate").toString());
            } else if (param.get("Gstate") != null) {
                updatefile.put("Gstate", param.get("Gstate").toString());
            } else if (param.get("GOstate") != null) {
                updatefile.put("GOstate", param.get("GOstate").toString());
            } else if (param.get("GFstate") != null) {
                updatefile.put("GFstate", param.get("GFstate").toString());
            } else if (param.get("GPstate") != null) {
                updatefile.put("GPstate", param.get("GPstate").toString());
            } else if (param.get("GAstate") != null) {
                updatefile.put("GAstate", param.get("GAstate").toString());
            } else if (param.get("GIstate") != null) {
                updatefile.put("GIstate", param.get("GIstate").toString());
            } else if (param.get("GGstate") != null) {
                updatefile.put("GGstate", param.get("GGstate").toString());
            }
            String str = paperService.updateFiles(updatefile);
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(str);
        } catch (Exception e) {
            log.error(e);
        }

    }
    //教师上传指导文档
    @RequestMapping("/OneUpload")
    public void oneUpload(@RequestParam("imagefile") MultipartFile imageFile,
        HttpServletRequest request, HttpServletResponse response) {
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
        //log.info(df.format(new Date())); new Date()为获取当前系统时间
        String temp = df.format(new Date());
        // 获取当前学生信息用来传sno
        Map<String, Object> param = FormDataCollectUtil.getInstance()
            .getFormData(request);
        //System.out.println(param);
        Map<String, Object> map = studentService.showStudentInfo(param);//根据学生sno查询学号等信息
        //String sid = param.get("sid").toString();
        String type = param.get("type").toString();
        String sno = map.get("sno").toString();
        Map<String, Object> updatefile = paperService.showFiles(param);//查询该名学生论文文档记录
        File dir = new File(uploadUrl + File.separator + sno);//每名学生的用来存储文档的目录
        //System.out.println("是否存在目录？"+dir.exists());
        if(!dir.exists()) {
        	dir.mkdirs();
        }
        // 判断传入什么类型文档，并将文件名传入一个map中
        int i = Integer.parseInt(type);
        String newFileName = null;
        switch(i) {
        case 7:
            System.out.println(7);
            newFileName = sno + "-开题报告（指导）" + fileType;
            updatefile.put("tOpeningReport",newFileName);
            updatefile.put("tOtime", temp);
            break;
        case 8:
            System.out.println(8);
            newFileName = sno + "-外文翻译（指导）" + fileType;
            updatefile.put("tForeignLanguageTranslation",newFileName);
            updatefile.put("Ftime", temp);
            break;
        case 9:
            System.out.println(9);
            newFileName = sno + "-论文（指导）" + fileType;
            updatefile.put("tPaper",newFileName);
            updatefile.put("tPtime", temp);
            break;
        case 10:
            System.out.println(10);
            newFileName = sno + "-论证书（指导）" + fileType;
            updatefile.put("tArgumentBook",newFileName);
            updatefile.put("tAtime", temp);
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
}

