package com.spring.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ScheduleMapper {
	
	/*插入一条schedule记录*/
	void addSchedule(Map<String,Object> param);
	
	/*更新一条schedule记录*/
	void updateSchedule(Map<String,Object> param);
	
	/*根据教工号查询教师行程信息*/
	List<Map<String,Object>> selectScheduleAllByTid(Map<String,Object> param);
	
	/*删除所有Schedule表中记录*/
	void deleteAllSchedule(Map<String,Object> param);
	
	/*根据日期查询当前周数*/
	int selectWeekByDate(Map<String,Object> param);
	
	/*根据教师id及当前周数查询教师本周所有日程安排*/
	List<Map<String,Object>> selectWeekInfoByTid(Map<String,Object> param);
	
	/*查询该名教师Schedule中的记录条数*/
	int selectNumByTid(Map<String,Object> param);
	
	/*根据tid删除Schedule表中记录*/
	void deleteScheduleByTid(Map<String,Object> param);
	
	/*查询教师和学生存在的有效预约*/
	int selectNumByTidAndSid(Map<String,Object> param);
	
	/*查询当前周的日期数*/
	List<String> selectWeekInfo(Map<String,Object> param);
	
	/*查询教师某日程类型*/
	int selectAffairTypeByTid(Map<String,Object> param);
}