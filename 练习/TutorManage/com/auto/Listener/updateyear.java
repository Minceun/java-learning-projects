package com.auto.Listener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.spring.controller.AdminController;


@Component
public class updateyear {
/*	//每年9月1日修改年级信息
	@Scheduled(cron="0 0 0 1 9 ? ")//日期（秒，分，时，日，月，星期，年）
	public void update_y() {
		Calendar c=Calendar.getInstance();
		int year=c.get(Calendar.YEAR);
//		int month=c.get(Calendar.MONTH);
//		int day=c.get(Calendar.DAY_OF_MONTH);
		AdminController.setYear(year-3);//年级为当前年-3
		System.out.println(AdminController.getYear());
	}*/
}
