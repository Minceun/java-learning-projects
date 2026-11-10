package com.spring.mapper;

import java.util.List;
import java.util.Map;

import com.common.util.Student;

public interface StudentMapper {
	/*	 
     *   <p>【显示用户详细信息】</p>
     *
     * @author  曾彬利 
     *
     * @param param
     * @return
     */
	Map<String, Object> showStudentInfo(Map<String, Object> param);
	/*	 
	 *   <p>【通过id显示用户详细信息】</p>
	 *
	 * @author  曾彬利 
	 *
	 * @param param
	 * @return
	 */
	Map<String, Object> showStudentById(Map<String, Object> param);

	/*	 
     *   <p>【修改学生信息】</p>
     *
     * @author  曾彬利 
     *
     * @param param
     * @return
     */
	void updateStudentByStu(Map<String, Object> param);
	/*  
     *   <p>【新增学生信息】</p>
     *
     * @author  曾彬利 
     *
     * @param param
     * @return
     */
	void addListStudent(Student student);
	/*
	 * 批量添加学生
	 */
	void addStudent(Map<String, Object> param);
	/*  
	 *   <p>【删除学生信息】</p>
	 *
	 * @author  曾彬利 
	 *
	 * @param param
	 * @return
	 */
	void deleteStudentById(Map<String, Object> param);
	/*  
     *   <p>【校验学生信息】</p>
     *
     * @author  曾彬利 
     *
     * @param param
     * @return
     */
	int check_Student(Map<String, Object> param);
	List<Map<String, Object>> showStudentGrade();
	


}
/*List<Map<String, Object>> getStudentList(Map<String, Object> map);


int countStudentTotal();    

int countStudentTotalWithState(Map<String, Object> map);

List<Map<String, Object>> getStudentListWithState(Map<String, Object> map);

void updateStudentState(Map<String, Object> param);

List<Map<String, Object>> checkStudent(Map<String, Object> param);

List<Map<String, Object>> checkTeacher(Map<String, Object> param);*/
