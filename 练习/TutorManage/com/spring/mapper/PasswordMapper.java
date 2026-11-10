package com.spring.mapper;
import java.util.List;
import java.util.Map;

public interface PasswordMapper {
	
	/*更新导师的密码*/
	public void updateTeacherPassword(Map<String,Object> map);
	
	
	/*更新学生的密码*/
	public void updateStudentPassword(Map<String,Object> map);
	
	
}
