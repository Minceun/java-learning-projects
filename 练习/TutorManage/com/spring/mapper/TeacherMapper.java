package com.spring.mapper;

import java.util.List;
import java.util.Map;

public interface TeacherMapper {
	/*	 
     *   <p>【根据显示教师详细信息】</p>
     *
     * @author  崔玉龙
     *
     * @param param
     * @return
     */	
	Map<String, Object> showTeacherInfoById(Map<String, Object> param);
	/*	 
	 *   <p>【根据教工号显示教师详细信息】</p>
	 *
	 * @author  曾彬利 
	 *
	 * @param param
	 * @return
	 */
	Map<String, Object> showTeacherInfo(Map<String, Object> param);
	/*	 
     *   <p>【修改教师信息】</p>
     *
     * @author  曾彬利 
     *
     * @param param
     * @return
     */
	void updateTeacherByTea(Map<String, Object> param);
	
	/*
	 * <p> 【修改可选指导学生数】 </p>
	 * 
	 * 
	 */
	void updateNum(Map<String, Object> param);
	/*	 
	 *   <p>【教师汇总，修改学生信息】</p>
	 *
	 * @author  曾彬利 
	 *
	 * @param param
	 * @return
	 */
	void updateSummary(Map<String, Object> param);
	/*  
     *   <p>【新增教师信息】</p>
     *
     * @author  曾彬利 
     *
     * @param param
     * @return
     */
	void addTeacher(Map<String, Object> param);
	/*  
	 *   <p>【删除教师信息】</p>
	 *
	 * @author  曾彬利 
	 *
	 * @param param
	 * @return
	 */
	void deleteTeacherById(Map<String, Object> param);


	/* 
	 * 校验教师
	 */
	
	int check_Teacher(Map<String, Object> param);
	
	   /*   
     *   <p>【显示论文详细信息】</p>
     *
     * @author  曾彬利 
     *
     * @param param
     * @return
     */
    Map<String, Object> showPaperInfo(Map<String, Object> param);
    /*   
     *   <p>【显示所有教师信息】</p>
     *
     * @author  曾彬利 
     *
     * @param param
     * @return
     */
    List<Map<String, Object>>  showTeacherAll(Map<String, Object> param);
    /*   
     *   <p>【显示所有学生信息】</p>
     *
     * @author  曾彬利 
     *
     * @param param
     * @return
     */
    List<Map<String, Object>>  showStudentAll(Map<String, Object> param);
	
	List<Map<String, Object>> showStudentbygrade(Map<String,Object> param);
	/*
	 * 根据年级查询学生
	 */
    
    
    
//  List<Map<String, Object>> getTeacherList(Map<String, Object> map);
//
//  int countTeacherTotal();    
//
//  int countTeacherTotalWithState(Map<String, Object> map);
//
//  List<Map<String, Object>> getTeacherListWithState(Map<String, Object> map);
//
//  void updateTeacherState(Map<String, Object> param);
}
