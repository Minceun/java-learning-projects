package com.auto.Listener;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.spring.controller.AdminController;

public class listener implements ServletContextListener{
//	private Timer timer=null;
	//项目启动时执行
	public void contextInitialized(ServletContextEvent arg0) {
////		Date date=new Date();
////		SimpleDateFormat dateformat=new SimpleDateFormat("yyyy/mm/dd hh:mm:ss");		
//		
//		timer=new Timer(true);
//		//设置执行时间
//        Calendar calendar =Calendar.getInstance();
//        int year = calendar.get(Calendar.YEAR);
//        int month = calendar.get(Calendar.MONTH);
//        int day =calendar.get(Calendar.DAY_OF_MONTH);//每天
//        int m=calendar.get(Calendar.MINUTE);
//        //定制每天的1:00:00执行，
////        calendar.set(year, month, day, 15,m+2, 00);
//        Date date = calendar.getTime();
////        System.out.println(date);
//
//        int period = 24 * 60 * 60 * 1000;
//        //每天的date时刻执行task，每隔persion 时间重复执行
//        timer.schedule(new autoDo(), date, 5000);
		//判断日期并修改年级
		Calendar c=Calendar.getInstance();
		int year=c.get(Calendar.YEAR);
		int month=c.get(Calendar.MONTH);
		int day=c.get(Calendar.DAY_OF_MONTH);
		if(month>=0&&month<8) {
			AdminController.setYear(year-4);//1-8月为下半学期，年级为当前年-4
			AdminController.setYear_t(year-4);
		}
		else {
			AdminController.setYear(year-3);//9-12月为上半学期，年级为当前年-3
			AdminController.setYear_t(year-3);
		}
	}
	public void contextDestroyed(ServletContextEvent arg0){
//        timer.cancel();
    }
}
