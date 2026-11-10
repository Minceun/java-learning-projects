package com.spring.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Timer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.auto.Listener.autoSelect_round1;
import com.auto.Listener.autoSelect_round2;
import com.auto.Listener.autoSelect_round3;
import com.auto.Listener.autoSelect_round4;
import com.common.NetBug.CourseInfoNetBug;
import com.common.util.FormDataCollectUtil;
import com.common.util.Student;
import com.spring.service.AdminService;
import com.spring.service.LoginService;
import com.spring.service.PaperService;
import com.spring.service.ScheduleService;
import com.spring.service.StudentService;
import com.spring.service.TeacherService;

import ch.qos.logback.core.net.SyslogOutputStream;
import common.Logger;
import jxl.Workbook;

@Controller
@RequestMapping("/Admin")
public class AdminController {

    @Autowired(required = true)
    private AdminService adminService;
    
    @Autowired(required = true)
    private TeacherService teacherService;
    
    @Autowired(required = true)
    private StudentService studentService;
    
    @Autowired(required = true)
    private PaperService paperService;
    
    @Autowired(required = true)
    private ScheduleService scheduleService;
    
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
    private Logger log = Logger.getLogger(LoginService.class);
    
    private static int year=0;//导师双选年级
    
    private static int year_t=0;//论文功能年级
    
    public static int getYear() {
    	return year;
    }
    public static void setYear(int a) {
    	year=a;
    }
    
    public static int getYear_t() {
		return year_t;
	}
	public static void setYear_t(int year_t) {
		AdminController.year_t = year_t;
	}
	//导出汇总表
    @RequestMapping("/exportToExcel")
    public void exportUsersListToExcel(HttpServletRequest request,HttpServletResponse response) {
    	 Map<String, Object> param = FormDataCollectUtil.getInstance()
    	            .getFormData(request);
        response.reset();
        String type = (String)param.get("type");
        String filename=param.get("grade").toString()+"级导师双选结果表";
        if(type.equals("1")) {//导师双选信息表
        	try {
                response.setHeader("Content-disposition", "attachment;filename="
                        + new String(filename.getBytes("GB2312"), "8859_1")
                        + ".xls");
                response.setContentType("application/msexcel");
//                String[] labels={"学生学号","学生姓名","学院","专业","年级","班级","教师工号","教师姓名"};
                String[] labels={"教师姓名","教师职称","办公室","指导人数","学生1姓名","电话","学号","学生2姓名","电话","学号","学生3姓名","电话","学号","学生4姓名","电话","学号","学生5姓名","电话","学号","学生6姓名","电话","学号"};
                List<String[]> cells=new ArrayList<String[]>();
//                List<Map<String, Object>> list = adminService.showStudentAndTeacher(param);//得到所有双选表信息
                List<Map<String, Object>> list = adminService.ts_Teacher();
                int sum=0;
                for(int i=0;i<list.size();i++) {
                    String[] cell=new String[44];
//                	Map<String, Object> _list = list.get(i);
//                	Map<String,Object> item =  new HashMap<String,Object>();
//                	item.put("sid", _list.get("sid"));
//                	Map<String, Object> sMap = studentService.showStudentById(item);//加入学生信息
//                	if(sMap.get("grade").equals(param.get("grade"))) {
//                		_list.putAll(sMap);
//                		item.put("tid", _list.get("tid"));
//                		Map<String, Object> tMap = teacherService.showTeacherInfoById(item);//加入教师信息
//                		_list.putAll(tMap);
//                	}
                	Map<String, Object> _list = list.get(i);
                	Map<String, Object> tMap = teacherService.showTeacherInfoById(_list);//加入教师信息
                	cell[0]=(String)tMap.get("tname");
                	cell[1]=(String)tMap.get("title");
                	cell[2]=(String)tMap.get("office");
                	List<Map<String, Object>> list_s = adminService.showStudentAndTeacher(_list);//得到所有双选表信息
                	int n=4;
                	cell[3]=String.valueOf(list_s.size());
                	sum+=list_s.size();
                	for(int j=0;j<list_s.size();j++) {
                		Map<String,Object> item_s =  new HashMap<String,Object>();
                    	item_s.put("sid", list_s.get(j).get("sid"));
                    	Map<String, Object> sMap = studentService.showStudentById(item_s);//加入学生信息
                    	cell[n++]=(String)sMap.get("sname");
                    	cell[n++]=sMap.get("phone")==null ? "" :(String)sMap.get("phone");
                    	cell[n++]=(String)sMap.get("sno");
                	}
                	cells.add(cell);
                }
                String[] cell=new String[4];
                cell[0]="总计";
                cell[3]=String.valueOf(sum);
                cells.add(cell);
//                for (Map<String, Object>  m: list) {
//                    String[] cell=new String[labels.length];
//                    if(m.get("sno")==null)continue;
//                    cell[0]=(String) m.get("sno");
//                    cell[1]=(String) m.get("sname");
//                    cell[2]=(String) m.get("school");
//                    cell[3]=(String) m.get("career");
//                    cell[4]=(String) m.get("grade");
//                    cell[5]=(String) m.get("sclass");
//                    cell[6]=(String) m.get("tno");
//                    cell[7]=(String) m.get("tname");
//                    cells.add(cell);
//                }
                try {
                	adminService.createExport(response.getOutputStream(), labels, cells);
                } catch (IOException e) {
                	e.printStackTrace();
                } catch (Exception e) {
                	e.printStackTrace();
                }
        	}catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }else if(type.equals("2")) {
	        try {
	            response.setHeader("Content-disposition", "attachment;filename="
	                    + new String("教师汇总信息列表".getBytes("GB2312"), "8859_1")
	                    + ".xls");
	            response.setContentType("application/msexcel");
	            //往表中填数据
	            String[] labels={"毕业时间","学院","题目","学号","学生姓名","专业","班级","类型",
	                "是否实际题目","科研生产实际或基本训练","校内（外）"};
	            List<String[]> cells=new ArrayList<String[]>();
	            List<Map<String, Object>> list = adminService.showStudentAllDesc(null);
	            for (int i = 0; i < list.size(); i++) {
	                Map<String, Object> sMap = list.get(i);
	                String s = sMap.get("sno").toString();
	                Map<String, Object> item = sMap;
	                item.put("sno", s);
	                Map<String, Object> smap = studentService.showStudentInfo(item);
	                Map<String, Object> pmap = paperService.showFiles(item);
	                if (smap != null) {
	                    if (pmap != null) {
	                        sMap.putAll(pmap);
	                    }
	                    changeBoolean(smap);
	                    sMap.putAll(smap);
	                }
	            }
	            try {
	            for (Map<String, Object>  m: list) {
	            String[] cell=new String[labels.length];
	            cell[0]=(String) m.get("grade");
	            cell[1]=(String) m.get("school");
	            cell[2]=(String) m.get("title");
	            cell[3]=(String) m.get("sno");
	            cell[4]=(String) m.get("sname");
	            cell[5]=(String) m.get("career");
	            cell[6]=(String) m.get("sclass");
	            cell[7]=(String) m.get("Type");
	            cell[8]=(String) m.get("ActualQuestions");
	            cell[9]=(String) m.get("ResearchType");
	            cell[10]=(String) m.get("InsideORoutside");
	            cells.add(cell);
	                }
	                    adminService.createExport(response.getOutputStream(), labels, cells);
	                } catch (Exception e) {
	                e.printStackTrace();
	                }
	            
	        } catch (UnsupportedEncodingException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
        }
    }
    //转换Boolean为字符串
    public void changeBoolean(Map<String, Object>  smap) {
        if(smap.get("Type")!=null){
            if(smap.get("Type").equals(true)){
                smap.put("Type", "理论");
            }else{
                smap.put("Type", "设计");
            }
        }
        if(smap.get("ActualQuestions")!=null){
            if(smap.get("ActualQuestions").equals(true)){
                smap.put("ActualQuestions", "是");
            }else{
                smap.put("ActualQuestions", "否");
            }
        }
        if(smap.get("ResearchType")!=null){
            if(smap.get("ResearchType").equals(true)){
                smap.put("ResearchType", "科研生产实际");
            }else{
                smap.put("ResearchType", "基本训练");
            }
        }
        if(smap.get("InsideORoutside")!=null){
            if(smap.get("InsideORoutside").equals(true)){
                smap.put("InsideORoutside", "校内");
            }else{
                smap.put("InsideORoutside", "校外");
            }
        }
    }
    
    //管理员主页
    @RequestMapping("admin_index")
    public String setAdmin_index(HttpServletRequest request, Model model) {
    	HttpSession session = request.getSession();
    	Map<String,Object> param = new HashMap<String,Object>();
        param.put("adminno",session.getAttribute("adminno"));
        model.addAttribute("admin", adminService.showAdminInfo(param));
        return "Admin/admin_index";
    }
    // 管理员管理页面
    @RequestMapping("AdminManage")
    public String setAdminManage(HttpServletRequest request,Model model) {
    	HttpSession session = request.getSession();
    	Map<String,Object> param = new HashMap<String,Object>();
        param.put("adminno",session.getAttribute("adminno"));
        model.addAttribute("admin", adminService.showAdminInfo(param));
        List<Map<String, Object>> list = adminService.showAdminAll(param);
        model.addAttribute("adminAll", list);
        return "Admin/AdminManage";
    }
    // 教师管理页面
    @RequestMapping("TeacherManage")
    public String setTeacherManage(HttpServletRequest request,Model model) {
    	HttpSession session = request.getSession();
    	Map<String,Object> param = new HashMap<String,Object>();
    	//System.out.println(session.getAttribute("adminno"));
        param.put("adminno",session.getAttribute("adminno"));
        model.addAttribute("admin", adminService.showAdminInfo(param));
        List<Map<String, Object>> list = teacherService.showTeacherAll(param);
        //循环遍历list
        for(int i=0;i<list.size();i++ ){
          //转换图片格式
            Map<String, Object> m= list.get(i);
            byte[] b = (byte[])m.get("picture");
            if(b!=null){
                String picture = new String(b);
                m.put("picture", picture);
            }
        }
        model.addAttribute("teacherAll", list);
        return "Admin/TeacherManage";
    }
    @RequestMapping("query_update_info")
    public String query_update_info_dispatcher(HttpServletRequest request,Model model) {
    	Map<String, Object> param = FormDataCollectUtil.getInstance()
    			.getFormData(request);
    	Map<String, Object> teaInfo = teacherService.showTeacherInfo(param);
    	String content = (String)teaInfo.get(param.get("contentType"));
    	model.addAttribute("tno", param.get("tno"));
    	model.addAttribute("content", content);
    	model.addAttribute("contentType",param.get("contentType"));
    	return "Admin/query_update_info";
    }
    
    @RequestMapping("query_update_picture")
    public String queryAndUpdatePicture(HttpServletRequest request,Model model) {
    	Map<String, Object> param = FormDataCollectUtil.getInstance()
    			.getFormData(request);
    	String type = (String)param.get("type");
    	if("teacher".equalsIgnoreCase(type)) {
    		param.put("tno", param.get("userno"));
    		Map<String,Object> tea = teacherService.showTeacherInfo(param);
    		if(tea.get("picture") != null) {
    			tea.put("picture", new String((byte[])tea.get("picture")));
    		}
    		model.addAttribute("info", tea);
    		model.addAttribute("type",type);
    	}else if("student".equalsIgnoreCase(type)) {
    		param.put("sno", param.get("userno"));
    		Map<String,Object> stu = studentService.showStudentInfo(param);
    		if(stu.get("picture") != null) {
    			stu.put("picture", new String((byte[])stu.get("picture")));
    		}
    		model.addAttribute("info", stu);
    		model.addAttribute("type",type);
    	}else {
    		model.addAttribute("info",null);
    		model.addAttribute("type",type);
    	}
    	return "Admin/query_update_picture";
    }
    
    @RequestMapping("upDatePicture")
    public void upDatePicture(HttpServletRequest request,HttpServletResponse response) {
    	Map<String, Object> param = FormDataCollectUtil.getInstance()
    			.getFormData(request);
    	String type = (String)param.get("type");
    	int result;
    	if("teacher".equalsIgnoreCase(type)) {
    		param.put("tno", param.get("userno"));
    		result = adminService.A_update_T_picture(param);
    	}else if("student".equalsIgnoreCase(type)) {
    		param.put("sno", param.get("userno"));
    		result = adminService.A_update_S_picture(param);
    	}else {
    		result = 0;
    	}
    	try {
    		response.setContentType("text/html;charset=utf-8");
			response.getWriter().print(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @RequestMapping("update_info")
    public void update_info_(HttpServletRequest request,HttpServletResponse response) {
    	Map<String, Object> param = FormDataCollectUtil.getInstance()
    			.getFormData(request);
    	String contentType = (String)param.get("contentType");
    	int result;
    	if("direction".equalsIgnoreCase(contentType)) {
    		result = adminService.A_update_direction(param);
    	}else if("achievement".equalsIgnoreCase(contentType)) {
    		result = adminService.A_update_achievement(param);
    	}else if("teach".equalsIgnoreCase(contentType)){
    		result = adminService.A_update_teach(param);
    	}else if("researchAbstract".equalsIgnoreCase(contentType)){
    		result = adminService.A_update_researchAbstract(param);
    	}else {
    		result = 0;
    	} 
    	try {
    		response.setContentType("text/html;charset=utf-8");
			response.getWriter().print(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    // 学生管理页面
    @RequestMapping("StudentManage")
    public String setStudentManage(HttpServletRequest request,Model model) {
    	HttpSession session = request.getSession();
    	Map<String,Object> param = new HashMap<String,Object>();
    	List<Map<String,Object>> grade=studentService.showStudentGrade();
        param.put("adminno",session.getAttribute("adminno"));
        model.addAttribute("admin", adminService.showAdminInfo(param));
		String search=request.getParameter("search");
		String sgrade=request.getParameter("grade");
		param.put("search", "%"+search+"%");
		param.put("sgrade", sgrade);
		List<Map<String, Object>> list;
		list=teacherService.showStudentbygrade(param);
		model.addAttribute("sgrade",sgrade);
        //循环遍历list
        for(int i=0;i<list.size();i++ ){
          //转换图片格式
            Map<String, Object> m= list.get(i);
            byte[] b = (byte[])m.get("picture");
            if(b!=null){
                String picture = new String(b);
                m.put("picture", picture);
            }
        }
        model.addAttribute("studentAll", list);
        model.addAttribute("grade",grade);
        return "Admin/StudentManage";
    }
    // 模板管理页面
    @RequestMapping("TemplateManage")
    public String setTemplateManage(HttpServletRequest request,Model model) {
    	HttpSession session = request.getSession();
    	Map<String,Object> param = new HashMap<String,Object>();
        param.put("adminno",session.getAttribute("adminno"));
        model.addAttribute("admin", adminService.showAdminInfo(param));
        model.addAttribute("template",paperService.showTemplate(param));
        return "Admin/TemplateManage";
    }
    // 文档管理页面
    @RequestMapping("FilesManage")
    public String setFilesManage(HttpServletRequest request,Model model) {
    	HttpSession session = request.getSession();
    	Map<String,Object> param = new HashMap<String,Object>();
        param.put("adminno",session.getAttribute("adminno"));
        model.addAttribute("admin", adminService.showAdminInfo(param));
        List<Map<String, Object>> list = paperService.showStudentAndTitle(param);
        model.addAttribute("studentAll", list);
        return "Admin/FilesManage";
    }
    // 时间管理页面
    @RequestMapping("TimeManage")
    public String setTimeManage(HttpServletRequest request,Model model) {
    	HttpSession session = request.getSession();
    	Map<String,Object> param = new HashMap<String,Object>();
        param.put("adminno",session.getAttribute("adminno"));
        model.addAttribute("admin", adminService.showAdminInfo(param));
        Map<String, Object> time = adminService.showCtime(param);
        for(Map.Entry entry : time.entrySet()) {
        	String key = entry.getKey().toString();
        	String value = entry.getValue().toString();
        	time.put(key, value.replace(' ', 'T'));
        }
        List<Map<String,Object>> grade_s=adminService.getStudentGrade();
        model.addAttribute("grade",grade_s);
        model.addAttribute("a_grade",year);
        model.addAttribute("b_grade",year_t);
        model.addAttribute("time", time);
        return "Admin/TimeManage";
    }
    
    //日程管理
    @RequestMapping("ScheduleManage")
    public String setScheduleManage(HttpServletRequest request,Model model) {
    	
    	HttpSession session = request.getSession();
    	Map<String,Object> param = new HashMap<String,Object>();
        param.put("adminno",session.getAttribute("adminno"));
        List<Map<String, Object>> tea = teacherService.showTeacherAll(param);//所有教师信息
        for(int i=0;i<tea.size();i++) {
        	Map<String, Object> _tea = tea.get(i);
        	param.put("tid", _tea.get("tid"));
        	int num = scheduleService.selectNumByTid(param);
        	if(num == 840) {
        		_tea.put("success", 1);
        	}else {
        		_tea.put("success", 0);
        	}
        }
        model.addAttribute("admin", adminService.showAdminInfo(param));
        model.addAttribute("tea", tea);
        return "Admin/ScheduleManage";
    }
    
    @RequestMapping("setTeaSchedule")//数据库中初始化该名教师日程信息
    public void setTeaSchedule(HttpServletRequest request,
            HttpServletResponse response) throws UnsupportedOperationException, IOException, ParseException {
    	 Map<String, Object> param = FormDataCollectUtil.getInstance()
                 .getFormData(request);
    	 int _result = 0;
    	 String tid = (String)param.get("tid");
    	 if(tid != null) {
	    	 int num = scheduleService.selectNumByTid(param);
	    	 if(num > 0 && num != 840) {
	    		 scheduleService.deleteScheduleByTid(param);
	    	 }
			CourseInfoNetBug.loginModel();//登录
			Map<String, Object> tea = teacherService.showTeacherInfoById(param);//得到教师信息
			String termNo = "16";
			String tno = (String)tea.get("tno");//得到教师工号
			Map<String,Object> paramMap = new HashMap<String,Object>();
			paramMap.put("tid", tid);
			Map<Integer, Object> result = CourseInfoNetBug.getCourseInfo(tno, termNo, sdf.parse("2018-03-05"));
			for(Map.Entry<Integer, Object> entry:result.entrySet()) {
				int weekNo = entry.getKey();
				paramMap.put("week", weekNo);
				@SuppressWarnings("unchecked")
				Map<Integer,String> info = (Map<Integer,String>)entry.getValue();
				for(Map.Entry<Integer, String> _entry:info.entrySet()) {
					int k = _entry.getKey();
					if(k>=0) {
						int _i = k/6+1;
						int j = k%6+1;
						paramMap.put("day", _i);
						paramMap.put("sclass", j);
						paramMap.put("date", sdf.format(info.get(-k-1)));
						String cName = _entry.getValue();
						paramMap.put("affairContent", cName);
						if(cName == null) {
							paramMap.put("affairType", 0);
						}else {
							paramMap.put("affairType", 1);
						}
						scheduleService.addSchedule(paramMap);
					}
				}
			}
			if(scheduleService.selectNumByTid(param) == 840) {
				_result = 1;//成功
			}
		}
    	 response.setContentType("text/html;charset=utf-8");
         response.getWriter().print(_result);
    }
 
    @RequestMapping("delTeaScheduleAll")//删除所有日程信息
    public void delTeaScheduleAll(HttpServletRequest request,
            HttpServletResponse response) {
    	 String adminno = (String)request.getSession().getAttribute("adminno");
    	 int result = 0;
    	 HashMap<String, Object> param = new HashMap<String,Object>();
    	 if(adminno != null && !adminno.trim().equals("")) {
    		 result = scheduleService.deleteAllSchedule(param);
    	 }
    	 response.setContentType("text/html;charset=utf-8");
         try {
			response.getWriter().print(result);//0失败，1-成功
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    // 修改时间表
    @RequestMapping("updateTime")
    public void updateTime(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> param = FormDataCollectUtil.getInstance().getFormData(request);
        try {
        	Map<String, Object> time = adminService.showCtime(param);
        	switch(Integer.parseInt(((String)param.get("type")))) {
        	case 1:
        		time.put("SSTT", param.get("controllertime"));
        		break;
        	case 2:
        		time.put("TSST", param.get("controllertime"));
        		break;
        	case 3:
        		time.put("FRTS", param.get("controllertime"));
        		SimpleDateFormat s1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        		String a1=time.get("FRTS").toString().replace("T"," ");//将默认格式中的T替换为空格
        		Date date1=s1.parse(a1);
//        		Date date=s.parse(time.get("FRTS").toString());
//        		System.out.println(date);  
        		Timer ti1=new Timer(true);
        		ti1.schedule(new autoSelect_round1(),date1);
        		break;
        	case 4:
        		time.put("SRTS", param.get("controllertime"));
        		SimpleDateFormat s2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        		String a2=time.get("SRTS").toString().replace("T"," ");//将默认格式中的T替换为空格
        		Date date2=s2.parse(a2);
//        		Date date=s.parse(time.get("FRTS").toString());
//        		System.out.println(date);  
        		Timer ti2=new Timer(true);
        		ti2.schedule(new autoSelect_round2(),date2);
        		break;
        	case 5:
        		time.put("TRTS", param.get("controllertime"));
        		SimpleDateFormat s3 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        		String a3=time.get("TRTS").toString().replace("T"," ");//将默认格式中的T替换为空格
        		Date date3=s3.parse(a3);
//        		Date date=s.parse(time.get("FRTS").toString());
//        		System.out.println(date);  
        		Timer ti3=new Timer(true);
        		ti3.schedule(new autoSelect_round3(),date3);
        		break;
        	case 6:
        		time.put("FoRTS", param.get("controllertime"));
        		SimpleDateFormat s4 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        		String a4=time.get("FoRTS").toString().replace("T"," ");//将默认格式中的T替换为空格
        		Date date4=s4.parse(a4);
//        		Date date=s.parse(time.get("FRTS").toString());
//        		System.out.println(date);  
        		Timer ti4=new Timer(true);
        		ti4.schedule(new autoSelect_round4(),date4);
        		break;
        	default:
        		break;
        	}
            String str = adminService.updateCtime(time);
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(str);
        } catch (Exception e) {
            log.error(e);
        }
    }
    // 双选管理页面
    @RequestMapping("ShuangxuanManage")
    public String ShuangxuanManage(HttpServletRequest request,Model model) {
    	HttpSession session = request.getSession();
    	Map<String,Object> param = new HashMap<String,Object>();
        param.put("adminno",session.getAttribute("adminno"));
        model.addAttribute("admin", adminService.showAdminInfo(param));
        List<Map<String, Object>> ts = adminService.showStudentAndTeacher(param);//得到全部双选表信息(tid == null)
        List<Map<String, Object>> tea = teacherService.showTeacherAll(param);//得到所有教师信息
        if(request.getParameter("grade")==null)param.put("grade", year);
        else param.put("grade", request.getParameter("grade"));
        List<Map<String, Object>> _stu = adminService.showStudentNotSelected(param);
        //遍历ts，获取对应学生教师信息，加入ts中
        for(int i = 0;i < ts.size(); i ++){
            Map<String, Object> sMap = ts.get(i);
            String s = sMap.get("sid") == null?null:sMap.get("sid").toString();
            String t = sMap.get("tid") == null?null:sMap.get("tid").toString();
            if(s!=null&& !s.equals("")){
                Map<String, Object> item = new HashMap<String, Object>();
                item.put("sid", s);
                item.put("tid", t);
                Map<String, Object> pMap = studentService.showStudentById(item);
                Map<String, Object> tMap = teacherService.showTeacherInfoById(item);
                if(param.get("grade").toString().equals(pMap.get("grade").toString())) {
                	sMap.putAll(pMap);
                	sMap.putAll(tMap);
                }
                //else ts.remove(i);
            }
         }
        List<Map<String,Object>> grade=studentService.showStudentGrade();
        model.addAttribute("TS",ts);
        model.addAttribute("TEA",tea);
        model.addAttribute("_stu",_stu);
        model.addAttribute("grade",grade);
        model.addAttribute("sgrade",param.get("grade"));
        return "Admin/ShuangxuanManage";
    }
    // 修改管理员页面
    @RequestMapping("admin_Update")
    public String setadminUpdate(HttpServletRequest request,Model model) {
        Map<String, Object> param = FormDataCollectUtil.getInstance()
                .getFormData(request);
        model.addAttribute("admin", adminService.showAdminInfo(param));
        return "Admin/admin_Update";
    }
    // 修改保存管理员信息方法
    @RequestMapping("updateAdmin")
    public void updateAdmin(HttpServletRequest request,
        HttpServletResponse response) {
        Map<String, Object> param = FormDataCollectUtil.getInstance()
            .getFormData(request);
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
            String str = adminService.updateAdmin(param);
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(str);
        } catch (Exception e) {
            log.error(e);
        }
    }
    // 新增管理员页面
    @RequestMapping("admin_Add")
    public String setadmin_Add(HttpServletResponse request,HttpServletResponse response) {
        return "Admin/admin_Add";
    }
    // 新增管理员方法
    @RequestMapping("adminAdd")
    public void adminAdd(HttpServletRequest request,HttpServletResponse response) {
        Map<String, Object> param = FormDataCollectUtil.getInstance()
                .getFormData(request);
        int result = adminService.exsitAdmin(param);
        if(result == 0) {
        	 Boolean xb;
             if ("1".equals(param.get("xb"))) {
                 xb = new Boolean(true);
             } else {
                 xb = new Boolean(false);
             }
             //System.out.println(xb);
             param.put("xb", xb);
             try {
                 String str = adminService.addAdmin(param);
                 response.setContentType("text/html;charset=utf-8");
                 response.getWriter().print(str);
             } catch (Exception e) {
                 log.error(e);
             }
        }else {
        	response.setContentType("text/html;charset=utf-8");
            try {
				response.getWriter().print("-1");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
    // 删除管理员方法
    @RequestMapping("deleteAdminById")
    public void deleteAdminById(HttpServletRequest request,HttpServletResponse response) {
        Map<String, Object> param = FormDataCollectUtil.getInstance()
            .getFormData(request);
        try {
            String str =adminService.deleteAdminById(param);
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(str);
        } catch (Exception e) {
            log.error(e);
        }

    }
    
    
    // 修改教师页面   
    @RequestMapping("teacher_Update")
    public String teacher_Update(HttpServletRequest request,Model model) {
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
        model.addAttribute("teacher",map);
        return "Admin/teacher_Update";
    }
    // 修改保存教师方法
    @RequestMapping("updateTeacher")
    public void saveTeacher(HttpServletRequest request,
        HttpServletResponse response) {
        Map<String, Object> param = FormDataCollectUtil.getInstance()
            .getFormData(request);
        Boolean xb;
        if ("1".equals(param.get("xb"))) {
            xb = new Boolean(true);
        } else {
            xb = new Boolean(false);
        }
        //System.out.println(xb);
        param.put("xb", xb);
        try {
            String str = adminService.updateTeacherByAdmin(param);
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(str);
        } catch (Exception e) {
            log.error(e);
        }
    }
    // 新增教师页面
    @RequestMapping("teacher_Add")
    public String setteacher_Add(HttpServletResponse request,HttpServletResponse response) {
        return "Admin/teacher_Add";
    }
    // 新增教师方法
    @RequestMapping("addTeacher")
    public void teacherAdd(HttpServletRequest request,HttpServletResponse response) {
        Map<String, Object> param = FormDataCollectUtil.getInstance()
                .getFormData(request);
        Boolean xb;
        if ("1".equals(param.get("xb"))) {
            xb = new Boolean(true);
        } else {
            xb = new Boolean(false);
        }
        param.put("xb", xb);
        try {
            String str = teacherService.addTeacher(param);
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(str);
        } catch (Exception e) {
            log.error(e);
        }
        
        
    }
    // 删除教师方法
    @RequestMapping("deleteTeacherById")
    public void deleteTeacherById(HttpServletRequest request,HttpServletResponse response) {
        Map<String, Object> param = FormDataCollectUtil.getInstance()
                .getFormData(request);
        try {
            String str = teacherService.deleteTeacherById(param);
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(str);
        } catch (Exception e) {
            log.error(e);
        }
        
    }
    // 修改学生页面   
    @RequestMapping("student_Update")
    public String student_Update(HttpServletRequest request,Model model) {
        Map<String, Object> param = FormDataCollectUtil.getInstance().getFormData(request);
        Map<String, Object> map = studentService.showStudentInfo(param);
        // 转换图片格式
        byte[] b = (byte[]) map.get("picture");
        if (b != null) {
            String picture = new String(b);
            // System.out.println(picture);
            map.put("picture", picture);
        }
        model.addAttribute("student", map );
        return "Admin/student_Update";
    }
    // 修改保存学生方法
    @RequestMapping("updateStudent")
    public void updateStudent(HttpServletRequest request,
        HttpServletResponse response) {
        Map<String, Object> param = FormDataCollectUtil.getInstance()
                .getFormData(request);
        Boolean xb;
        if ("1".equals(param.get("xb"))) {
            xb = new Boolean(true);
        } else {
            xb = new Boolean(false);
        }
       /* System.out.println(xb);*/
        param.put("xb", xb);
        try {
            String str = adminService.updateStudentByAdmin(param);
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(str);
        } catch (Exception e) {
            log.error(e);
        }
    }
   
    // 新增学生页面
    @RequestMapping("student_Add")
    public String setstudent_Add(HttpServletResponse request,HttpServletResponse response) {
        return "Admin/student_Add";
    }

    // 新增学生方法
    @RequestMapping("addStudent")
    public void saveStudent(HttpServletRequest request,
        HttpServletResponse response) {
        Map<String, Object> param = FormDataCollectUtil.getInstance()
            .getFormData(request);
        Boolean xb;
        if ("1".equals(param.get("xb"))) {
            xb = new Boolean(true);
        } else {
            xb = new Boolean(false);
        }
        //System.out.println(xb);
        param.put("xb", xb);
        try {
            String str = studentService.addStudent(param);
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(str);
        } catch (Exception e) {
            log.error(e);
        }
    }   
    //批量添加学生.xlsx
    @RequestMapping("addListStudent_xlsx")
	public void addListStudent_xlsx(@RequestParam MultipartFile file,Integer clientid,HttpServletRequest request,HttpServletResponse response) throws FileNotFoundException, IOException {
		
		
		List<Student> list = new ArrayList<Student>();
		XSSFWorkbook workbook =null;
		
		
		//把MultipartFile转化为File
		CommonsMultipartFile cmf= (CommonsMultipartFile)file;
		DiskFileItem dfi=(DiskFileItem) cmf.getFileItem();
		File fo = null;
		try {
		    fo=File.createTempFile("tmp", null);
		    file.transferTo(fo);
		    fo.deleteOnExit();        
		} catch (IOException e) {
		    e.printStackTrace();
		}
//		创建Excel，读取文件内容

		workbook = new XSSFWorkbook(new FileInputStream(fo));
		//获取第一个工作表
		XSSFSheet sheet = workbook.getSheetAt(0);
		//获取sheet中第一行行号
		int firstRowNum = sheet.getFirstRowNum();
		//获取sheet中最后一行行号
		int lastRowNum = sheet.getLastRowNum();
		try {
			//循环插入数据
			for(int i=firstRowNum+1;i<=lastRowNum;i++){
				XSSFRow row = sheet.getRow(i);
				
				Student student = new Student();		
				XSSFCell sno = row.getCell(0);//学号
				if(sno!=null){
					sno.setCellType(Cell.CELL_TYPE_STRING);
					student.setSno((sno.getStringCellValue()));
				}
				
				XSSFCell sname = row.getCell(1);//姓名
				if(sname!=null){
					sname.setCellType(Cell.CELL_TYPE_STRING);
					student.setSname((sname.getStringCellValue()));
				}
				
				XSSFCell password = row.getCell(2);//密码
				if(password!=null){
					password.setCellType(Cell.CELL_TYPE_STRING);
					student.setPassword((password.getStringCellValue()));
				}
				
				XSSFCell school = row.getCell(3);//学院
				if(school!=null){
					school.setCellType(Cell.CELL_TYPE_STRING);
					
					student.setSchool((school.getStringCellValue()));
				}
				XSSFCell career = row.getCell(4);//专业
				if(career!=null){
					career.setCellType(Cell.CELL_TYPE_STRING);
					
					student.setCareer((career.getStringCellValue()));
				}
				XSSFCell grade = row.getCell(5);//年级
				if(grade!=null){
					grade.setCellType(Cell.CELL_TYPE_STRING);
					
					student.setGrade((grade.getStringCellValue()));
				}
				XSSFCell sclass = row.getCell(6);//班级
				if(sclass!=null){
					sclass.setCellType(Cell.CELL_TYPE_STRING);
					System.out.println(sclass.getStringCellValue());
					student.setSclass((sclass.getStringCellValue()));
				}
				XSSFCell GPA = row.getCell(7);//绩点
				if(GPA!=null){
					GPA.setCellType(Cell.CELL_TYPE_STRING);
					System.out.println(GPA.getStringCellValue());
					student.setGPA((GPA.getStringCellValue()));
				}
				XSSFCell award = row.getCell(8);//奖项
				if(award!=null){
					award.setCellType(Cell.CELL_TYPE_STRING);
					
					student.setAward((award.getStringCellValue()));
				}
				XSSFCell xb = row.getCell(9);//性别
				if(xb!=null){
					xb.setCellType(Cell.CELL_TYPE_STRING);
					if(xb.getStringCellValue().equals("男"))	student.setXb(1);
					else student.setXb(0);
				}
				XSSFCell csrq = row.getCell(10);//出生日期
				if(csrq!=null){
//					csrq.setCellType(Cell.CELL_TYPE_STRING);
					student.setCsrq(csrq.getDateCellValue());
				}
				XSSFCell email = row.getCell(11);//邮箱
				if(email!=null){
					email.setCellType(Cell.CELL_TYPE_STRING);
					
					student.setEmail((email.getStringCellValue()));
				}
				XSSFCell hobby = row.getCell(12);//兴趣
				if(hobby!=null){
					hobby.setCellType(Cell.CELL_TYPE_STRING);
					
					student.setHobby((hobby.getStringCellValue()));
				}
				XSSFCell phone = row.getCell(13);//电话
				if(phone!=null){
					phone.setCellType(Cell.CELL_TYPE_STRING);
					
					student.setPhone((phone.getStringCellValue()));
				}
				XSSFCell phone2 = row.getCell(14);//备用电话
				if(phone2!=null){
					phone2.setCellType(Cell.CELL_TYPE_STRING);
					student.setPhone2((phone2.getStringCellValue()));
				}
				
				list.add(student);
			}
			for(Student x:list){
				if(!x.getSno().equals(""))
					studentService.addListStudent(x);
		    }
			response.getWriter().print("success");
			//usersMapper.insert(list);//往数据库插入数据
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		//	workbook.close();
		}

    }
  //批量添加学生.xls
    @RequestMapping("addListStudent_xls")
	public void addListStudent_xls(@RequestParam MultipartFile file,Integer clientid,HttpServletRequest request,HttpServletResponse response) throws FileNotFoundException, IOException {
		
		
		List<Student> list = new ArrayList<Student>();
		HSSFWorkbook workbook =null;
		
		
		//把MultipartFile转化为File
		CommonsMultipartFile cmf= (CommonsMultipartFile)file;
		DiskFileItem dfi=(DiskFileItem) cmf.getFileItem();
		File fo = null;
		try {
		    fo=File.createTempFile("tmp", null);
		    file.transferTo(fo);
		    fo.deleteOnExit();        
		} catch (IOException e) {
		    e.printStackTrace();
		}

//		创建Excel，读取文件内容

		workbook = new HSSFWorkbook(new FileInputStream(fo));
		//获取第一个工作表
		HSSFSheet sheet = workbook.getSheetAt(0);
		//获取sheet中第一行行号
		int firstRowNum = sheet.getFirstRowNum();
		//获取sheet中最后一行行号
		int lastRowNum = sheet.getLastRowNum();
		try {
			//循环插入数据
			for(int i=firstRowNum+1;i<=lastRowNum;i++){
				HSSFRow row = sheet.getRow(i);
				
				Student student = new Student();		
				HSSFCell sno = row.getCell(0);//学号
				if(sno!=null){
					sno.setCellType(Cell.CELL_TYPE_STRING);
					student.setSno((sno.getStringCellValue()));
				}
				
				HSSFCell sname = row.getCell(1);//姓名
				if(sname!=null){
					sname.setCellType(Cell.CELL_TYPE_STRING);
					student.setSname((sname.getStringCellValue()));
				}
				
				HSSFCell password = row.getCell(2);//密码
				if(password!=null){
					password.setCellType(Cell.CELL_TYPE_STRING);
					student.setPassword((password.getStringCellValue()));
				}
				
				HSSFCell school = row.getCell(3);//学院
				if(school!=null){
					school.setCellType(Cell.CELL_TYPE_STRING);
					
					student.setSchool((school.getStringCellValue()));
				}
				HSSFCell career = row.getCell(4);//专业
				if(career!=null){
					career.setCellType(Cell.CELL_TYPE_STRING);
					
					student.setCareer((career.getStringCellValue()));
				}
				HSSFCell grade = row.getCell(5);//年级
				if(grade!=null){
					grade.setCellType(Cell.CELL_TYPE_STRING);
					
					student.setGrade((grade.getStringCellValue()));
				}
				HSSFCell sclass = row.getCell(6);//班级
				if(sclass!=null){
					sclass.setCellType(Cell.CELL_TYPE_STRING);
					
					student.setSclass((sclass.getStringCellValue()));
				}
				HSSFCell GPA = row.getCell(7);//绩点
				if(GPA!=null){
					GPA.setCellType(Cell.CELL_TYPE_STRING);
					student.setGPA((GPA.getStringCellValue()));
				}
				HSSFCell award = row.getCell(8);//奖项
				if(award!=null){
					award.setCellType(Cell.CELL_TYPE_STRING);
					
					student.setAward((award.getStringCellValue()));
				}
				HSSFCell xb = row.getCell(9);//性别
				if(xb!=null){
					xb.setCellType(Cell.CELL_TYPE_STRING);
					if(xb.getStringCellValue().equals("男"))	student.setXb(1);
					else student.setXb(0);
				}
				HSSFCell csrq = row.getCell(10);//出生日期
				if(csrq!=null){
//					csrq.setCellType(Cell.CELL_TYPE_STRING);
					student.setCsrq(csrq.getDateCellValue());
				}
				HSSFCell email = row.getCell(11);//邮箱
				if(email!=null){
					email.setCellType(Cell.CELL_TYPE_STRING);
					
					student.setEmail((email.getStringCellValue()));
				}
				HSSFCell hobby = row.getCell(12);//兴趣
				if(hobby!=null){
					hobby.setCellType(Cell.CELL_TYPE_STRING);
					
					student.setHobby((hobby.getStringCellValue()));
				}
				HSSFCell phone = row.getCell(13);//电话
				if(phone!=null){
					phone.setCellType(Cell.CELL_TYPE_STRING);
					
					student.setPhone((phone.getStringCellValue()));
				}
				HSSFCell phone2 = row.getCell(14);//备用电话
				if(phone2!=null){
					phone2.setCellType(Cell.CELL_TYPE_STRING);
					student.setPhone2((phone2.getStringCellValue()));
				}
				
				list.add(student);
			}
			for(Student x:list){
				if(!x.getSno().equals(""))
					studentService.addListStudent(x);
		    }
			response.getWriter().print("success");
			//usersMapper.insert(list);//往数据库插入数据
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		//	workbook.close();
		}

    }
    // 删除学生方法
    @RequestMapping("deleteStudentById")
    public void deleteStudentById(HttpServletRequest request,HttpServletResponse response) {
        Map<String, Object> param = FormDataCollectUtil.getInstance()
                .getFormData(request);
        try {
            String str = studentService.deleteStudentById(param);
           /* if(("1").equals(str)){
                String d = adminService.deleteTSById(param);
            }*/
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(str);
        } catch (Exception e) {
            log.error(e);
        }
        
    }
    // 上传模板
    @RequestMapping("/templateUpload")
    public String templateUpload(@RequestParam("imagefile") MultipartFile imageFile,
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
            updatefile = new HashMap<>();
            flag = true;
            dir.mkdirs();// 创建目录
        }
        // 判断传入什么类型文档，并将文件名传入一个map中
        String type = param.get("type").toString();
        int i = Integer.parseInt(type);
        switch (i) {
        case 1:
            //System.out.println(1);
            updatefile.put("GraduationDesignManual", filename);
            break;
        case 2:
            //System.out.println(2);
            updatefile.put("ScoreTable", filename);
            break;
        case 3:
            //System.out.println(3);
            updatefile.put("ReplyRecord", filename);
            break;
        case 4:
            //System.out.println(4);
            updatefile.put("OpeningReportTemplate", filename);
            break;
        case 5:
            //System.out.println(5);
            updatefile.put("Other", filename);
            break;
        default:
            //System.out.println(0);
        }
        if (flag) {
            paperService.addTemplate(updatefile);
            // 新增到数据库
            //System.out.println("新增文件上传到: " + uploadUrl +  File.separator + filename);
        } else {
            paperService.updateTemplate(updatefile);
            // 储存并更新数据库
            //System.out.println("更新文件上传到: " + uploadUrl + File.separator + filename);
        }

        File targetFile = new File(uploadUrl  + File.separator + filename);
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
    // 文档管理详细页面
    @RequestMapping("files_detailed")
    public String setfiles_detailed(HttpServletRequest request,Model model) {
        Map<String, Object> param = FormDataCollectUtil.getInstance()
                .getFormData(request);
        model.addAttribute("student", studentService.showStudentInfo(param));
        model.addAttribute("files",paperService.showFiles(param));
        return "Admin/files_detailed";
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
    // 修改双选表
    @RequestMapping("updateTS")
    public void updateTS(HttpServletRequest request, HttpServletResponse response) {
        
        Map<String, Object> param = FormDataCollectUtil.getInstance().getFormData(request);
        //获取原纪录中数据
        Map<String, Object> ts = adminService.showStudentAndTeacherOneById(param);
        ts.put("tno", param.get("tno"));
        try {
            String str = adminService.updateTS(ts);
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(str);
        } catch (Exception e) {
            log.error(e);
        }
    }
    // 增加一条双选表信息
    @RequestMapping("addTS")
    public void addTS(HttpServletRequest request, HttpServletResponse response) {
    	
    	Map<String, Object> param = FormDataCollectUtil.getInstance().getFormData(request);
    	//获取原纪录中数据
    	param.put("stime", new Date());
    	try {
    		String str = adminService.insertTS(param);
    		response.setContentType("text/html;charset=utf-8");
    		response.getWriter().print(str);
    	} catch (Exception e) {
    		log.error(e);
    	}
    }    
    //修改功能对应的年级
    @RequestMapping("updategrade")
    public void updategrade(HttpServletRequest request, HttpServletResponse response) {
    	Map<String, Object> param = FormDataCollectUtil.getInstance().getFormData(request);
    	String t=param.get("type").toString();
    	if(t.equals("a"))AdminController.setYear(Integer.parseInt(param.get("a_grade").toString()));
    	else AdminController.setYear_t(Integer.parseInt(param.get("b_grade").toString()));
    	try {
			response.getWriter().print(1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    //下载录入模板
    @RequestMapping("modelExcel")
    public void modelExcel(HttpServletRequest request, HttpServletResponse response) {
    	String filePath = request.getSession().getServletContext()
                .getRealPath("/WEB-INF/");
            String downLoadPath = filePath + File.separator +"成绩模板.xlsx";
            java.io.BufferedInputStream bis = null;
            try {
                long fileLength = new File(downLoadPath).length();
                response.reset();
                response.setHeader("Content-Disposition", "attachment; filename="
                    +URLEncoder.encode("录入模板.xlsx", "UTF-8"));
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
