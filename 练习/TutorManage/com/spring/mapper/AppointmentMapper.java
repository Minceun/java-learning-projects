package com.spring.mapper;

import java.util.List;
import java.util.Map;

public interface AppointmentMapper {
	
	/*增加一条学生预约导师记录*/
	void addAppointment(Map<String,Object> param);
	
	/*删除导师某一时间的预约记录*/
	void deleteAppointment(Map<String,Object> param);
	
	/*查询当前学生与导师的预约次数*/
	int selectNumByTidAndSid(Map<String,Object> param);
	
	/*查询是否存在一条记录*/
	int isExistARecord(Map<String,Object> param);
	
	/*查询导师的学生的预约情况 */
	List<Map<String,Object>> selectAppointmentByTid(Map<String,Object> param);
	
	/*根据学号查询该名学生的有效预约记录*/
	List<Map<String,Object>> selectAppointmentBySid(Map<String,Object> param);
}
