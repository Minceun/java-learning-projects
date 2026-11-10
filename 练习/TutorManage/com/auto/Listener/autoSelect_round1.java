package com.auto.Listener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.controller.AdminController;
import com.spring.mapper.AdminMapper;
import com.spring.service.AdminService;
@Component
public class autoSelect_round1 extends TimerTask{
	
	@Autowired
	private AdminService adminservice;
	
	private static autoSelect_round1 autoselect;
	@PostConstruct
    public void init() {
        autoselect = this;
    }
	public void run() {
		int grade=AdminController.getYear();
		autoselect.adminservice.update_lowGPA(grade);
		List<Map<String,Object>> round_teacher=autoselect.adminservice.getRoundTeacher(grade);//获取第一轮被选中教师
		for(int i=0;i<round_teacher.size();i++) {
			String ground1_teacher = round_teacher.get(i).get("ROUND1").toString();//获取教师ID
			int tea_num=autoselect.adminservice.getTeacherNum(ground1_teacher);//获取教师剩余选择数量
			Map<String,Object> tmap=new HashMap<String,Object>();
			tmap.put("tid", ground1_teacher);
			tmap.put("grade", grade);
			int stu_num=autoselect.adminservice.getStudentNum(tmap);//获取选择该导师学生总数
			if(tea_num<=0)break;//没有名额不做选择 跳过
			else if(tea_num>stu_num){//剩余名额>学生总数  == 选择所有学生
				List<Map<String,Object>> teacher_stu=autoselect.adminservice.getStudentId_round1(tmap);//获取选中该教师学生ID
				for(int j=0;j<teacher_stu.size();j++) {
					String stu_id=teacher_stu.get(j).get("sid").toString();
					SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm");
					Date date=new Date();
					String stime=s.format(date);
					Map<String,Object> map=new HashMap<String,Object>();
					map.put("sid", stu_id);
					map.put("tid", ground1_teacher);
					map.put("stime", stime);
					map.put("num", -1);
					autoselect.adminservice.Tselect(map);
				}
			}
			else if(tea_num==stu_num){
				int lowGPA_ts=autoselect.adminservice.getlowGPA_ts(tmap);
				int lowGPA_select=autoselect.adminservice.getlowGPA_select1(tmap);
				//可选人数=备选人数，且已选中有带*学生或者列表中有带*学生  -> 全部选择
				if(lowGPA_ts>0||lowGPA_select>0) {
					List<Map<String,Object>> teacher_stu=autoselect.adminservice.getStudentId_round1(tmap);//获取选中该教师学生ID
					for(int j=0;j<teacher_stu.size();j++) {
						String stu_id=teacher_stu.get(j).get("sid").toString();
						SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm");
						Date date=new Date();
						String stime=s.format(date);
						Map<String,Object> map=new HashMap<String,Object>();
						map.put("sid", stu_id);
						map.put("tid", ground1_teacher);
						map.put("stime", stime);
						map.put("num", -1);
						autoselect.adminservice.Tselect(map);
					}
				}
			}
			else {
				int lowGPA_ts=autoselect.adminservice.getlowGPA_ts(tmap);
				int lowGPA_select=autoselect.adminservice.getlowGPA_select1(tmap);
				//可选名额不足，且已选带*学生  或被选列表无带*学生  ->不作处理
				if(lowGPA_ts>0||lowGPA_select==0)continue;
				//可选名额不足，且当前没有选择带*学生   并且被选列表有且只有一个带*学生   ->自动选中该学生
				else if(lowGPA_select==1){
					String sid=autoselect.adminservice.getlowGPA_sid1(tmap);
					SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm");
					Date date=new Date();
					String stime=s.format(date);
					Map<String,Object> map=new HashMap<String,Object>();
					map.put("sid", sid);
					map.put("tid", ground1_teacher);
					map.put("stime", stime);
					map.put("num", -1);
					autoselect.adminservice.Tselect(map);
				}
			}
		}
		
		this.cancel();		
	}
//		AdminController.setYear(sec);

}
